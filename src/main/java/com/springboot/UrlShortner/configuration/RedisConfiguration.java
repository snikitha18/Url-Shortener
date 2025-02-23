package com.springboot.UrlShortner.configuration;

import java.time.Duration;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;

@Configuration
public class RedisConfiguration {
	
	
	public RedisCacheConfiguration cacheConfiguration() {
	    return RedisCacheConfiguration.defaultCacheConfig()
	        .entryTtl(Duration.ofMinutes(10))  // Cache expires after 10 minutes
	        .disableCachingNullValues();
	}

}
