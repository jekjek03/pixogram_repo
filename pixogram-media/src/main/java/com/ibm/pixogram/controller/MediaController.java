package com.ibm.pixogram.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.pixogram.service.MediaService;
import com.ibm.pixogram.util.ApiURL;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MediaController {

	@Autowired
	private MediaService mediaService;
	
	@PostMapping(ApiURL.MEDIA_UPLOAD_SINGLE_FILE)
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		
		try {
			mediaService.uploadFile(file);
			message = "You successfully uploaded " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch(Exception e) {
			message = "FAIL to upload " + file.getOriginalFilename() + "!";
		    return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}
	}
	
}
