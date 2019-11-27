package com.example.file.upload.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

	private final Path rootLocation = Paths.get("src/main/resources/public");

	public void store(MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		System.out.println(rootLocation.toUri());
		try {
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
