package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    @Autowired
    CharacterMapper characterMapper;

    public MovieDTO movieEntity2DTO(MovieEntity entity, boolean loadCharacters){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setImage(entity.getImage());
        movieDTO.setScore(entity.getScore());
        movieDTO.setGenreId(entity.getGenreId());
        movieDTO.setTitle(entity.getTittle());
        movieDTO.setCreationDate(entity.getCreationDate().toString());
        if (loadCharacters){
            Set<CharacterEntity> characterEntitySet = entity.getAssociatedCharacters();
            List<CharacterDTO> characterDTOList = characterMapper.characterEntityList2DTOList(characterEntitySet,false);
        }
        return movieDTO;
    }

    public List<MovieDTO> movieEntityList2DTOList(List<MovieEntity> entities, boolean loadCharacters) {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for (MovieEntity entity : entities){
            movieDTOList.add(this.movieEntity2DTO(entity,loadCharacters));
        }
        return movieDTOList;
    }
}
