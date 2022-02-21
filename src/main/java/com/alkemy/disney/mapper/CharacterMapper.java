package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterMapper {

    public CharacterEntity characterDTO2Entity(CharacterDTO dto, boolean loadMovies){
        CharacterEntity entity = new CharacterEntity();
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
            //TODO load movie list.
        }
        return dto;
    }

    public List<CharacterDTO> characterEntityList2DTOList(List<CharacterEntity> entities){
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
}
