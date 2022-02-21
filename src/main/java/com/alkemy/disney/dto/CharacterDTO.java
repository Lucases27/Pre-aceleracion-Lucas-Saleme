package com.alkemy.disney.dto;

import com.alkemy.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CharacterDTO {
    private Long id;
    private String name;
    private String image;
    private Long age;
    private Double weight;
    private String history;
    private List<MovieEntity> associatedMovies = new ArrayList<>();
}
