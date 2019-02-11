package com.movies.db.entity;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Movie {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "movie_Sequence")
    @SequenceGenerator(name = "movie_Sequence", sequenceName = "MOVIE_SEQ")
    private Long movieId;
	
	@Column(name = "title")
    private String title;

	@Column(name = "year")
	private Integer year;

	@Column(name = "duration")
	private Integer duration;

	@Column(name = "img_url")
    private String imgUrl;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name = "movie_actors",
			joinColumns = { @JoinColumn(name = "movie_id") },
			inverseJoinColumns = { @JoinColumn(name = "actor_id") }
	)
    private List<Actor> actorList;
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
	@JoinTable(name = "movie_genres",
		joinColumns = { @JoinColumn(name = "movie_id") }, 
		inverseJoinColumns = { @JoinColumn(name = "genre_id") }
	)
    private List<Genre> genreList;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String title, Integer year, Integer duration, String imgUrl) {
		super();
		this.title = title;
		this.year = year;
		this.duration = duration;
		this.imgUrl = imgUrl;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Movie movie = (Movie) o;
		return Objects.equals(movieId, movie.movieId) &&
				Objects.equals(title, movie.title) &&
				Objects.equals(year, movie.year) &&
				Objects.equals(duration, movie.duration) &&
				Objects.equals(imgUrl, movie.imgUrl) &&
				Objects.equals(actorList, movie.actorList) &&
				Objects.equals(genreList, movie.genreList);
	}

	@Override
	public int hashCode() {
		return Objects.hash(movieId, title, year, duration, imgUrl, actorList, genreList);
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public String getImgUrl() {
		return imgUrl;
	}


	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<Actor> getActorList() {
		return actorList;
	}

	public void setActorList(List<Actor> actorList) {
		this.actorList = actorList;
	}

	public List<Genre> getGenreList() {
		return genreList;
	}

	public void setGenreList(List<Genre> genreList) {
		this.genreList = genreList;
	}
	
}
