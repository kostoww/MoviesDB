package com.movies.db.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movies.db.entity.Actor;
import com.movies.db.entity.Gender;
import com.movies.db.entity.Genre;
import com.movies.db.entity.Movie;
import com.movies.db.repo.GenreRepository;
import com.movies.db.repo.MovieRepository;

@Controller
public class ViewMovieController {

	@Autowired
	MovieRepository movieRepo;
	
	@Autowired
	GenreRepository genreRepo;
	
	@RequestMapping(value = "/view/{id}")
	public String showUpdateForm(@PathVariable("id") long movieId, Model model) {

	    Movie selectedMovie = movieRepo.findById(movieId)
	    	.orElseThrow(() -> new IllegalArgumentException("Invalid Movie Id: " + movieId));

	    model.addAttribute("movie", selectedMovie);
	    return "view";
	}
}
