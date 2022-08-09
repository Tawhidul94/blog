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

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer catagoryId;
	
	private String categoryTitle;
	
	private String categoryDescrtion;
	
	@OneToMany(mappedBy ="category",cascade =CascadeType.ALL,fetch = FetchType.LAZY )
	private List<Post> posts=new ArrayList<Post>();

}
