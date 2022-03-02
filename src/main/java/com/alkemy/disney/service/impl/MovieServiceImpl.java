package com.alkemy.disney.service.impl;

import com.alkemy.disney.dto.*;
import com.alkemy.disney.entity.CharacterEntity;
import com.alkemy.disney.entity.MovieEntity;
import com.alkemy.disney.exception.ParamNotFound;
import com.alkemy.disney.mapper.MovieMapper;
import com.alkemy.disney.repository.MovieRepository;
import com.alkemy.disney.repository.specification.MovieSpecification;
import com.alkemy.disney.service.CharacterService;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
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
	private CharacterService characterService;
	
	
	public MovieDTO save(MovieDTO dto) {
		MovieEntity entity = movieMapper.dto2Entity(dto,true);
		MovieEntity savedEntity = movieRepository.save(entity);
		MovieDTO result = movieMapper.entity2Dto(savedEntity,true);
		return result;
	}

	public List<MovieBasicDTO> getAll(String name, Long genreId, String order) {
		MovieFiltersDTO filtersDTO = new MovieFiltersDTO(name,genreId,order);
		List<MovieEntity> entities = movieRepository.findAll(movieSpecification.getByFilters(filtersDTO));
		List<MovieBasicDTO> result = movieMapper.entityList2BasicDtoList(entities);
		return result;
	}

	public MovieDTO getDetails(Long id) {
		MovieEntity entity = this.findById(id);
		return movieMapper.entity2Dto(entity,true);
	}

	@Override
	public MovieEntity findById(Long id) {
		Optional<MovieEntity> optional = movieRepository.findById(id);
		if(!optional.isPresent()){
			throw new ParamNotFound("Movie id is not valid");
		}
		return optional.get();
	}

	public void delete(Long id) {
		this.findById(id);
		movieRepository.deleteById(id);
	}

	public MovieDTO update(Long id, MovieDTO dto) {
		MovieEntity entity = this.findById(id);
		movieMapper.updateValues(entity,dto);
		return movieMapper.entity2Dto(movieRepository.save(entity),false);
	}

	@Override
	public MovieDTO addCharacterToMovie(Long idMovie, Long idCharacter) {
		MovieEntity movie = this.findById(idMovie);
		Set<CharacterEntity> characterSet = movie.getAssociatedCharacters();
		characterSet.add(characterService.findById((idCharacter)));
		movie.setAssociatedCharacters(characterSet);

		return movieMapper.entity2Dto(movieRepository.save(movie),true);
	}


}
