package com.alkemy.disney.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Table(name = "personaje")
@Getter
@Setter
@SQLDelete(sql = "UPDATE personaje set deleted = true where id = ?")
@Where(clause = "deleted = false")
public class CharacterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String image;
	private String name;
	private Long age;
	private Double weight;
	private String history;
	private boolean deleted = Boolean.FALSE;
	
	@ManyToMany(mappedBy = "associatedCharacters",
			cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE,
			})
	private List<MovieEntity> associatedMovies = new ArrayList<>();

	public void addMovie(MovieEntity movie){
		this.associatedMovies.add(movie);
		movie.getAssociatedCharacters().add(this);
	}

	public void removeMovie(MovieEntity movie){
		this.associatedMovies.remove(movie);
		movie.getAssociatedCharacters().remove(this);
	}
}
