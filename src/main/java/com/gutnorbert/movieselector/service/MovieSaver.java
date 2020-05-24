package com.gutnorbert.movieselector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gutnorbert.movieselector.entity.SelectedMovie;
import com.gutnorbert.movieselector.repository.SelectedMovieRepository;

@Service
public class MovieSaver {

	@Autowired
	private SelectedMovieRepository selectedMovieRepository;

	public void saveMovie (SelectedMovie movie) throws Exception {
		selectedMovieRepository.save(movie);
	}
	
	public List<SelectedMovie> getMovies() throws Exception {
		return (List<SelectedMovie>) selectedMovieRepository.findAll();
	}
	
	public void deleteMovie (SelectedMovie movie) throws Exception {
		selectedMovieRepository.deleteById(movie.getId());
	}

}
