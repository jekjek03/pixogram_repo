package com.ibm.pixogram.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.ibm.pixogram.exception.FileStorageException;
import com.ibm.pixogram.model.MediaItem;
import com.ibm.pixogram.model.MediaStorageProperties;
import com.ibm.pixogram.repository.MediaItemRepository;

@Service
public class MediaService {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	private final Path fileStorageLocation;
	
	@Autowired
	private MediaItemRepository mediaRepo;
	
	@Autowired
	public MediaService(MediaStorageProperties mediaStorageProperties) {
		this.fileStorageLocation = Paths.get(mediaStorageProperties.getUploadDir()).toAbsolutePath().normalize();
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch(Exception ex) {
			throw new FileStorageException("Could not create the directory where the uploaded files will be stored.", ex);
		}
	}
	
	public String uploadFile(MultipartFile file) {
		// Normalize file name
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		 
		try {
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation);
			
			MediaItem mediaItem = new MediaItem();
            mediaItem.setUsername("user"); // TODO
            mediaItem.setFilename(fileName);
            mediaItem.setLocation(targetLocation.toString());
            mediaItem.setFileType(file.getContentType());
            mediaItem.setSize(file.getSize());
            mediaItem.setHidden(false);
            mediaItem.setUploadDate(new Date());
            mediaItem.setUploadTime(new Date());
            
            String type = "";
            if(file.getContentType().startsWith("image/")) {
            	type = "image";
            } else if(file.getContentType().startsWith("video/")) {
            	type = "video";
            } else {
            	 throw new FileStorageException("Sorry! File's format is invalid." + fileName);
            }
            mediaItem.setType(type);
            mediaRepo.save(mediaItem);
            
            return fileName;
            
	    } catch (Exception e) {
	    	throw new RuntimeException("FAIL!");
	    }
	}

}
