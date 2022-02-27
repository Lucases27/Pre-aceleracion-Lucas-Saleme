package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import com.alkemy.disney.entity.CharacterEntity;

import java.util.List;
import java.util.Set;

public interface CharacterService {

    CharacterDTO save(CharacterDTO dto);
    CharacterDTO getDetails(Long id);
    CharacterEntity findById(Long id);
    CharacterDTO update(Long id, CharacterDTO character);
    List<CharacterBasicDTO> getAll(String name, Long age, Double weight, Set<Long> movies);
    void delete(Long id);
}
