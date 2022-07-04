package com.blogging.sanit.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private int categoryId;
	
	@NotBlank
	@Size(min=3, max=10,message = "Minimum size of Category Title is 3")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10,message = "Minimum size of Category Description is 10")
	private String categoryDescription;

}
