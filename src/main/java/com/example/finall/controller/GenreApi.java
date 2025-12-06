package com.example.finall.controller;

import com.example.finall.dto.GenreDto;
import com.example.finall.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/genre")
public class GenreApi {

    private final GenreService genreService;

    @GetMapping
    public ResponseEntity<List<GenreDto>> getAll() {
        return new ResponseEntity<>(genreService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenreDto> addGenre(@RequestBody GenreDto genreDto) {
        GenreDto added = genreService.addGenre(genreDto);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGenre(@PathVariable Long id) {
        boolean deleted = genreService.deleteGenre(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Genre not found");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
