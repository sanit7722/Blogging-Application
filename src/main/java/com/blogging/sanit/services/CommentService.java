package com.blogging.sanit.services;

import com.blogging.sanit.payloads.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto, Integer postId);
	void deleteComment(Integer commentId);
}
