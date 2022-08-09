package com.blog.services;

import java.util.List;

import com.blog.entity.Post;
import com.blog.payload.PostDto;

public interface PostService {
	
	PostDto createPost(PostDto postDto,Integer userId, Integer catagoryId);
	
	PostDto UpdatePost(PostDto postDto,Integer postId);
	
	void deletePost(Integer postId);
	
	List<PostDto> getAllPosts(Integer pageNumber,Integer pageSize);
	
	PostDto getPostByPostId(Integer postId);
	
	//get all post by category
	List<PostDto> getPostByCategoery(Integer catagoryId);
	
	//get all post by user
	List<PostDto> getPostByUser(Integer userId);
	
	//Search post
	List<Post> searchPost(String keyword);

}
