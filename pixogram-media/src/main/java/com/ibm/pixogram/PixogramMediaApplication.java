package com.ibm.pixogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.ibm.pixogram.model.MediaStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({MediaStorageProperties.class})
public class PixogramMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PixogramMediaApplication.class, args);
	}

}
