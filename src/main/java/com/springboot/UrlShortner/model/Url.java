package com.springboot.UrlShortner.model;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.*;
@Entity
@Table(name="url_db", indexes = @Index(name = "idx_modified_url", columnList = "modifiedUrl"),uniqueConstraints = @UniqueConstraint(columnNames = {"modifiedUrl","ogUrl"}))
public class Url {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(nullable = false)
	private String modifiedUrl;

	@Column(nullable = false)
	private String ogUrl;
	public Url(  String ogUrl,String modifiedUrl, LocalDateTime createdOn) {	
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

	public Url() {
	
	}
	@Column(nullable = false, updatable = false)
	private LocalDateTime createdOn ;
	@PrePersist
    protected void onCreate() {
        this.createdOn = LocalDateTime.now();
    }

}
