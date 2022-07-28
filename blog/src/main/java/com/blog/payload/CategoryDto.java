package com.blog.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer catagoryId;
	
	private String categoryTitle;
	
	private String categoryDescrtion;
}
