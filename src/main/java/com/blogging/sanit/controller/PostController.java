package com.blogging.sanit.controller;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.hibernate.engine.jdbc.StreamUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.blogging.sanit.config.AppConstants;
import com.blogging.sanit.payloads.ApiResponse;
import com.blogging.sanit.payloads.PostDto;
import com.blogging.sanit.payloads.PostResponse;
import com.blogging.sanit.services.FileService;
import com.blogging.sanit.services.PostService;

@RestController
@RequestMapping("/api/")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private FileService fileService;
	
	@Value("${project.image}")
	private String path;
	
	
	// create post
	
	@PostMapping("/user/{userId}/category/{categoryId}/posts")
	public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto, @PathVariable Integer userId, @PathVariable Integer categoryId){
		
		PostDto createdPost= this.postService.createPost(postDto, userId, categoryId);
		
		return new ResponseEntity<PostDto>(createdPost,HttpStatus.CREATED);
	}
	
	
	//get by user
	@GetMapping("/user/{userId}/posts")
	public ResponseEntity<PostResponse> getPostByUser(@PathVariable Integer userId,
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortByType", defaultValue =AppConstants.SORT_TYPE, required = false) String sortByType
			){
		
		PostResponse posts=this.postService.getPostsByUser(userId, pageNumber, pageSize,sortBy,sortByType);
		//List<PostDto> posts= this.postService.getPostsByUser(userId,pageNumber,pageSize);
		return new ResponseEntity<PostResponse>(posts,HttpStatus.OK);
	}
	
	
	
	//get by category
	@GetMapping("/category/{categoryId}/posts")
	public ResponseEntity<PostResponse> getPostByCategory(@PathVariable Integer categoryId,
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortByType", defaultValue =AppConstants.SORT_TYPE, required = false) String sortByType
			){
		
		PostResponse posts=this.postService.getPostsByCategory(categoryId, pageNumber, pageSize,sortBy,sortByType);
		return new ResponseEntity<PostResponse>(posts,HttpStatus.OK);
	}
	
	//get all post
	@GetMapping("/posts")
	public ResponseEntity<PostResponse> getAllPost(
			@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER,required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
			@RequestParam(value = "sortBy", defaultValue = AppConstants.SORT_BY, required = false) String sortBy,
			@RequestParam(value = "sortByType", defaultValue =AppConstants.SORT_TYPE, required = false) String sortByType
			){
		
		PostResponse posts= this.postService.getAllPosts(pageNumber,pageSize,sortBy,sortByType);
		return new ResponseEntity<PostResponse>(posts,HttpStatus.OK);
	}
	
	
	//get post by id
	@GetMapping("/posts/{postId}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
		
		PostDto postDto= this.postService.getPostById(postId);
		return new ResponseEntity<PostDto>(postDto,HttpStatus.OK);
	}
	
	
	//delete post
	@DeleteMapping("/posts/{postId}")
	public ApiResponse deletePost(@PathVariable Integer postId) {
		this.postService.deletePost(postId);
		return new ApiResponse("Post deleted successfully", true);
	}
	
	//update post
	
	@PutMapping("/posts/{postId}")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId){
		
		PostDto updatdPost= this.postService.updatePost(postDto, postId);
		
		return new ResponseEntity<PostDto>(updatdPost,HttpStatus.OK);
	}
	
	//search
	@GetMapping("/posts/search/{keywords}")
	public ResponseEntity<List<PostDto>> searchPostByTitle(@PathVariable String keywords){
		List<PostDto> results= this.postService.searchPosts(keywords);
		return new ResponseEntity<List<PostDto>>(results, HttpStatus.OK);
	}
	
	 
	//post image upload
	
	@PostMapping("/post/image/upload/{postId}")
	public ResponseEntity<PostDto> uploadPostImage(
			@PathVariable Integer postId,
			@RequestParam("image") MultipartFile image) throws IOException{
		
		PostDto postDto= this.postService.getPostById(postId);
		String fileName= this.fileService.uploadImage(path, image);
		postDto.setImageName(fileName);
		PostDto updatedPost= this.postService.updatePost(postDto, postId);
		return new ResponseEntity<PostDto>(updatedPost,HttpStatus.OK);
	
	}
	
	//serve image method
	@GetMapping(value = "/post/image/{imageName}", produces=MediaType.IMAGE_JPEG_VALUE)
	public void downloadImage(@PathVariable String imageName, HttpServletResponse response)throws IOException {
		
		InputStream reource=this.fileService.getResource(path, imageName);
		response.setContentType(imageName);
		StreamUtils.copy(reource, response.getOutputStream());
	}
	
	

}
