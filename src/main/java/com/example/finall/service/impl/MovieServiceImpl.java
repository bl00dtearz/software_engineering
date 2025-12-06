package com.example.finall.service.impl;

import com.example.finall.dto.MovieDto;
import com.example.finall.mapper.MovieMapper;
import com.example.finall.model.Movie;
import com.example.finall.model.Director;
import com.example.finall.model.Genre;
import com.example.finall.repository.MovieRepository;
import com.example.finall.repository.DirectorRepository;
import com.example.finall.repository.GenreRepository;
import com.example.finall.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    private final DirectorRepository directorRepository;
    private final GenreRepository genreRepository;

    @Override
    public List<MovieDto> getAll() {
        List<Movie> movies = movieRepository.findAll();
        return movieMapper.toDtoList(movies);
    }

    @Override
    public MovieDto getById(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            return movieMapper.toDto(movie);
        } else {
            return null;
        }
    }

    @Override
    public MovieDto addMovie(MovieDto movieDto) {
        Movie movie = movieMapper.toEntity(movieDto);

        if (movieDto.getDirector() != null && movieDto.getDirector().getId() != null) {
            Director director = directorRepository.findById(movieDto.getDirector().getId())
                    .orElseThrow(() -> new RuntimeException("Director not found with id: " + movieDto.getDirector().getId()));
            movie.setDirector(director);
        }

        if (movieDto.getGenres() != null && !movieDto.getGenres().isEmpty()) {
            List<Genre> genres = movieDto.getGenres().stream()
                    .map(genreDto -> genreRepository.findById(genreDto.getId())
                            .orElseThrow(() -> new RuntimeException("Genre not found with id: " + genreDto.getId())))
                    .collect(Collectors.toList());
            movie.setGenres(genres);
        }

        movieRepository.save(movie);
        return movieMapper.toDto(movie);
    }

    @Override
    public MovieDto updateMovie(Long id, MovieDto movieDto) {
        Movie movie = movieRepository.findById(id).orElse(null);

        if (movie != null) {
            movie.setTitle(movieDto.getTitle());
            movie.setReleaseYear(movieDto.getReleaseYear());

            if (movieDto.getDirector() != null && movieDto.getDirector().getId() != null) {
                Director director = directorRepository.findById(movieDto.getDirector().getId())
                        .orElseThrow(() -> new RuntimeException("Director not found with id: " + movieDto.getDirector().getId()));
                movie.setDirector(director);
            }

            if (movieDto.getGenres() != null && !movieDto.getGenres().isEmpty()) {
                List<Genre> genres = movieDto.getGenres().stream()
                        .map(genreDto -> genreRepository.findById(genreDto.getId())
                                .orElseThrow(() -> new RuntimeException("Genre not found with id: " + genreDto.getId())))
                        .collect(Collectors.toList());
                movie.setGenres(genres);
            }

            movieRepository.save(movie);
        } else {
            System.out.println("Movie with id " + id + " not found");
        }

        return movieMapper.toDto(movie);
    }

    @Override
    public boolean deleteMovie(Long id) {
        Movie movie = movieRepository.findById(id).orElse(null);
        if (movie != null) {
            movieRepository.deleteById(id);
            return true;
        } else {
            System.out.println("Movie with id " + id + " not found");
            return false;
        }
    }
}
