package com.gutnorbert.movieselector.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchedMovie implements Comparable< SearchedMovie > {
	
	@JsonProperty("Title")
	String title;
	
	@JsonProperty("Year")
	String year;
	
	@JsonProperty("imdbID")
	String imdbId; 

	@JsonProperty("Poster")
	String poster;
	 
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getImdbId() {
		return imdbId;
	}

	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	@Override
	public int compareTo(SearchedMovie searchedMovie) {
		return this.getYear().compareTo(searchedMovie.getYear());
	}
	
	
}
