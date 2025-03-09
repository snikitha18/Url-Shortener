package com.springboot.UrlShortner.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springboot.UrlShortner.constants.UrlConstants;
import com.springboot.UrlShortner.exception.UrlNotFoundException;
import com.springboot.UrlShortner.model.Url;
import com.springboot.UrlShortner.repository.UrlRepo;

@Service
public class UrlService {
	@Autowired
	Base62Encoder encoder;
	@Autowired
	UrlRepo repo;
	
	private static final Logger logger = LoggerFactory.getLogger(UrlService.class);
	public String shortenUrl(String url) {
		logger.info("Received request to shorten URL: {}", url);
		if (url == null || url.isEmpty()) {
            logger.warn("Received empty or null URL.");
            return "Invalid URL";
        }String shortUrl = encoder.encodeUrl(url);
		Optional<Url> existingUrl = repo.findByModifiedUrl(shortUrl);
		if (existingUrl.isPresent()) {
			return shortUrl;
		}
		else {
		repo.save(new Url(url,shortUrl,LocalDateTime.now()));
		logger.debug("Generated short URL: {}", shortUrl);
		return shortUrl;	
		}
	}
	@Cacheable(value="link",key="#url", unless = "#result==null")
	public String getOgUrl(String url) {
		logger.info("Retrieving Original URL: {}", url);
		return repo.findByModifiedUrl(url)
		            	    .map(Url::getOgUrl)
		            	    .orElseThrow(() -> new UrlNotFoundException("URL not found for: " + UrlConstants.BASE_URL+url));
	    }
    


	
}
