package com.springboot.UrlShortner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.UrlShortner.model.UrlRequestDto;
import com.springboot.UrlShortner.service.UrlService;

@RestController
@RequestMapping("/UrlShortner")
public class UrlController {
	@Autowired
	UrlService service;
	@PostMapping("/short")
	public ResponseEntity<String> shortenUrl(@RequestBody UrlRequestDto ogUrl) {
		String shortUrl = service.shortenUrl(ogUrl.getOgUrl());
		return ResponseEntity.ok(shortUrl);	
	}
	@GetMapping("/{shortUrl}")
	public String getOgUrl(@PathVariable String shortUrl) {
		return service.getOgUrl(shortUrl);
				
	}
}
