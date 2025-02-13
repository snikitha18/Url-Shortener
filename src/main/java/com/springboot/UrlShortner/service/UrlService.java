package com.springboot.UrlShortner.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.UrlShortner.model.Url;
import com.springboot.UrlShortner.repository.UrlRepo;

@Service
public class UrlService {
	@Autowired
	Base62Encoder encoder;
	@Autowired
	UrlRepo repo;
	public String shortenUrl(String url) {
		String shortUrl = encoder.encodeUrl(url);
		repo.save(new Url(url,shortUrl,LocalDateTime.now()));
		return shortUrl;	
	}
	public String getOgUrl(String url) {		
		return repo.findByModifiedUrl(url).getOgUrl();		
	}
}
