package com.springboot.UrlShortner.model;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Scope;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Scope("Prototype")
@Table(name="url_db")
public class Url {
	public Url(  String ogUrl,String modifiedUrl, LocalDateTime createdOn) {
		super();	
		this.modifiedUrl = modifiedUrl;
		this.ogUrl = ogUrl;
		this.createdOn = createdOn;
	}

	
	
	public String getModifiedUrl() {
		return modifiedUrl;
	}
	public void setModifiedUrl(String modifiedUrl) {
		this.modifiedUrl = modifiedUrl;
	}
	public String getOgUrl() {
		return ogUrl;
	}
	public void setOgUrl(String ogUrl) {
		this.ogUrl = ogUrl;
	}
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}
	@Id
	private String modifiedUrl;
	public Url() {
	
	}
	private String ogUrl;
	private LocalDateTime createdOn ;

}
