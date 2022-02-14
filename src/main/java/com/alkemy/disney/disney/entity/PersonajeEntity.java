package com.alkemy.disney.disney.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "personaje")
@Getter
@Setter
public class PersonajeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String imagen;
	private String nombre;
	private Long edad;
	private Double peso;
	private String historia;
	
	@ManyToMany(mappedBy = "personajesAsociados", cascade = CascadeType.ALL)
	private List<PeliculaEntity> peliculasAsociadas = new ArrayList<>();
}
