package com.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UserDto {
	
	private int id;
	
	@NotEmpty(message = "Name is required")
	private String name;
	
	@Email(message = "email is not vaild")
	private String email;
	
	@NotEmpty
	@Size(min=8,max=20,message = "Password must be 8 to 20 caracter")
	private String password;
	
	@NotEmpty(message = "About is required")
	private String about;

}
