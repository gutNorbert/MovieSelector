package com.gutnorbert.movieselector.repository;

import org.springframework.data.repository.CrudRepository;

import com.gutnorbert.movieselector.entity.SelectedMovie;

public interface SelectedMovieRepository extends CrudRepository<SelectedMovie, Long> {

}
