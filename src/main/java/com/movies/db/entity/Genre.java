package com.movies.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class Genre {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "genre_Sequence")
	@SequenceGenerator(name = "genre_Sequence", sequenceName = "GENRE_SEQ")
	private Long genreId;
	
	@Column(name = "name", unique = true)
	private String name;
	
	public Genre() {
		// TODO Auto-generated constructor stub
	}

	public Genre(String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Genre genre = (Genre) o;
		return Objects.equals(genreId, genre.genreId) &&
				Objects.equals(name, genre.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(genreId, name);
	}

	public Long getGenreId() {
		return genreId;
	}

	public void setGenreId(Long genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
