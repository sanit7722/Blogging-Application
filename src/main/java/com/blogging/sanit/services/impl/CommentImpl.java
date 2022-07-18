package com.blogging.sanit.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogging.sanit.entities.Comment;
import com.blogging.sanit.entities.Post;
import com.blogging.sanit.exceptions.ResourceNotFoundException;
import com.blogging.sanit.payloads.CommentDto;

import com.blogging.sanit.repositories.CommentsRepo;
import com.blogging.sanit.repositories.PostRepo;
import com.blogging.sanit.services.CommentService;


@Service
public class CommentImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentsRepo commentsRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		
		Post post=this.postRepo.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("Post ", "post id", postId));
		
		Comment comment= this.modelMapper.map(commentDto,Comment.class);
		comment.setPost(post);
		Comment savedComment= this.commentsRepo.save(comment);
		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
		Comment comment= this.commentsRepo.findById(commentId)
				.orElseThrow(()->new ResourceNotFoundException("Comment ", "commemnt id", commentId));
		this.commentsRepo.delete(comment);

	}

}
