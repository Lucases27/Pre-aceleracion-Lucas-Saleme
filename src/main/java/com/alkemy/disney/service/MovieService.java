package com.alkemy.disney.service;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.entity.MovieEntity;

import java.util.List;

public interface MovieService {
	
	MovieDTO save(MovieDTO dto);
	List<MovieBasicDTO> getAllMovies(String name, Long genreId, String order);
	MovieDTO getDetails(Long id);
	MovieEntity findById(Long id);
	void deleteMovie(Long id);
    MovieDTO updateMovie(Long id, MovieDTO dto);
    MovieDTO addCharacter(Long idMovie, Long idCharacter);
}
