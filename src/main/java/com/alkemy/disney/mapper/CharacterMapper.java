package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CharacterMapper {

    @Autowired
    MovieMapper movieMapper;

    public CharacterEntity dto2Entity(CharacterDTO dto, boolean loadMovies){
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
            //TODO load movie list, if necessary.
        }
        return entity;
    }

    public CharacterDTO entity2Dto(CharacterEntity entity, boolean loadMovies){
        CharacterDTO dto = new CharacterDTO();
        dto.setId(entity.getId());
        dto.setAge(entity.getAge());
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        dto.setHistory(entity.getHistory());
        dto.setWeight(entity.getWeight());
        if(loadMovies){
            List<MovieDTO> movieDTOList = movieMapper.entityList2DtoList(entity.getAssociatedMovies(),false);
            dto.setAssociatedMovies(movieDTOList);
        }
        return dto;
    }

    public Set<CharacterDTO> entityList2DtoList(Collection<CharacterEntity> entities, boolean loadMovies){
        Set<CharacterDTO> dtoSet = new HashSet<>();
        for (CharacterEntity entity : entities){
            dtoSet.add(this.entity2Dto(entity,loadMovies));
        }
        return dtoSet;
    }

    public CharacterBasicDTO entity2BasicDto(CharacterEntity entity){
        CharacterBasicDTO dto = new CharacterBasicDTO();
        dto.setImage(entity.getImage());
        dto.setName(entity.getName());
        return dto;
    }

    public List<CharacterBasicDTO> entityCol2BasicDtoList(Collection<CharacterEntity> entities) {
        List<CharacterBasicDTO> dtoList = new ArrayList<>();
        for (CharacterEntity entity : entities){
            dtoList.add(this.entity2BasicDto(entity));
        }
        return dtoList;
    }

    public void updateValues(CharacterEntity entity, CharacterDTO dto) {
        entity.setName(dto.getName());
        entity.setImage(dto.getImage());
        entity.setWeight(dto.getWeight());
        entity.setHistory(dto.getHistory());
        entity.setAge(dto.getAge());
    }

    public Set<CharacterEntity> dtoSet2EntitySet(Set<CharacterDTO> dtoSet, boolean loadMovies) {
        Set<CharacterEntity> entitySet = new HashSet<>();
        for (CharacterDTO dto : dtoSet){
            entitySet.add(this.dto2Entity(dto,loadMovies));
        }
        return entitySet;
    }

    /**
     * El fin de este método es borrar la relación en la tabla intermedia,
     * al borrar un character asociado a alguna movie.
     * @param characterEntity
     */
    public void removeMoviesFromEntity(CharacterEntity characterEntity){
        List<MovieEntity> movies = characterEntity.getAssociatedMovies();
        for(MovieEntity movie : movies){
            movie.getAssociatedCharacters().remove(characterEntity);
        }
    }
}
