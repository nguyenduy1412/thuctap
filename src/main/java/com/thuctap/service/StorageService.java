package com.thuctap.service;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
	void store(MultipartFile file);
	void store(MultipartFile file,String fileName);
	void init();
}
