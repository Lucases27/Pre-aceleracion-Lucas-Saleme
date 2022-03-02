package com.alkemy.disney.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.service.GenreService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("genres")
public class GenreController {
	
	@Autowired
	private GenreService genreService;

	@GetMapping
	public ResponseEntity<List<GenreDTO>> getAll(){
		List<GenreDTO> genres = genreService.getAll();
		return ResponseEntity.ok().body(genres);
	}


	@PostMapping
	public ResponseEntity<GenreDTO> save(@Valid @RequestBody GenreDTO genre) {
		GenreDTO savedGenre = genreService.save(genre);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedGenre);
	}
}
