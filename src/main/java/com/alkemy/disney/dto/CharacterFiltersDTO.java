package com.alkemy.disney.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CharacterFiltersDTO {
    private String name;
    private String age;
    private String weight;
    private Set<Long> movies;

    public CharacterFiltersDTO(String name, String age, String weight, Set<Long> movies) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.movies = movies;
    }

}
