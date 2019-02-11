package com.movies.db.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MovieGenres {

    private Genre genre;
    private List<Movie> movies;
    private List<Movie> oldMovies;

    public MovieGenres() {
    }

    public MovieGenres(Genre genre, List<Movie> movies) {
        this.genre = genre;
        this.movies = movies;
        ArrayList<Movie> copyGenres = new ArrayList<>(movies);
        this.oldMovies  = (List<Movie>) copyGenres.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieGenres that = (MovieGenres) o;
        return Objects.equals(genre, that.genre) &&
                Objects.equals(movies, that.movies) &&
                Objects.equals(oldMovies, that.oldMovies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(genre, movies, oldMovies);
    }

    @Override
    public String toString() {
        return "MovieGenres{" +
                "genre=" + genre +
                ", movies=" + movies +
                ", oldMovies=" + oldMovies +
                '}';
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
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
}
