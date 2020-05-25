package com.happytail.general.model.service;

import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class ImageUploadService {

	private final String IMGUR_UPLOAD_URL = "https://api.imgur.com/3/upload";
	private final String IMGUR_CLIENT_ID = "2cd5c2a77436892";

	public String uploadToImur(MultipartFile image) {
		// use REST Template to throw request and response

		RestTemplate template = new RestTemplate();

		// prepare for body content

		LinkedMultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

		try {

			body.add("image",

					new MultipartInputStreamFileResource(image.getInputStream(), image.getOriginalFilename()));

		} catch (IOException e) {

			e.printStackTrace();

			System.out.println(e.getMessage());

		}
	}

}
