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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MovieMapper {

    @Autowired
    CharacterMapper characterMapper;

    public MovieEntity dto2Entity(MovieDTO dto, boolean loadCharacters){
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
            Set<CharacterEntity> charactersEntitySet = characterMapper.dtoSet2EntitySet(dtoSet,false);
            entity.setAssociatedCharacters(charactersEntitySet);
        }
        return entity;
    }

    public MovieDTO entity2Dto(MovieEntity entity, boolean loadCharacters){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(entity.getId());
        movieDTO.setImage(entity.getImage());
        movieDTO.setScore(entity.getScore());
        movieDTO.setGenreId(entity.getGenreId());
        movieDTO.setTittle(entity.getTittle());
        movieDTO.setCreationDate(entity.getCreationDate().toString());
        if (loadCharacters){
            Set<CharacterEntity> characterEntitySet = entity.getAssociatedCharacters();
            Set<CharacterDTO> characterDTOSet = characterMapper.entityList2DtoList(characterEntitySet,false);
            movieDTO.setAssociatedCharacters(characterDTOSet);
        }
        return movieDTO;
    }

    public MovieBasicDTO entity2BasicDto(MovieEntity entity){
        MovieBasicDTO basicDTO = new MovieBasicDTO();
        basicDTO.setImage(entity.getImage());
        basicDTO.setTittle(entity.getTittle());
        basicDTO.setCreationDate(entity.getCreationDate().toString());
        return basicDTO;
    }

    public List<MovieBasicDTO> entityList2BasicDtoList(List<MovieEntity> entityList){
        List<MovieBasicDTO> basicDTOList = new ArrayList<>();
        for (MovieEntity entity : entityList){
            basicDTOList.add(this.entity2BasicDto(entity));
        }
        return basicDTOList;
    }

    public List<MovieDTO> entityList2DtoList(List<MovieEntity> entities, boolean loadCharacters) {
        List<MovieDTO> movieDTOList = new ArrayList<>();
        for (MovieEntity entity : entities){
            movieDTOList.add(this.entity2Dto(entity,loadCharacters));
        }
        return movieDTOList;
    }
    public Set<MovieDTO> entityList2DtoSet(Set<MovieEntity> entities, boolean loadCharacters) {
        Set<MovieDTO> movieDTOList = new HashSet<>();
        for (MovieEntity entity : entities){
            movieDTOList.add(this.entity2Dto(entity,loadCharacters));
        }
        return movieDTOList;
    }

    public void updateValues(MovieEntity entity, MovieDTO dto) {
        entity.setImage(dto.getImage());
        entity.setScore(dto.getScore());
        entity.setTittle(dto.getTittle());
        entity.setCreationDate(DateUtil.string2LocalDate(dto.getCreationDate()));
        entity.setGenreId(dto.getGenreId());
    }
}
