package com.alkemy.disney.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alkemy.disney.dto.GeneroDTO;
import com.alkemy.disney.entity.GeneroEntity;
import com.alkemy.disney.mapper.GeneroMapper;
import com.alkemy.disney.repository.GeneroRepository;
import com.alkemy.disney.service.GeneroService;

@Service
public class GeneroServiceImpl implements GeneroService{

	@Autowired
	private GeneroMapper generoMapper;
	@Autowired
	private GeneroRepository generoRepository;
	
	
	public GeneroDTO save(GeneroDTO dto) {
		GeneroEntity entity = generoMapper.generoDTO2Entity(dto);
		GeneroEntity entitySaved = generoRepository.save(entity);
		GeneroDTO result = generoMapper.generoEntity2DTO(entitySaved);
		return dto;
	}
	
	
}
