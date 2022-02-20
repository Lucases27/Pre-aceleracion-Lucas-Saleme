package com.alkemy.disney.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "`character`")
@Getter
@Setter
public class CharacterEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String image;
	private String name;
	private Long age;
	private Double weight;
	private String history;
	
	@ManyToMany(mappedBy = "associatedCharacters",
			cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE
			})
	private List<MovieEntity> associatedMovies = new ArrayList<>();
}
