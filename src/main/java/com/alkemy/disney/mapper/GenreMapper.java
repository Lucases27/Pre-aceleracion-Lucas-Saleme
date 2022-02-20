package com.alkemy.disney.mapper;

import org.springframework.stereotype.Component;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;

@Component
public class GenreMapper {
	
	public GenreEntity genreDTO2Entity(GenreDTO dto) {
		GenreEntity genreEntity = new GenreEntity();
		genreEntity.setImage(dto.getImage());
		genreEntity.setName(dto.getName());
		return genreEntity;
	}
	
	public GenreDTO genreEntity2DTO(GenreEntity entity) {
		GenreDTO genreDTO = new GenreDTO();
		genreDTO.setId(entity.getId());
		genreDTO.setImage(entity.getImage());
		genreDTO.setName(entity.getName());
		return genreDTO;
	}

}
