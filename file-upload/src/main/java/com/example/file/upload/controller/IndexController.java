package com.example.file.upload.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class IndexController {

	@Autowired
	FileService fileservice;

	@CrossOrigin(origins = "http://localhost:3000") // Call from Local Angualar
	@PostMapping("/uploadFile")
	public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {

		String message = "";
		try {
			fileservice.store(file);
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "Fail to upload Profile Picture" + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

}
