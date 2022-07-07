package com.blogging.sanit.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.blogging.sanit.entities.Category;
import com.blogging.sanit.entities.Post;
import com.blogging.sanit.entities.User;
import com.blogging.sanit.exceptions.ResourceNotFoundException;

import com.blogging.sanit.payloads.PostDto;
import com.blogging.sanit.payloads.PostResponse;
import com.blogging.sanit.repositories.CategoryRepo;
import com.blogging.sanit.repositories.PostRepo;
import com.blogging.sanit.repositories.UserRepo;
import com.blogging.sanit.services.PostService;


@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {
		
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User ", "user Id", userId));
		
		Category category=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category ", "Category Id", categoryId));
		
		Post post=this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		
		post.setUser(user);
		post.setCategory(category);
		
		Post createdPost=this.postRepo.save(post);
		return this.modelMapper.map(createdPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		
		Post post=this.postRepo.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("post ", "post id", postId));
		
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost= this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {


		Post post=this.postRepo.findById(postId)
				.orElseThrow(()->new ResourceNotFoundException("post ", "post id", postId));
		this.postRepo.delete(post);
		
		

	}

	@Override
	public PostResponse getAllPosts(Integer pageNumber, Integer pageSize) {
		
		
		Pageable pageable= PageRequest.of(pageNumber, pageSize);
		Page<Post> pagePost=this.postRepo.findAll(pageable);
		List<Post> allPost=pagePost.getContent();
		
		List<PostDto> postsDto= allPost.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		
		PostResponse postResponse=new PostResponse();
		postResponse.setContent(postsDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLast(pagePost.isLast());
		return postResponse;
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post=this.postRepo.findById(postId)
				.orElseThrow(()-> new ResourceNotFoundException("Post ", "post id", postId));
		
		
				
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId,Integer pageNumber, Integer pageSize) {
		
		
		
		Category category=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category ", "category id", categoryId));
		List<Post> posts= this.postRepo.findByCategory(category);
		List<PostDto> postsDto= posts.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postsDto;
	}

	@Override
	public PostResponse getPostsByUser(Integer userId,Integer pageNumber, Integer pageSize) {
		User user=this.userRepo.findById(userId)
				.orElseThrow(()->new ResourceNotFoundException("User ", "User id", userId));
		Pageable pageable=PageRequest.of(pageNumber, pageSize);
		Page<Post> pagePost= this.postRepo.findByUserId(userId, pageable);
		
		List<Post> allPost=pagePost.getContent();
		
		//List<Post> posts= this.postRepo.findByUser(user);
		List<PostDto> postsDto= allPost.stream().map((post)-> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		PostResponse postResponse=new PostResponse();
		postResponse.setContent(postsDto);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLast(pagePost.isLast());
		return postResponse;
		
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
