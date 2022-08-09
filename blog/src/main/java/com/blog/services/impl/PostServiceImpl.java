package com.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entity.Category;
import com.blog.entity.Post;
import com.blog.entity.User;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.PostDto;
import com.blog.repojetoris.CategoryRepo;
import com.blog.repojetoris.PostRepo;
import com.blog.repojetoris.UserRepo;
import com.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired private PostRepo postRepo;
	@Autowired private ModelMapper modelMapper;
	@Autowired private UserRepo userRepo;
	@Autowired private CategoryRepo categoryRepo;

	@Override
	public PostDto createPost(PostDto postDto,Integer userId, Integer catagoryId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		Category category=this.categoryRepo.findById(catagoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Id", catagoryId));
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setUser(user);
		post.setCategory(category);
		Post newPost = this.postRepo.save(post);
		return modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto UpdatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId).
				orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatePost = this.postRepo.save(post);
		return this.modelMapper.map(updatePost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post postsId = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
		this.postRepo.delete(postsId);
		

	}

	@Override
	public List<PostDto> getAllPosts() {
		List<Post> posts = this.postRepo.findAll();
		List<PostDto> postdtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postdtos;
	}

	@Override
	public PostDto getPostByPostId(Integer postId) {
		Post postsId = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post", "postId", postId));
		return this.modelMapper.map(postsId, PostDto.class);
	}

	@Override
	public List<PostDto> getPostByCategoery(Integer catagoryId) {
		Category category=this.categoryRepo.findById(catagoryId).
				orElseThrow(() -> new ResourceNotFoundException("Category", "Id", catagoryId));
		List<Post> posts = this.postRepo.findByCategory(category);
		List<PostDto> postDtos = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> getPostByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postDtosUser = posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDtosUser;
	}

	@Override
	public List<Post> searchPost(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
