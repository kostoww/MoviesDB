package com.movies.db.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.movies.db.entity.Genre;

import java.math.BigDecimal;
import java.util.List;

public interface GenreRepository extends CrudRepository<Genre, Long> {

	Genre findByName(String name);
	@Query(value = "SELECT * FROM movie_genres WHERE genre_id = ?1", nativeQuery = true)
	List<BigDecimal> findGenreMoviesCount(long id);
	@Query(value = "SELECT movie_id FROM movie_genres WHERE genre_id = ?1", nativeQuery = true)
	List<BigDecimal> findAllMoviesByGenre(Long genreId);



}
