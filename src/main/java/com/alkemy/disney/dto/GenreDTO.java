package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class GenreDTO {
	private Long id;
	@NotEmpty (message = "The field must be not empty.")
	@Size(min=2, max=30)
	private String name;
	@NotEmpty (message = "The field must be not empty.")
	private String image;
}
