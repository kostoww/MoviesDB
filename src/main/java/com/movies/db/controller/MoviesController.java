package com.movies.db.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.movies.db.entity.Actor;
import com.movies.db.entity.Genre;
import com.movies.db.entity.MovieGenres;
import com.movies.db.repo.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movies.db.entity.Movie;
import com.movies.db.repo.MovieRepository;

@Controller
public class MoviesController {

	@Autowired
	MovieRepository movieRepo;
	@Autowired
	GenreRepository genreRepo;

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value="/movies", method=RequestMethod.GET)
    public String greeting(Model model) {
        model.addAttribute("movies", fetchAllMovies());
        model.addAttribute("movie", freshMovie());
        return "movies";
    }
	
	@RequestMapping(value="/movies", method=RequestMethod.POST)
    public String addMovie(@Valid @ModelAttribute("movie") Movie movie, BindingResult bindingResult, Model model) {
		movieRepo.save(movie);
		model.addAttribute("movies", fetchAllMovies());
		model.addAttribute("movie", freshMovie());

        return "movies";
    }
	
	@RequestMapping(value = "/movie/delete/{id}", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable("id") long id, @ModelAttribute("movie") Movie moviee,  Model model) {
	    Movie movie = movieRepo.findById(id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid movie Id:" + id));
	    movieRepo.delete(movie);
	    model.addAttribute("movies", fetchAllMovies());
	    return "movies";
	}

	@RequestMapping(value = "/movie/edit/{id}", method = RequestMethod.GET)
	public String editActor(@PathVariable("id") long id, @ModelAttribute("movie") Movie moviee, Model model) {
		Movie movie = movieRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("no id found"));
		model.addAttribute("movies", fetchAllMovies());
		model.addAttribute("editMovie", movie);
		return "movies";
	}

	@RequestMapping(value="/movie/edit", method=RequestMethod.POST)
	public String updateActor(@Valid @ModelAttribute("editMovie") Movie movie, BindingResult bindingResult, Model model) {

		movieRepo.save(movie);

		model.addAttribute("movies", fetchAllMovies());
		model.addAttribute("editMovie", null);
		model.addAttribute("movie", freshMovie());

		return "movies";
	}

	private List<Movie> fetchAllMovies() {
		List<Movie> movies = new ArrayList<>();
		movieRepo.findAll().forEach(movies::add);
		return movies;
	}

	private Movie freshMovie() {
		return new Movie();
	}
	
}
