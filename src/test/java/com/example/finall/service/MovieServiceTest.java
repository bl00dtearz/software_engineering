package com.example.finall.service;

import com.example.finall.dto.DirectorDto;
import com.example.finall.dto.MovieDto;
import com.example.finall.model.Director;
import com.example.finall.service.MovieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class MovieServiceTest {

    @Autowired
    private MovieService movieService;

    @Test
    void getAllTest() {
        List<MovieDto> movies = movieService.getAll();

        Assertions.assertNotNull(movies);
        Assertions.assertNotEquals(0, movies.size());

        for (MovieDto movie : movies) {
            Assertions.assertNotNull(movie.getId());
            Assertions.assertNotNull(movie.getTitle());
            Assertions.assertNotNull(movie.getDescription());
            Assertions.assertNotNull(movie.getReleaseYear());
            Assertions.assertNotNull(movie.getRating());
            Assertions.assertNotNull(movie.getCountry());
            Assertions.assertNotNull(movie.getDirector());
            Assertions.assertNotNull(movie.getGenres());
        }
    }

    @Test
    void getByIdTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(movieService.getAll().size());
        Long id = movieService.getAll().get(randomIndex).getId();

        MovieDto movie = movieService.getById(id);

        Assertions.assertNotNull(movie);
        Assertions.assertNotNull(movie.getId());
        Assertions.assertNotNull(movie.getTitle());
        Assertions.assertNotNull(movie.getDescription());
        Assertions.assertNotNull(movie.getReleaseYear());
        Assertions.assertNotNull(movie.getRating());
        Assertions.assertNotNull(movie.getCountry());
        Assertions.assertNotNull(movie.getDirector());
        Assertions.assertNotNull(movie.getGenres());

        Assertions.assertNull(movieService.getById(-1L));
    }

    @Test
    void addMovieTest() {
        DirectorDto director = new DirectorDto();
        director.setId(1L);
        director.setFirstName("Christopher");
        director.setLastName("Nolan");
        director.setBirthYear(1970);

        MovieDto movie = new MovieDto();
        movie.setTitle("Interstellar");
        movie.setDescription("Space exploration movie");
        movie.setReleaseYear(2014);
        movie.setRating(8.6);
        movie.setCountry("USA");
        movie.setDirector(director);

        MovieDto added = movieService.addMovie(movie);

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getId());

        Assertions.assertEquals(movie.getTitle(), added.getTitle());
        Assertions.assertEquals(movie.getDescription(), added.getDescription());
        Assertions.assertEquals(movie.getReleaseYear(), added.getReleaseYear());
        Assertions.assertEquals(movie.getRating(), added.getRating());
        Assertions.assertEquals(movie.getCountry(), added.getCountry());

        MovieDto movieDto = movieService.getById(added.getId());

        Assertions.assertNotNull(movieDto);
        Assertions.assertNotNull(movieDto.getId());
        Assertions.assertEquals(added.getId(), movieDto.getId());
        Assertions.assertEquals(added.getTitle(), movieDto.getTitle());
        Assertions.assertEquals(added.getDescription(), movieDto.getDescription());
        Assertions.assertEquals(added.getReleaseYear(), movieDto.getReleaseYear());
        Assertions.assertEquals(added.getRating(), movieDto.getRating());
        Assertions.assertEquals(added.getCountry(), movieDto.getCountry());
    }

    @Test
    void updateMovieTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(movieService.getAll().size());
        Long id = movieService.getAll().get(randomIndex).getId();

        DirectorDto director = new DirectorDto();
        director.setId(1L);
        director.setFirstName("Christopher");
        director.setLastName("Nolan");
        director.setBirthYear(1970);

        MovieDto movie = new MovieDto();
        movie.setId(id);
        movie.setTitle("Updated Movie");
        movie.setDescription("Updated Description");
        movie.setReleaseYear(2025);
        movie.setRating(9.0);
        movie.setCountry("USA");
        movie.setDirector(director);

        MovieDto updated = movieService.updateMovie(id, movie);

        Assertions.assertNotNull(updated);
        Assertions.assertNotNull(updated.getId());
        Assertions.assertNotNull(updated.getTitle());
        Assertions.assertNotNull(updated.getDescription());
        Assertions.assertNotNull(updated.getReleaseYear());
        Assertions.assertNotNull(updated.getRating());
        Assertions.assertNotNull(updated.getCountry());

        MovieDto changedMovie = movieService.getById(movie.getId());

        Assertions.assertNotNull(changedMovie);
        Assertions.assertNotNull(changedMovie.getId());
        Assertions.assertNotNull(changedMovie.getTitle());
        Assertions.assertNotNull(changedMovie.getDescription());
        Assertions.assertNotNull(changedMovie.getReleaseYear());
        Assertions.assertNotNull(changedMovie.getRating());
        Assertions.assertNotNull(changedMovie.getCountry());


        Assertions.assertEquals(updated.getId(), changedMovie.getId());
        Assertions.assertEquals(updated.getTitle(), changedMovie.getTitle());
        Assertions.assertEquals(updated.getDescription(), changedMovie.getDescription());
        Assertions.assertEquals(updated.getReleaseYear(), changedMovie.getReleaseYear());
        Assertions.assertEquals(updated.getRating(), changedMovie.getRating());
        Assertions.assertEquals(updated.getCountry(), changedMovie.getCountry());

    }

    @Test
    void deleteMovieTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(movieService.getAll().size());
        Long id = movieService.getAll().get(randomIndex).getId();

        Assertions.assertTrue(movieService.deleteMovie(id));
        Assertions.assertNull(movieService.getById(id));
    }
}
