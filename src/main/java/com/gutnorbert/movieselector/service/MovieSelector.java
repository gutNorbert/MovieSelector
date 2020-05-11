package com.gutnorbert.movieselector.service;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gutnorbert.movieselector.entity.SelectedMovie;

@Service
public class MovieSelector {
	
	ObjectMapper objectMapper = new ObjectMapper();

	Logger logger = LoggerFactory.getLogger(MovieSelector.class);
	
	public SelectedMovie returnMovie(String imdbID) throws Exception {
		
		URL url = new URL("http://www.omdbapi.com/?i=" + imdbID + "&apikey=c5ed9ac");

		SelectedMovie movie = objectMapper.readValue(url, SelectedMovie.class);
		
		return movie;
	}

}
