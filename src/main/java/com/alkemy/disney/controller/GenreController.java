package com.alkemy.disney.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.alkemy.disney.dto.GenreDTO;
import com.alkemy.disney.service.GenreService;

@RestController
@RequestMapping("genres")
public class GenreController {
	
	@Autowired
	private GenreService genreService;
	
	@PostMapping
	public ResponseEntity<GenreDTO> save(@RequestBody GenreDTO genre) {
		GenreDTO savedGenre = genreService.save(genre);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedGenre);
	}
}
