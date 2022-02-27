package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.GenreEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.CharacterMapper;
import com.alkemy.disney.mapper.GenreMapper;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.CharacterRepository;
import com.alkemy.disney.repository.GenreRepository;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.repository.specification.MovieSpecification;
import com.alkemy.disney.service.GenreService;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieMapper movieMapper;
	@Autowired
	private MovieRepository movieRepository;
	@Autowired
	private MovieSpecification movieSpecification;
	@Autowired
	private CharacterRepository characterRepository;
	
	
	public MovieDTO save(MovieDTO dto) {
		MovieEntity entity = movieMapper.movieDTO2Entity(dto,true);
		MovieEntity savedEntity = movieRepository.save(entity);
		MovieDTO result = movieMapper.movieEntity2DTO(savedEntity,true);
		return result;
	}

	public List<MovieBasicDTO> getAllMovies(String name,Long genreId,String order) {
		MovieFiltersDTO filtersDTO = new MovieFiltersDTO(name,genreId,order);
		List<MovieEntity> entities = movieRepository.findAll(movieSpecification.getByFilters(filtersDTO));
		List<MovieBasicDTO> result = movieMapper.movieEntityList2DTOBasicList(entities);
		return result;
	}

	public MovieDTO getDetails(Long id) {

		return movieMapper.movieEntity2DTO(movieRepository.getById(id),true);
	}

	@Override
	public MovieEntity findById(Long id) {
		Optional<MovieEntity> optional = movieRepository.findById(id);
		if(!optional.isPresent()){
			throw new ParamNotFound("Movie id is not valid");
		}
		return optional.get();
	}

	public void deleteMovie(Long id) {
		movieRepository.deleteById(id);
	}

	public MovieDTO updateMovie(Long id, MovieDTO dto) {
		MovieEntity entity = movieRepository.getById(id);
		movieMapper.movieUpdate(entity,dto);
		return movieMapper.movieEntity2DTO(movieRepository.save(entity),false);
	}

	@Override
	public MovieDTO addCharacter(Long idMovie, Long idCharacter) {
		MovieEntity movie = movieRepository.getById(idMovie);
		Set<CharacterEntity> characterSet = movie.getAssociatedCharacters();
		characterSet.add(characterRepository.getById(idCharacter));
		movie.setAssociatedCharacters(characterSet);

		return movieMapper.movieEntity2DTO(movieRepository.save(movie),true);
	}


}
