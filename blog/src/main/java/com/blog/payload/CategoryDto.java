package com.blog.payload;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private int catagoryId;
	
	@NotEmpty(message = "category title is required")
	private String categoryTitle;
	
	@NotEmpty(message = "cateory description is required")
	private String categoryDescrtion;
}
