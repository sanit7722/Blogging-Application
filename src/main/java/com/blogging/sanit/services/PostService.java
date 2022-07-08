package com.blogging.sanit.services;

import java.util.List;


import com.blogging.sanit.payloads.PostDto;
import com.blogging.sanit.payloads.PostResponse;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);
	
	//update
	
	PostDto updatePost(PostDto postDto, Integer postId);
	
	//delete
	
	void deletePost(Integer postId);
	
	//get All post
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortByType);
	
	
	//get post by id
	PostDto getPostById(Integer postId);
	
	
	//get all post by category
	PostResponse getPostsByCategory(Integer categoryId,Integer pageNumber, Integer pageSize);
	
	
	// get all posts by user
	PostResponse getPostsByUser(Integer userId,Integer pageNumber, Integer pageSize);
	
	
	//search posts
	List<PostDto> searchPosts(String keyword);
	
	
	

}
