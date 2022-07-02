package com.blog.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.blog.entity.User;
import com.blog.payload.UserDto;
import com.blog.repojetoris.UserRepo;
import com.blog.services.UserService;
import com.blog.exception.ResourceNotFoundException;

public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto user) {

		User user1 = this.UserDtoToUser(user);
		User saveUser = this.userRepo.save(user1);
		return this.UserToUserDto(saveUser);

	}

	@Override
	public UserDto updateUserDto(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User updateUser=this.userRepo.save(user);
		UserDto userDto1=this.UserToUserDto(updateUser);
		return userDto1;
	}

	@Override
	public UserDto getUserDtoById(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		return this.UserToUserDto(user);
	}

	@Override
	public List<UserDto> getAllUserDto() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserDto(Integer userId) {
		// TODO Auto-generated method stub

	}

	public User UserDtoToUser(UserDto userDto) {
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		return user;

	}

	public UserDto UserToUserDto(User user) {

		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());
		return userDto;
	}

}
