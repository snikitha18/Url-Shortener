package com.springboot.UrlShortner.repository;

import org.springframework.stereotype.Repository;

import com.springboot.UrlShortner.model.Url;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface UrlRepo extends JpaRepository<Url,String> {
	
	Url findByModifiedUrl(String modifiedUrl);

}
