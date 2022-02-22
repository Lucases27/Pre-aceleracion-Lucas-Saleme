package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    @Autowired
    CharacterMapper characterMapper;



    public MovieEntity movieDTO2Entity(MovieDTO dto, boolean loadCharacters){
        MovieEntity entity = new MovieEntity();
        if(dto.getId()!=null){
            entity.setId(dto.getId());
        }
        entity.setTittle(dto.getTittle());
        entity.setGenreId(dto.getGenreId());
        entity.setImage(dto.getImage());
        entity.setScore(dto.getScore());
        entity.setCreationDate(this.string2LocalDate(dto.getCreationDate()));
        if(loadCharacters){
            //TODO load movie list.
        }
        return entity;
    }



    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacters){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setImage(entity.getImage());
        movieDTO.setScore(entity.getScore());
        movieDTO.setGenreId(entity.getGenreId());
        movieDTO.setTittle(entity.getTittle());
        movieDTO.setCreationDate(entity.getCreationDate().toString());
        if (loadCharacters){
            Set<CharacterEntity> characterEntitySet = entity.getAssociatedCharacters();
            List<CharacterDTO> characterDTOList = characterMapper.characterEntityList2DTOList(characterEntitySet,false);
        }
        return movieDTO;
    }

    public MovieBasicDTO movieEntity2DTOBasic(MovieEntity entity){
        MovieBasicDTO basicDTO = new MovieBasicDTO();
        basicDTO.setImage(entity.getImage());
        basicDTO.setTittle(entity.getTittle());
        basicDTO.setCreationDate(entity.getCreationDate().toString());
        return basicDTO;
    }

    public List<MovieBasicDTO> movieEntityList2DTOBasicList(List<MovieEntity> entityList){
        List<MovieBasicDTO> basicDTOList = new ArrayList<>();
        for (MovieEntity entity : entityList){
            basicDTOList.add(this.movieEntity2DTOBasic(entity));
        }
        return basicDTOList;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters) {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for (MovieEntity entity : entities){
            movieDTOList.add(this.movieEntity2DTO(entity,loadCharacters));
        }
        return movieDTOList;
    }


    public LocalDate string2LocalDate(String stringDate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse(stringDate,formatter);
        return date;
    }
}
