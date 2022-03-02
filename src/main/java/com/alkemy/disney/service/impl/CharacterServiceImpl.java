package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.dto.CharacterFiltersDTO;
import com.alkemy.disney.entity.CharacterEntity;
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
        CharacterEntity characterEntity = characterMapper.dto2Entity(dto,false);
        CharacterEntity savedEntity = characterRepository.save(characterEntity);
        return characterMapper.entity2Dto(savedEntity,false);
    }

    public CharacterDTO getDetails(Long id) {
        CharacterEntity entity = this.findById(id);
        return characterMapper.entity2Dto(entity,true);
    }

    public List<CharacterBasicDTO> getAll(String name, Long age, Double weight, Set<Long> movies) {
        CharacterFiltersDTO filtersDTO = new CharacterFiltersDTO(name,age,weight,movies);
        List<CharacterEntity> entities = characterRepository.findAll(characterSpecification.getByFilters(filtersDTO));
        List<CharacterBasicDTO> dtoList = characterMapper.entityCol2BasicDtoList(entities);
        return dtoList;
    }

    public CharacterDTO update(Long id, CharacterDTO characterDTO) {
        CharacterEntity characterEntity = this.findById(id);
        characterMapper.updateValues(characterEntity,characterDTO);
        return characterMapper.entity2Dto(characterRepository.save(characterEntity),false);
    }

    public void delete(Long id){
        CharacterEntity characterEntity = this.findById(id);
        characterMapper.removeMoviesFromEntity(characterEntity);
        characterRepository.deleteById(id);
    }

    public CharacterEntity findById(Long id) {
        Optional<CharacterEntity> optional = characterRepository.findById(id);
        if(!optional.isPresent()){
            throw new ParamNotFound("Character id is not valid");
        }
        return optional.get();
    }
}
