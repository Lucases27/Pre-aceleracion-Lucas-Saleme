package com.alkemy.disney.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="pelicula")
@Getter
@Setter
public class PeliculaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	private String imagen;
	private String titulo;
	
	@Column(name="fecha_de_creacion")
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate fechaDeCreacion;
	
	private Long calificacion;
	
	@ManyToOne(fetch = FetchType.EAGER, 
			cascade = {
				CascadeType.PERSIST,
				CascadeType.MERGE
			})
	@JoinColumn(name = "genero_id", insertable = false, updatable = false)
	private GeneroEntity genero;
	
	@Column(name = "genero_id", nullable = false)
	private Long generoId;
	
	@ManyToMany(
			fetch = FetchType.EAGER,
			cascade = {
					CascadeType.PERSIST,
					CascadeType.MERGE
			})
	@JoinTable(
			name = "personaje_pelicula",
			joinColumns = @JoinColumn(name = "pelicula_id"),
			inverseJoinColumns = @JoinColumn(name = "personaje_id")
			)
	private Set<PersonajeEntity> personajesAsociados = new HashSet<>();
	
}
