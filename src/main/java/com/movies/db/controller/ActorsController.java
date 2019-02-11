package com.movies.db.controller;

import com.movies.db.entity.Actor;
import com.movies.db.entity.Movie;
import com.movies.db.entity.MovieActors;
import com.movies.db.repo.ActorRepository;
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
public class ActorsController {

    @Autowired
    ActorRepository actorRepo;

    @Autowired
    MovieRepository movieRepo;

    @RequestMapping(value = "/actors", method = RequestMethod.GET)
    public String getPage(Model model) {
        model.addAttribute("actors", fetchAllActors());
        model.addAttribute("actor", freshActor());
        model.addAttribute("movies", fetchAllMovieS());
        return "actors";
    }

    @RequestMapping(value="/actors", method=RequestMethod.POST)
    public String addActor(@Valid @ModelAttribute("actor") Actor actor, BindingResult bindingResult, Model model) {
        actorRepo.save(actor);
        model.addAttribute("actors", fetchAllActors());
        model.addAttribute("actor", freshActor());
        return "actors";
    }

    @RequestMapping(value = "/actor/delete/{id}", method = RequestMethod.GET)
    public String deleteActor(@PathVariable("id") long id, @ModelAttribute("actor") Actor actorr, Model model){
        Actor actor = actorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Id not found"));
        List<Movie> moviesByActor = findMoviesByActor(actor);
        for (Movie m : moviesByActor) {
            movieRepo.save(detachMovieAndActor(m, actor));
        }

        actorRepo.delete(actor);
        model.addAttribute("actors", fetchAllActors());
        return "actors";
    }

    @RequestMapping(value = "/actor/edit/{id}", method = RequestMethod.GET)
    public String editActor(@PathVariable("id") long id, @ModelAttribute("actor") Actor actorr, Model model) {
        Actor actor = actorRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("no id found"));
        MovieActors movieActors = new MovieActors(actor, findMoviesByActor(actor));
        model.addAttribute("editActor", movieActors);
        model.addAttribute("actors", fetchAllActors());
        model.addAttribute("movies", fetchAllMovieS());
        return "actors";
    }

    @RequestMapping(value="/actor/edit", method=RequestMethod.POST)
    public String updateActor(@Valid @ModelAttribute("editActor") MovieActors movieActors, BindingResult bindingResult, Model model) {

        for (Movie m : movieActors.getOldMovies()) {
            movieRepo.save(detachMovieAndActor(m, movieActors.getActor()));
        }

        for (Movie m : movieActors.getMovies()) {
            movieRepo.save(attachMovieAndActor(m, movieActors.getActor()));
        }

        actorRepo.save(movieActors.getActor());

        model.addAttribute("actors", fetchAllActors());
        model.addAttribute("editActor", null);
        model.addAttribute("actor", freshActor());

        return "actors";
    }

    private Movie detachMovieAndActor(Movie m, Actor a) {
        List<Actor> movieActors = m.getActorList();
        movieActors.remove(a);
        m.setActorList(movieActors);
        return m;
    }

    private Movie attachMovieAndActor(Movie m, Actor a) {
        List<Actor> actors = m.getActorList();
        actors.add(a);
        m.setActorList(actors);
        return m;
    }

    private List<Movie> findMoviesByActor(Actor actor) {
        List<Movie> movies = new ArrayList<>();
        List<BigDecimal> moviesIdByActor = actorRepo.findAllMoviesByActor(actor.getActorId());
        for (BigDecimal movieId: moviesIdByActor) {
            Movie movie = movieRepo.findByMovieId(movieId.longValue());
            movies.add(movie);
        }
        return movies;
    }


    private List<Actor> fetchAllActors() {
        List<Actor> actors = new ArrayList<>();
        actorRepo.findAll().forEach(actors::add);
        return actors;
    }

    private List<Movie> fetchAllMovieS() {
        List<Movie> allMovies = new ArrayList<>();
        movieRepo.findAll().forEach(allMovies::add);
        return allMovies;
    }

    private Actor freshActor() {
        return new Actor();
    }

}
