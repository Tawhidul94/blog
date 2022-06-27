package com.blog.services;

import com.blog.entity.User;
import com.blog.payload.UserDto;

public interface UserService {
	
	User createUser (UserDto userDto);
	

}
