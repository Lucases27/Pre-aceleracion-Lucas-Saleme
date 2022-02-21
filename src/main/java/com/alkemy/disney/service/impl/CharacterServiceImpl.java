package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Autowired
    CharacterMapper characterMapper;
    @Autowired
    CharacterRepository characterRepository;


    public CharacterDTO save(CharacterDTO dto){
        CharacterEntity characterEntity = characterMapper.characterDTO2Entity(dto,false);
        CharacterEntity savedEntity = characterRepository.save(characterEntity);
        return characterMapper.characterEntity2DTO(savedEntity,false);
    }

    public List<CharacterBasicDTO> getAll() {
        List<CharacterEntity> entities = characterRepository.findAll();
        List<CharacterBasicDTO> dtoList = characterMapper.characterEntity2DTOBasicList(entities);
        return dtoList;
    }

    public CharacterDTO getDetails(Long id) {
        return characterMapper.characterEntity2DTO(characterRepository.getById(id),true);
    }

    public CharacterDTO getById(Long id) {
        CharacterEntity characterEntity = characterRepository.getById(id);
        return characterMapper.characterEntity2DTO(characterEntity,false);
    }


    public CharacterDTO update(Long id, CharacterDTO character) {
        CharacterDTO characterToUpdate = this.getById(id);
        characterToUpdate.setName(character.getName());
        characterToUpdate.setImage(character.getImage());
        characterToUpdate.setWeight(character.getWeight());
        characterToUpdate.setHistory(character.getHistory());
        characterToUpdate.setAge(character.getAge());
        CharacterEntity entity = characterMapper.characterDTO2Entity(characterToUpdate,false);
        return characterMapper.characterEntity2DTO(characterRepository.save(entity),false);
    }

    public void delete(Long id){
        characterRepository.deleteById(id);
    }
}
