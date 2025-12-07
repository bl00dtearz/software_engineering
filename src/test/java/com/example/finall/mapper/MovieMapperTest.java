package com.example.finall.mapper;

import com.example.finall.dto.MovieDto;
import com.example.finall.mapper.MovieMapper;
import com.example.finall.model.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MovieMapperTest {

    @Autowired
    private MovieMapper movieMapper;

    @Test
    void convertEntityToDtoTest() {

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setTitle("Inception");
        movie.setDescription("Dream heist movie");
        movie.setReleaseYear(2010);
        movie.setRating(8.8);
        movie.setCountry("USA");

        MovieDto dto = movieMapper.toDto(movie);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getTitle());
        Assertions.assertNotNull(dto.getDescription());
        Assertions.assertNotNull(dto.getReleaseYear());
        Assertions.assertNotNull(dto.getRating());
        Assertions.assertNotNull(dto.getCountry());

        Assertions.assertEquals(movie.getId(), dto.getId());
        Assertions.assertEquals(movie.getTitle(), dto.getTitle());
        Assertions.assertEquals(movie.getDescription(), dto.getDescription());
        Assertions.assertEquals(movie.getReleaseYear(), dto.getReleaseYear());
        Assertions.assertEquals(movie.getRating(), dto.getRating());
        Assertions.assertEquals(movie.getCountry(), dto.getCountry());
    }

    @Test
    void convertDtoToEntityTest() {
        MovieDto dto = new MovieDto();
        dto.setId(1L);
        dto.setTitle("Inception");
        dto.setDescription("Dream heist movie");
        dto.setReleaseYear(2010);
        dto.setRating(8.8);
        dto.setCountry("USA");

        Movie movie = movieMapper.toEntity(dto);

        Assertions.assertNotNull(movie);
        Assertions.assertNotNull(movie.getId());
        Assertions.assertNotNull(movie.getTitle());
        Assertions.assertNotNull(movie.getDescription());
        Assertions.assertNotNull(movie.getReleaseYear());
        Assertions.assertNotNull(movie.getRating());
        Assertions.assertNotNull(movie.getCountry());

        Assertions.assertEquals(dto.getId(), movie.getId());
        Assertions.assertEquals(dto.getTitle(), movie.getTitle());
        Assertions.assertEquals(dto.getDescription(), movie.getDescription());
        Assertions.assertEquals(dto.getReleaseYear(), movie.getReleaseYear());
        Assertions.assertEquals(dto.getRating(), movie.getRating());
        Assertions.assertEquals(dto.getCountry(), movie.getCountry());
    }

    @Test
    void convertEntityListToDtoList() {

        List<Movie> entityList = new ArrayList<>();

        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setTitle("Inception");
        movie1.setDescription("Dream heist movie");
        movie1.setReleaseYear(2010);
        movie1.setRating(8.8);
        movie1.setCountry("USA");

        Movie movie2 = new Movie();
        movie2.setId(2L);
        movie2.setTitle("Matrix");
        movie2.setDescription("Sci-fi action");
        movie2.setReleaseYear(1999);
        movie2.setRating(8.7);
        movie2.setCountry("USA");

        entityList.add(movie1);
        entityList.add(movie2);

        List<MovieDto> dtoList = movieMapper.toDtoList(entityList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertNotEquals(0, dtoList.size());
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i < entityList.size(); i++) {

            Movie entityMovie = entityList.get(i);
            MovieDto dtoMovie = movieMapper.toDto(entityMovie);

            Assertions.assertNotNull(dtoMovie);
            Assertions.assertNotNull(dtoMovie.getId());
            Assertions.assertNotNull(dtoMovie.getTitle());
            Assertions.assertNotNull(dtoMovie.getDescription());
            Assertions.assertNotNull(dtoMovie.getReleaseYear());
            Assertions.assertNotNull(dtoMovie.getRating());
            Assertions.assertNotNull(dtoMovie.getCountry());

            Assertions.assertEquals(entityMovie.getId(), dtoMovie.getId());
            Assertions.assertEquals(entityMovie.getTitle(), dtoMovie.getTitle());
            Assertions.assertEquals(entityMovie.getDescription(), dtoMovie.getDescription());
            Assertions.assertEquals(entityMovie.getReleaseYear(), dtoMovie.getReleaseYear());
            Assertions.assertEquals(entityMovie.getRating(), dtoMovie.getRating());
            Assertions.assertEquals(entityMovie.getCountry(), dtoMovie.getCountry());
        }
    }
}
