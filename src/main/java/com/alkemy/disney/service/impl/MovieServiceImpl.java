package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.service.GenreService;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	@Autowired
	private MovieRepository movieRepository;
	
	
	public MovieDTO save(MovieDTO dto) {
		MovieEntity entity = movieMapper.movieDTO2Entity(dto,false);
		MovieEntity savedEntity = movieRepository.save(entity);
		MovieDTO result = movieMapper.movieEntity2DTO(savedEntity,false);
		return result;
	}

	public List<MovieBasicDTO> getAllMovies() {
		List<MovieEntity> entities = movieRepository.findAll();
		List<MovieBasicDTO> result = movieMapper.movieEntityList2DTOBasicList(entities);
		return result;
	}

	public MovieDTO getDetails(Long id) {
		return movieMapper.movieEntity2DTO(movieRepository.getById(id),true);
	}

	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}


}
