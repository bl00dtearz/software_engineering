package com.example.finall.service.impl;

import com.example.finall.dto.GenreDto;
import com.example.finall.mapper.GenreMapper;
import com.example.finall.model.Genre;
import com.example.finall.repository.GenreRepository;
import com.example.finall.service.GenreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;

    @Override
    public List<GenreDto> getAll() {
        List<Genre> genres = genreRepository.findAll();
        return genreMapper.toDtoList(genres);
    }

    @Override
    public GenreDto addGenre(GenreDto genreDto) {
        Genre genre = genreMapper.toEntity(genreDto);
        genreRepository.save(genre);
        return genreMapper.toDto(genre);
    }

    @Override
    public boolean deleteGenre(Long id) {
        Genre genre = genreRepository.findById(id).orElse(null);
        if (genre != null) {
            genreRepository.deleteById(id);
            return true;
        } else {
            System.out.println("Genre with id " + id + " not found");
            return false;
        }
    }
}
