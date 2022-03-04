package com.alkemy.disney.dto;

import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import lombok.Getter;
import lombok.Setter;
import org.aspectj.apache.bcel.classfile.Module;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class MovieDTO {
    private Long id;
    @NotEmpty (message = "The field must not be empty")
    @Size(min=2, max=30)
    private String tittle;
    private String image;
    private Long score;
    private String creationDate;
    @NotNull (message = "The field must be not null")
    private Long genreId;
    private Set<CharacterDTO> associatedCharacters = new HashSet<>();
}
