package com.example.finall.controller;

import com.example.finall.dto.MovieDto;
import com.example.finall.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieApi {

    private final MovieService movieService;

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAll() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        MovieDto movieDto = movieService.getById(id);
        if (movieDto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
        return new ResponseEntity<>(movieDto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<MovieDto> addMovie(@RequestBody MovieDto movieDto) {
        MovieDto addedMovie = movieService.addMovie(movieDto);
        return new ResponseEntity<>(addedMovie, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateMovie(@PathVariable Long id, @RequestBody MovieDto movieDto) {
        MovieDto existingMovie = movieService.getById(id);
        if (existingMovie == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
        MovieDto updatedMovie = movieService.updateMovie(id, movieDto);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        boolean deleted = movieService.deleteMovie(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Movie not found");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
