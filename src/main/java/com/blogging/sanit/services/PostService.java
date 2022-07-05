package com.blogging.sanit.services;

import java.util.List;


import com.blogging.sanit.payloads.PostDto;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get All post
	List<PostDto> getAllPosts();
	
	
	//get post by id
	PostDto getPostById(Integer postId);
	
	
	//get all post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	
	// get all posts by user
	List<PostDto> getPostsByUser(Integer userId);
	
	
	//search posts
	List<PostDto> searchPosts(String keyword);
	
	
	

}
