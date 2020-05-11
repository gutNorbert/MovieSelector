package com.gutnorbert.movieselector.service;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gutnorbert.movieselector.entity.SearchOut;
import com.gutnorbert.movieselector.entity.SearchedMovie;
import com.gutnorbert.movieselector.entity.SelectedMovie;

@Service
public class MovieSearch {

	ObjectMapper objectMapper = new ObjectMapper();

	Logger logger = LoggerFactory.getLogger(MovieSearch.class);

	public ArrayList<SearchedMovie> returnMovie(String movieTitle) throws Exception {
		if (movieTitle.contains(" ")) {
			movieTitle = movieTitle.replace(" ", "%20");
		}
		
		URL searchUrl = new URL("http://www.omdbapi.com/?s=" + movieTitle + "&apikey=c5ed9ac");

		SearchOut movieList = objectMapper.readValue(searchUrl, SearchOut.class);
		ArrayList<SearchedMovie> movieSearchList = movieList.searchList;
		
		//Sort by date currently
		Collections.sort(movieSearchList);

		return movieSearchList;
	}

}
