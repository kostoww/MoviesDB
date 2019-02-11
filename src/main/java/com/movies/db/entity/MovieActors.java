package com.movies.db.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieActors {

    private Actor actor;
    private List<Movie> movies;
    private List<Movie> oldMovies;

    public MovieActors() {
    }

    public MovieActors(Actor actor, List<Movie> movies) {
        this.actor = actor;
        this.movies = movies;
        ArrayList<Movie> clonedList = new ArrayList<>(movies);
        this.oldMovies = (List<Movie>) clonedList.clone();
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getOldMovies() {
        return oldMovies;
    }

    public void setOldMovies(List<Movie> oldMovies) {
        this.oldMovies = oldMovies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieActors that = (MovieActors) o;
        return Objects.equals(actor, that.actor) &&
                Objects.equals(movies, that.movies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor, movies);
    }

    @Override
    public String toString() {
        return "MovieActors{" +
                "actor=" + actor +
                ", movies=" + movies +
                '}';
    }
}
