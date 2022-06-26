package com.blog.payload;

import lombok.Data;

@Data
public class UserDto {
	
	private int id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String about;

}
