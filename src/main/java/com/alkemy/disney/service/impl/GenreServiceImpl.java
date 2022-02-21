package com.alkemy.disney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.service.GenreService;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

	@Autowired
	private GenreMapper genreMapper;
	@Autowired
	private GenreRepository genreRepository;
	
	
	public GenreDTO save(GenreDTO dto) {
		GenreEntity entity = genreMapper.genreDTO2Entity(dto);
		GenreEntity savedEntity = genreRepository.save(entity);
		GenreDTO result = genreMapper.genreEntity2DTO(savedEntity);
		return result;
	}

	public List<GenreDTO> getAllGenres() {
		List<GenreEntity> entities = genreRepository.findAll();
		List<GenreDTO> result = genreMapper.genreEntityList2DTOList(entities);

		return result;
	}


}
