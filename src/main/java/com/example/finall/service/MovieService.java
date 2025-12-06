package com.example.finall.service;

import com.example.finall.dto.MovieDto;
import java.util.List;

public interface MovieService {

    List<MovieDto> getAll();
    MovieDto getById(Long id);
    MovieDto addMovie(MovieDto movieDto);
    MovieDto updateMovie(Long id, MovieDto movieDto);
    boolean deleteMovie(Long id);
}
