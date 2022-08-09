package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.Category;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.CategoryDto;
import com.blog.repojetoris.CategoryRepo;
import com.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired private CategoryRepo categoryRepo;
	@Autowired private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category =this.modelMapper.map(categoryDto, Category.class);
		Category addCategory=this.categoryRepo.save(category);
		return this.modelMapper.map(addCategory,CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer catagoryId) {
		Category category=this.categoryRepo.findById(catagoryId).orElseThrow(() -> 
		new ResourceNotFoundException("Category", "catagory Id", catagoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescrtion(categoryDto.getCategoryDescrtion());
		Category updateCategory=this.categoryRepo.save(category);
		return this.modelMapper.map(updateCategory,CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer catagoryId) {
		Category cat=this.categoryRepo.findById(catagoryId).orElseThrow(() -> 
		new ResourceNotFoundException("Category", "catagory Id", catagoryId));
		this.categoryRepo.delete(cat);

		
	}

	@Override
	public CategoryDto getCategory(Integer catagoryId) {
		Category cat=this.categoryRepo.findById(catagoryId).orElseThrow(() -> 
		new ResourceNotFoundException("Category", "catagory Id", catagoryId));
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> cateDto = categories.stream()
				.map((cat) ->this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
		return cateDto;
	}

}
