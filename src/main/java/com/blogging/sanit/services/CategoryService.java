package com.blogging.sanit.services;

import java.util.List;

import com.blogging.sanit.payloads.CategoryDto;

public interface CategoryService {
	
	//create 
	CategoryDto createCategory(CategoryDto categoryDto);
	//update
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);
	//delete
	void deleteCategory( Integer categoryId);
	//get
	CategoryDto getCategoryById(Integer categoryId);
	//get all
	List<CategoryDto> getAllCategories();
}
