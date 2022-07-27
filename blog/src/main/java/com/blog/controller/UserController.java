package com.blog.controller;






import java.util.List;
import java.util.Map;

import org.aspectj.weaver.NewConstructorTypeMunger;
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
import org.springframework.web.bind.annotation.RestController;

import com.blog.payload.ApiResponse;
import com.blog.payload.UserDto;
import com.blog.services.UserService;

@RestController
@RequestMapping("/api/useres")
public class UserController {
	
	@Autowired private UserService userService;
	
	@PostMapping("/")
	public ResponseEntity<UserDto> createUsers(@RequestBody UserDto userDto){
		UserDto createDto=this.userService.createUser(userDto);
		return new ResponseEntity<>(createDto,HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto ,@PathVariable ("userId") 
	Integer uid){
		UserDto updateUserDto=this.userService.updateUserDto(userDto, uid);
		return ResponseEntity.ok(updateUserDto);
		
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUserDto(@PathVariable ("userId") Integer uid){
		this.userService.deleteUserDto(uid);
		return new ResponseEntity(new ApiResponse("delete user succssfully",true), HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getAlluser(){
		return ResponseEntity.ok(this.userService.getAllUserDto());
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId ){
		return ResponseEntity.ok(this.userService.getUserDtoById(userId));
	}
	

}
