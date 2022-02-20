package com.alkemy.disney.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="genre")
@Getter
@Setter
public class GenreEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String image;
}
