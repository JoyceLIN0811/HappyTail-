package com.happytail.general.model.service;

import java.io.IOException;

import java.io.InputStream;

import java.net.URI;

import java.util.Map;



import org.springframework.http.MediaType;

import org.springframework.http.RequestEntity;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.util.LinkedMultiValueMap;

import org.springframework.web.client.RestTemplate;

import com.happytail.general.util.MultipartInputStreamFileResource;

@Service
@Transactional
public class ImageUploadService {

	private final String IMGUR_UPLOAD_URL = "https://api.imgur.com/3/upload";
	private final String IMGUR_CLIENT_ID = "2cd5c2a77436892";

    private RestTemplate restTemplate;

    public void init() {
        restTemplate = new RestTemplate();
    }
    
    public void uploadImage() {
    	URI uri = URI.create("https://story.hhui.top/detail?id=666106231640");
        
    	res = restTemplate.getForObject(uri, InnerRes.class);
        System.out.println(res);

    }
	
	
//	public String uploadToImgur(InputStream subImage,String imageName) {
//		RestTemplate template = new RestTemplate();
//		
//		LinkedMultiValueMap<String, Object> map= new LinkedMultiValueMap<>();
//		map.add("image", new MultipartInputStreamFileResource(subImage,imageName));
//		
//		URI uri = URI.create(IMGUR_UPLOAD_URL);
//		RequestEntity<LinkedMultiValueMap<String, Object>> request =
//				RequestEntity
//				.post(uri)
//				.header("Authorization", "Client-ID" + IMGUR_CLIENT_ID)
//				.contentType(MediaType.MULTIPART_FORM_DATA)
//				.body(map);	
//		
//		ResponseEntity<Map> response = template.exchange(request, Map.class);
//		
//		String imgUrl = ((Map)response.getBody().get("data")).get("link").toString();
//		return imgUrl;
//	}
}
