package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Getter
@Setter
public class GenreDTO {
	private Long id;
	private String name;
	private String image;
}
