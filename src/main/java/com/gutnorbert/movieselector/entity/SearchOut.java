package com.gutnorbert.movieselector.entity;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gutnorbert.movieselector.service.MovieSearch;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchOut {

	@JsonProperty("Search")
	public ArrayList<SearchedMovie> searchList;

	public ArrayList<SearchedMovie> getSearchList() {
		return searchList;
	}

	public void setSearchList(ArrayList<SearchedMovie> searchList) {
		this.searchList = searchList;
	}
	
}
