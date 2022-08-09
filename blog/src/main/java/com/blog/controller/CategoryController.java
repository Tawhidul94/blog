package com.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entity.Category;
import com.blog.payload.ApiResponse;
import com.blog.payload.CategoryDto;
import com.blog.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired CategoryService categoryService;
	
	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> saveCategory(@RequestBody CategoryDto categoryDto){
		CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);	
	}
	
	
	//update
	@PutMapping("/{catagoryId}")
	public ResponseEntity<CategoryDto> UpdateCategory(@RequestBody CategoryDto categoryDto , @PathVariable Integer catagoryId){
		CategoryDto createCategory = this.categoryService.updateCategory(categoryDto, catagoryId);
		return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);	
	}
	
	//delete
	@DeleteMapping("/{catagoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable  Integer catagoryId){
		this.categoryService.deleteCategory(catagoryId);
		return new ResponseEntity(new ApiResponse("delete Category  succssfully",true), HttpStatus.OK);
	}
	
	//find single
	@GetMapping("/{catagoryId}")
	public ResponseEntity<CategoryDto> grtSingleUser(@PathVariable Integer catagoryId){
		return ResponseEntity.ok(this.categoryService.getCategory(catagoryId));
	}
	
	//find alll
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getAllcategory(){
		return ResponseEntity.ok(this.categoryService.getAllCategory());
	}
	
	

}
