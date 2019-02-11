package com.movies.db.repo;

import com.movies.db.entity.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.movies.db.entity.Actor;

import java.math.BigDecimal;
import java.util.List;

public interface ActorRepository extends CrudRepository<Actor, Long> {
    @Query(value = "SELECT movie_id FROM movie_actors WHERE actor_id = ?1", nativeQuery = true)
    List<BigDecimal> findAllMoviesByActor(Long actorId);
}
