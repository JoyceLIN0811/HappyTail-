package com.happytail.general.util;

import java.io.InputStream;

import org.springframework.core.io.InputStreamResource;

public class MultipartInputStreamFileResource extends InputStreamResource{
	
	private final String filename;
	
	public MultipartInputStreamFileResource(InputStream inputStream, String filename) {
		super(inputStream);
		this.filename = filename;
	}

	public String getFilename() {
		return this.filename;
	}
	
	
}
