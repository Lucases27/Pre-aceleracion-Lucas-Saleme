package com.alkemy.disney.service;

import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;

import java.util.List;

public interface MovieService {
	
	MovieDTO save(MovieDTO dto);
	List<MovieBasicDTO> getAllMovies();
	MovieDTO getDetails(Long id);
	void deleteMovie(Long id);
}
