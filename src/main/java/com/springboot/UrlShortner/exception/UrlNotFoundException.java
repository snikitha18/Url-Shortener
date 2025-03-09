package com.springboot.UrlShortner.exception;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class UrlNotFoundException extends RuntimeException {

	private static final Logger logger = LoggerFactory.getLogger(UrlNotFoundException.class);

	public UrlNotFoundException(String message) {
        super(message);
        logger.error("Exception Created: {}", message);
    }
}
