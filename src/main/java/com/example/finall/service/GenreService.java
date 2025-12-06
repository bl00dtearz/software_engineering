package com.example.finall.service;

import com.example.finall.dto.GenreDto;
import java.util.List;

public interface GenreService {

    List<GenreDto> getAll();
    GenreDto addGenre(GenreDto genreDto);
    boolean deleteGenre(Long id);
}
