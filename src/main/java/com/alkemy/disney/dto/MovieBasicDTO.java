package com.alkemy.disney.dto;

import com.alkemy.disney.entity.CharacterEntity;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class MovieBasicDTO {
    private String tittle;
    private String image;
    private String creationDate;
}
