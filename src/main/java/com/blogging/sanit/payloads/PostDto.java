package com.blogging.sanit.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotBlank;

import com.blogging.sanit.entities.Comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private Integer postId;
	
	@NotBlank
	private String title;
	
	@NotBlank
	private String content;
	
	
	private String imageName;
	
	
	private Date addedDate;
	
	
	private CategoryDto category;
	 
	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>();
	
	

}
