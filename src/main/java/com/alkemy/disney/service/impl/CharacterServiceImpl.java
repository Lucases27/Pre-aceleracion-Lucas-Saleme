package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.service.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        List<CharacterBasicDTO> dtoList = new ArrayList<>();
        for(CharacterEntity entity : characterRepository.findAll()){
            dtoList.add(characterMapper.characterEntity2DTOBasic(entity));
        }
        return dtoList;
    }
}
