package com.alkemy.disney.service;

import com.alkemy.disney.dto.GenreDTO;

import java.util.List;

public interface GenreService {
	
	GenreDTO save(GenreDTO dto);
	List<GenreDTO> getAll();
    GenreDTO getById(Long id);
}
