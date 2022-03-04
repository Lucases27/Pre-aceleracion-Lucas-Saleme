package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CharacterDTO {

    private Long id;
    @NotEmpty(message = "The field must be not empty")
    @Size(min=2, max=30)
    private String name;
    private String image;
    @NotNull @Min(0) @Max(1000)
    private Long age;
    private Double weight;
    private String history;
    private List<MovieDTO> associatedMovies = new ArrayList<>();
}
