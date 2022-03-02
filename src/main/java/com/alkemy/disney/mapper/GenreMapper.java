package com.alkemy.disney.mapper;

import org.springframework.stereotype.Component;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;

import java.util.ArrayList;
import java.util.List;

@Component
public class GenreMapper {
	
	public GenreEntity dto2Entity(GenreDTO dto) {
		GenreEntity genreEntity = new GenreEntity();
		genreEntity.setImage(dto.getImage());
		genreEntity.setName(dto.getName());
		return genreEntity;
	}
	
	public GenreDTO entity2Dto(GenreEntity entity) {
		GenreDTO genreDTO = new GenreDTO();
		genreDTO.setId(entity.getId());
		genreDTO.setImage(entity.getImage());
		genreDTO.setName(entity.getName());
		return genreDTO;
	}

	public List<GenreDTO> entityList2DtoList(List<GenreEntity> entities){
		List<GenreDTO> dtoList = new ArrayList<>();
		for (GenreEntity entity : entities){
			dtoList.add(this.entity2Dto(entity));
		}
		return dtoList;
	}

}
