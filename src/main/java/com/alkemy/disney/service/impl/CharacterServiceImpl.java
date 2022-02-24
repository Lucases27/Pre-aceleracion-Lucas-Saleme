package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterFiltersDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.repository.specification.CharacterSpecification;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    private CharacterMapper characterMapper;
    @Autowired
    private CharacterRepository characterRepository;
    @Autowired
    private CharacterSpecification characterSpecification;


    public CharacterDTO save(CharacterDTO dto){
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(dto,false);
        CharacterEntity savedEntity = characterRepository.save(characterEntity);
        return characterMapper.characterEntity2DTO(savedEntity,false);
    }

    public List<CharacterBasicDTO> getAll(String name, Long age, Double weight, Set<Long> movies) {
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name,age,weight,movies);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDTO));
        List<CharacterBasicDTO> dtoList = characterMapper.characterEntity2DTOBasicList(entities);
        return dtoList;
    }

    public CharacterDTO getDetails(Long id) {
        Optional<CharacterEntity> entity = characterRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Character id is not valid");
        }
        return characterMapper.characterEntity2DTO(characterRepository.getById(id),true);
    }

    public CharacterDTO getById(Long id) {
        CharacterEntity characterEntity = characterRepository.getById(id);
        return characterMapper.characterEntity2DTO(characterEntity,false);
    }


    public CharacterDTO update(Long id, CharacterDTO characterDTO) {
        CharacterEntity characterEntity = characterRepository.getById(id);
        characterMapper.characterEntityUpdate(characterEntity,characterDTO);
        return characterMapper.characterEntity2DTO(characterRepository.save(characterEntity),false);
    }

    public void delete(Long id){
        CharacterEntity characterEntity = characterRepository.getById(id);
        characterMapper.removeMovies(characterEntity);
        characterRepository.deleteById(id);
    }
}
