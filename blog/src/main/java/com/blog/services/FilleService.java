package com.blog.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

public interface FilleService {
	
	String uploadImage(String path, MultipartFile file) throws  IOException;
	
	InputStream getresoursc(String path,String fileName) throws FileNotFoundException;

}
