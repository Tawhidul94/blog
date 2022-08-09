package com.blog.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	private String email;
	
	private String password;
	
	private String about;
	
	@OneToMany(mappedBy ="user",cascade =CascadeType.ALL,fetch = FetchType.LAZY )
	private List<Post> posts=new ArrayList<Post>();

}
