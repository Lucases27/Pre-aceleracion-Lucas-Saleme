package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        entity.setCreationDate(DateUtil.string2LocalDate(dto.getCreationDate()));
        if(loadCharacters){
            Set<CharacterDTO> dtoSet = dto.getAssociatedCharacters();
            Set<CharacterEntity> charactersEntitySet = characterMapper.characterDTO2EntitySet(dtoSet,false);
            entity.setAssociatedCharacters(charactersEntitySet);
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
            Set<CharacterDTO> characterDTOSet = characterMapper.characterEntityList2DTOList(characterEntitySet,false);
            movieDTO.setAssociatedCharacters(characterDTOSet);
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

    public void movieUpdate(MovieEntity entity, MovieDTO dto) {
        entity.setImage(dto.getImage());
        entity.setScore(dto.getScore());
        entity.setTittle(dto.getTittle());
        entity.setCreationDate(DateUtil.string2LocalDate(dto.getCreationDate()));
        entity.setGenreId(dto.getGenreId());
    }
}
