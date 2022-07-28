package com.blog.services;

import java.util.List;

import com.blog.payload.CategoryDto;

public interface CategoryService {
	
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	public CategoryDto updateCategory(CategoryDto categoryDto,Integer catagoryId);
	
	public void deleteCategory(Integer catagoryId);
	
	public CategoryDto getCategory(Integer catagoryId);
	
	public List<CategoryDto> getAllCategory();
}
