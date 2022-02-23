package com.alkemy.disney.service;

import com.alkemy.disney.dto.CharacterBasicDTO;
import com.alkemy.disney.dto.CharacterDTO;
import java.util.List;
import java.util.Set;

public interface CharacterService {

    CharacterDTO save(CharacterDTO dto);
    CharacterDTO getDetails(Long id);
    CharacterDTO getById(Long id);
    CharacterDTO update(Long id, CharacterDTO character);
    List<CharacterBasicDTO> getAll(String name, Long age, Double weight, Set<Long> movies);
    void delete(Long id);
}
