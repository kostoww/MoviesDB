package com.movies.db.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.movies.db.entity.Genre;
import com.movies.db.entity.Movie;

public interface MovieRepository extends CrudRepository<Movie, Long> {
	
	Movie findByMovieId(Long movieId);
	@Query(value = "SELECT * FROM MOVIE_GENRES WHERE GENRE_ID = ?1", nativeQuery = true)
	Movie findByGenreList(List<Genre> genreList);

}
