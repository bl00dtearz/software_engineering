package com.example.finall.service;

import com.example.finall.dto.GenreDto;
import com.example.finall.service.GenreService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class GenreServiceTest {

    @Autowired
    private GenreService genreService;

    @Test
    void getAllTest() {
        List<GenreDto> genres = genreService.getAll();

        Assertions.assertNotNull(genres);
        Assertions.assertNotEquals(0, genres.size());

        for (GenreDto genre : genres) {
            Assertions.assertNotNull(genre.getId());
            Assertions.assertNotNull(genre.getName());
        }
    }

    @Test
    void addGenreTest() {
        GenreDto genre = new GenreDto();
        genre.setName("Action");

        GenreDto added = genreService.addGenre(genre);

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getName());

        Assertions.assertEquals(genre.getId(), added.getId());
        Assertions.assertEquals(genre.getName(), added.getName());
    }

    @Test
    void deleteGenreTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(genreService.getAll().size());
        Long id = genreService.getAll().get(randomIndex).getId();

        Assertions.assertTrue(genreService.deleteGenre(id));

        GenreDto genreDto = genreService.getAll().stream()
                .filter(g -> g.getId().equals(id))
                .findFirst()
                .orElse(null);

        Assertions.assertNull(genreDto);
    }
}
