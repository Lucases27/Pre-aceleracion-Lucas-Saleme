package com.alkemy.disney.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="genero")
@Getter
@Setter
public class GenreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String image;

	@OneToMany(mappedBy = "genre",
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE,
			})
	private Set<MovieEntity> associatedMovies = new HashSet<>();

	public void addMovie(MovieEntity movie) {
		if (!associatedMovies.contains(movie)) {
			associatedMovies.add(movie);
			movie.setGenreId(this.getId());
		}
	}
}
