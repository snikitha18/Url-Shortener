package com.springboot.UrlShortner.configuration;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;

@Configuration
public class RedisConfiguration {
	
	
	  @Bean
	    public RedisCacheConfiguration cacheConfiguration() {
	        return RedisCacheConfiguration.defaultCacheConfig()
	            .entryTtl(Duration.ofMinutes(5))  
	            .disableCachingNullValues();
	    }

	    @Bean
	    public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
	        return RedisCacheManager.builder(redisConnectionFactory)
	            .cacheDefaults(cacheConfiguration())
	            .build();
	    }

}
