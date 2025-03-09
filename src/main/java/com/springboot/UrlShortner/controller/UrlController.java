package com.springboot.UrlShortner.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.UrlShortner.constants.UrlConstants;
import com.springboot.UrlShortner.model.Url;
import com.springboot.UrlShortner.service.UrlService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping({"/","/"+UrlConstants.BASE_URL})
public class UrlController {
	private final static  Logger log = LoggerFactory.getLogger(UrlController.class);
	private final UrlService service;
	public UrlController(UrlService service) {
		this.service=service;
	}
	@PostMapping("UrlShortner")
	public ResponseEntity<String> shortenUrl(@RequestBody Url ogUrl, HttpServletRequest servletRequest) {
		log.info("Shortening of url has started ...");
		String url=ogUrl.getOgUrl();
		String shortUrl = service.shortenUrl(url);
		log.info("Shortening of url completed");
		String baseUrl = servletRequest.getRequestURL().toString().replace(servletRequest.getRequestURI(), "");
		return ResponseEntity.ok(baseUrl+"/"+UrlConstants.BASE_URL+"/"+shortUrl);	
	}
	@GetMapping("/{shortUrl}")
	public ResponseEntity<String> getOgUrl(@PathVariable String shortUrl) {
		log.info("Received request to get original Url {}",shortUrl);
		String ogUrl =  service.getOgUrl(shortUrl);
	    return ResponseEntity.status(HttpStatus.FOUND)
	            .header(HttpHeaders.LOCATION, ogUrl)
	            .build();
				
	}
}
 