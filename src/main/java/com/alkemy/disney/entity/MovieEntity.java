package com.alkemy.disney.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="movie")
@Getter
@Setter
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String image;
	private String tittle;
	
	@Column(name="creation_Date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate creationDate;
	
	private Long score;
	
	@ManyToOne(fetch = FetchType.EAGER, 
			cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE
			})
	@JoinColumn(name = "genre_id", insertable = false, updatable = false)
	private GenreEntity genre;
	
	@Column(name = "genre_id", nullable = false)
	private Long genreId;
	
	@ManyToMany(
			fetch = FetchType.EAGER,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(
			name = "character_movie",
			joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "character_id")
			)
	private Set<CharacterEntity> associatedCharacters = new HashSet<>();
	
}
