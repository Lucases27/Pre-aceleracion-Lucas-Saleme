package com.alkemy.disney.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pelicula")
@Getter
@Setter
@SQLDelete(sql = "UPDATE pelicula set deleted = true where id = ?")
@Where(clause = "deleted = false")
public class MovieEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String image;
	private String tittle;
	
	@Column(name="creation_Date")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate creationDate;
	
	private Long score;
	private boolean deleted = Boolean.FALSE;
	
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
			fetch = FetchType.LAZY,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(
			name = "personaje_pelicula",
			joinColumns = @JoinColumn(name = "movie_id"),
			inverseJoinColumns = @JoinColumn(name = "character_id")
			)
	private Set<CharacterEntity> associatedCharacters = new HashSet<>();
	
}
