package com.alkemy.disney.controller;
import com.alkemy.disney.dto.MovieBasicDTO;
import com.alkemy.disney.dto.MovieDTO;
import com.alkemy.disney.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieBasicDTO>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long genre,
            @RequestParam(required = false) String order){
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies(name,genre,order));
    }

    @PostMapping
    public ResponseEntity<MovieDTO> save(@RequestBody MovieDTO dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.save(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getDetails(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND).body(movieService.getDetails(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> update(@PathVariable Long id, @RequestBody MovieDTO dto){
        MovieDTO updatedDTO = movieService.updateMovie(id,dto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedDTO);
    }

    @PostMapping("/{idMovie}/addCharacter/{idCharacter}")
    public ResponseEntity<MovieDTO> addCharacter(@PathVariable Long idMovie, @PathVariable Long idCharacter){
        MovieDTO movieDTO = movieService.addCharacter(idMovie,idCharacter);
        return ResponseEntity.status(HttpStatus.CREATED).body(movieDTO);
    }

}
