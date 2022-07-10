package com.blogging.sanit.payloads;

import com.blogging.sanit.entities.Post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
	

	private Integer id;
	
	private String content;
}
