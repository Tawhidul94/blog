package com.blog.services;

import java.util.List;

import com.blog.payload.UserDto;

public interface UserService {
	
	UserDto createUser (UserDto user);
	
	UserDto updateUserDto(UserDto userDto,Integer userId);
	
	UserDto getUserDtoById(Integer userId);
	
	List<UserDto> getAllUserDto();
	
	void deleteUserDto(Integer userId);
	

}
