package com.alkemy.disney.service;

import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.MovieEntity;

import java.util.List;

public interface MovieService {
	
	MovieDTO save(MovieDTO dto);
	List<MovieBasicDTO> getAll(String name, Long genreId, String order);
	MovieDTO getDetails(Long id);
	MovieEntity findById(Long id);
	void delete(Long id);
    MovieDTO update(Long id, MovieDTO dto);
    MovieDTO addCharacterToMovie(Long idMovie, Long idCharacter);
}
