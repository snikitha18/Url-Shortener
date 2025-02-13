package com.springboot.UrlShortner.service;

import org.springframework.stereotype.Component;

@Component
public class Base62Encoder {
	private final static String BASE_62_ENCODER = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String encodeUrl(String url) {
		int sum=0;
		for(int i=0;i<url.length();i++) {
			sum+=url.charAt(i);
		}
		return getShortenedUrl(sum);
		
	}

	private String getShortenedUrl(int sum) {StringBuilder shortUrl= new StringBuilder();
		while(sum>0) {
			shortUrl.append(BASE_62_ENCODER.charAt(sum%62));
			sum/=62;
		}
		return shortUrl.reverse().toString();
	}
}
