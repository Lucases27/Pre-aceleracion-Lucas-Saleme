package com.alkemy.disney.dto;

import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.apache.bcel.classfile.Module;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class MovieDTO {
    private Long id;
    private String tittle;
    private String image;
    private Long score;
    private String creationDate;
    private Long genreId;
    private Set<CharacterDTO> associatedCharacters = new HashSet<>();
}
