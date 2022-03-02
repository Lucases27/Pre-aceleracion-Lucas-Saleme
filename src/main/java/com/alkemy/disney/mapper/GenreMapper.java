package com.alkemy.disney.mapper;

import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.MovieEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.entity.GenreEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class GenreMapper {

	@Autowired
	private MovieMapper movieMapper;
	
	public GenreEntity dto2Entity(GenreDTO dto) {
		GenreEntity genreEntity = new GenreEntity();
		genreEntity.setImage(dto.getImage());
		genreEntity.setName(dto.getName());
		return genreEntity;
	}
	
	public GenreDTO entity2Dto(GenreEntity entity) {
		GenreDTO genreDTO = new GenreDTO();
		genreDTO.setId(entity.getId());
		genreDTO.setName(entity.getName());
		genreDTO.setImage(entity.getImage());
		Set<MovieDTO> movieList = movieMapper.entityList2DtoSet(entity.getAssociatedMovies(),true);
		genreDTO.setAssociatedMovies(movieList);
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
