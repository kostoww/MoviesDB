package com.movies.db.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

@Entity
public class Actor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "actor_Seqeuence")
	@SequenceGenerator(name="actor_Seqeuence", sequenceName = "ACTOR_SEQ")
	private Long actorId;
	
	@Column(name = "first_name")
    private String firstName;
	
	@Column(name = "last_name")
    private String lastName;
	
	@Column(name = "age")
    private Integer age;
	
	@Column(name = "gender")
	@Enumerated(EnumType.STRING)
    private Gender gender;
	
	public Actor() {
		// TODO Auto-generated constructor stub
	}

	public Actor(String firstName, String lastName, Integer age, Gender gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Actor actor = (Actor) o;
		return Objects.equals(actorId, actor.actorId) &&
				Objects.equals(firstName, actor.firstName) &&
				Objects.equals(lastName, actor.lastName) &&
				Objects.equals(age, actor.age) &&
				gender == actor.gender;
	}

	@Override
	public int hashCode() {
		return Objects.hash(actorId, firstName, lastName, age, gender);
	}

	public Long getActorId() {
		return actorId;
	}

	public void setActorId(Long actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Integer getAge() {
		return age;
	}


	public void setAge(Integer age) {
		this.age = age;
	}


	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
}
