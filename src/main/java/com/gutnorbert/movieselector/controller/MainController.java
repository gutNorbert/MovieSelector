package com.gutnorbert.movieselector.controller;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gutnorbert.movieselector.entity.SearchedMovie;
import com.gutnorbert.movieselector.entity.SelectedMovie;
import com.gutnorbert.movieselector.service.MovieSaver;
import com.gutnorbert.movieselector.service.MovieSearch;
import com.gutnorbert.movieselector.service.MovieSelector;

@Controller
public class MainController {

	Logger logger = LoggerFactory.getLogger(MainController.class);

	@Autowired
	private MovieSelector movieSelector;

	@Autowired
	private MovieSearch movieSearch;

	@Autowired
	private MovieSaver movieSaver;

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String searched(@ModelAttribute SelectedMovie movie, Model model) {

		try {
			ArrayList<SearchedMovie> movieSearchList = movieSearch.returnMovie(movie.getTitle());

			model.addAttribute("searchedMovie", movieSearchList);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "main";
	}

	@RequestMapping(path = "/search")
	public String search(Model model) {
		model.addAttribute("movie", new SelectedMovie());

		return "search";
	}

	@RequestMapping(path = "/movie/{imdbId}", method = RequestMethod.GET)
	public String movieResult(Model model, @PathVariable(name = "imdbId") String imdbId) {

		try {
			model.addAttribute("selectedMovie", movieSelector.returnMovie(imdbId));
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "movie";
	}

	@RequestMapping(path = "/saveMovie", method = RequestMethod.POST)
	public String saveMovie(@ModelAttribute SelectedMovie passedMovie) {

		try {
			movieSaver.saveMovie(passedMovie);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "savedMovie";
	}
	 
	@RequestMapping(path = "/myMovies")
	public String myMovies(Model model) {

		try {
			model.addAttribute("movies", movieSaver.getMovies());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "myMovies";
	}
	
	@RequestMapping(path = "/deleteMovie", method = RequestMethod.POST)
	public String deleteMovie(@ModelAttribute SelectedMovie passedMovie) {

		try {
			movieSaver.deleteMovie(passedMovie);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "deleteMovie";
	}

}
