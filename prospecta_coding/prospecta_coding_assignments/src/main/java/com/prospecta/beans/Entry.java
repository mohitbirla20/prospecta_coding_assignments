package com.prospecta.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Entry {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer EntryID;
	
	@JsonProperty("API")
	private String api;
	
	@JsonProperty("Description")
	private String description;
	
	@JsonProperty("Auth")
	private String auth;
	
	@JsonProperty("HTTPS")
	private boolean https;
	
	@JsonProperty("Cors")
	private String cors;
	
	@JsonProperty("Link")
	private String lint;
	
	@JsonProperty("Category")
	private String category;

	public Entry() {
		super();
	}

	public Entry(Integer entryID, String api, String description, String auth, boolean https, String cors, String lint,
			String category) {
		super();
		EntryID = entryID;
		this.api = api;
		this.description = description;
		this.auth = auth;
		this.https = https;
		this.cors = cors;
		this.lint = lint;
		this.category = category;
	}

	public Integer getEntryID() {
		return EntryID;
	}

	public void setEntryID(Integer entryID) {
		EntryID = entryID;
	}

	public String getApi() {
		return api;
	}

	public void setApi(String api) {
		this.api = api;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public boolean isHttps() {
		return https;
	}

	public void setHttps(boolean https) {
		this.https = https;
	}

	public String getCors() {
		return cors;
	}

	public void setCors(String cors) {
		this.cors = cors;
	}

	public String getLint() {
		return lint;
	}

	public void setLint(String lint) {
		this.lint = lint;
	}

	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	
	
}
