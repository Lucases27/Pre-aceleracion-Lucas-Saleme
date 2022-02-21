package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.CharacterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class CharacterMapper {

    @Autowired
    MovieMapper movieMapper;

    public CharacterEntity characterDTO2Entity(CharacterDTO dto, boolean loadMovies){
        CharacterEntity entity = new CharacterEntity();
        if(dto.getId()!=null){
            entity.setId(dto.getId());
        }
        entity.setAge(dto.getAge());
        entity.setHistory(dto.getHistory());
        entity.setImage(dto.getImage());
        entity.setName(dto.getName());
        entity.setWeight(dto.getWeight());
        if(loadMovies){
            //TODO load movie list.
        }
        return entity;
    }

    public CharacterDTO characterEntity2DTO(CharacterEntity entity, boolean loadMovies){
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setAge(entity.getAge());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setHistory(entity.getHistory());
        dto.setWeight(entity.getWeight());
        if(loadMovies){
            //TODO dto y mapper de Peliculas.
            List<MovieDTO> movieDTOList = movieMapper.movieEntityList2DTOList(entity.getAssociatedMovies(),false);
            dto.setAssociatedMovies(movieDTOList);
        }
        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList(Collection<CharacterEntity> entities){
        List<CharacterDTO> dtoList = new ArrayList<>();
        for (CharacterEntity entity : entities){
            dtoList.add(this.characterEntity2DTO(entity,false));
        }
        return dtoList;
    }

    public CharacterBasicDTO characterEntity2DTOBasic(CharacterEntity entity){
        CharacterBasicDTO dto = new CharacterBasicDTO();
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        return dto;
    }

    public List<CharacterBasicDTO> characterEntity2DTOBasicList(Collection<CharacterEntity> entities) {
        List<CharacterBasicDTO> dtoList = new ArrayList<>();
        for (CharacterEntity entity : entities){
            dtoList.add(this.characterEntity2DTOBasic(entity));
        }
        return dtoList;
    }
}
