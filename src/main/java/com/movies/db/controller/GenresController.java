package com.movies.db.controller;

import com.movies.db.entity.Genre;
import com.movies.db.entity.Movie;
import com.movies.db.entity.MovieGenres;
import com.movies.db.repo.GenreRepository;
import com.movies.db.repo.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GenresController {

    @Autowired
    GenreRepository genreRepo;

    @Autowired
    MovieRepository movieRepo;

    @RequestMapping(value = "/genres", method = RequestMethod.GET)
    public String getPage(Model model) {
        model.addAttribute("genres", fetchAllGenres());
        model.addAttribute("genre", freshGenre());
        model.addAttribute("movies", fetchAllMovieS());
        return "genres";
    }



    @RequestMapping(value="/genres", method=RequestMethod.POST)
    public String addGenre(@Valid @ModelAttribute("genre") Genre Genre, BindingResult bindingResult, Model model) {
        genreRepo.save(Genre);
        model.addAttribute("genres", fetchAllGenres());
        model.addAttribute("genre", freshGenre());
        return "genres";
    }

    @RequestMapping(value = "/genre/delete/{id}", method = RequestMethod.GET)
    public String deleteGenre(@PathVariable("id") long id, @ModelAttribute("Genre") Genre Genrer, Model model){
        Genre Genre = genreRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found"));
        List<Movie> moviesByGenre = findMoviesByGenre(Genre);
        for (Movie m : moviesByGenre) {
            movieRepo.save(detachMovieAndGenre(m, Genre));
        }

        genreRepo.delete(Genre);
        model.addAttribute("genres", fetchAllGenres());
        return "genres";
    }

    @RequestMapping(value = "/genre/edit/{id}", method = RequestMethod.GET)
    public String editGenre(@PathVariable("id") long id, @ModelAttribute("genre") Genre Genrer, Model model) {
        Genre Genre = genreRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("no id found"));
        MovieGenres movieGenres = new MovieGenres(Genre, findMoviesByGenre(Genre));
        model.addAttribute("editGenre", movieGenres);
        model.addAttribute("genres", fetchAllGenres());
        model.addAttribute("movies", fetchAllMovieS());
        return "genres";
    }

    @RequestMapping(value="/genre/edit", method=RequestMethod.POST)
    public String updateGenre(@Valid @ModelAttribute("editGenre") MovieGenres movieGenres, BindingResult bindingResult, Model model) {

        for (Movie m : movieGenres.getOldMovies()) {
            movieRepo.save(detachMovieAndGenre(m, movieGenres.getGenre()));
        }

        for (Movie m : movieGenres.getMovies()) {
            movieRepo.save(attachMovieAndGenre(m, movieGenres.getGenre()));
        }

        genreRepo.save(movieGenres.getGenre());

        model.addAttribute("genres", fetchAllGenres());
        model.addAttribute("editGenre", null);
        model.addAttribute("genre", freshGenre());

        return "genres";
    }

    private Movie detachMovieAndGenre(Movie m, Genre a) {
        List<Genre> movieGenres = m.getGenreList();
        movieGenres.remove(a);
        m.setGenreList(movieGenres);
        return m;
    }

    private Movie attachMovieAndGenre(Movie m, Genre a) {
        List<Genre> Genres = m.getGenreList();
        Genres.add(a);
        m.setGenreList(Genres);
        return m;
    }

    private List<Movie> findMoviesByGenre(Genre genre) {
        List<Movie> movies = new ArrayList<>();
        List<BigDecimal> moviesIdByGenre = genreRepo.findAllMoviesByGenre(genre.getGenreId());
        for (BigDecimal movieId: moviesIdByGenre) {
            Movie movie = movieRepo.findByMovieId(movieId.longValue());
            movies.add(movie);
        }
        return movies;
    }


    private List<Genre> fetchAllGenres() {
        List<Genre> genres = new ArrayList<>();
        genreRepo.findAll().forEach(genres::add);
        return genres;
    }

    private List<Movie> fetchAllMovieS() {
        List<Movie> allMovies = new ArrayList<>();
        movieRepo.findAll().forEach(allMovies::add);
        return allMovies;
    }

    private Genre freshGenre() {
        return new Genre();
    }


}
