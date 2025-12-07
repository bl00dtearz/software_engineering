package com.example.finall.mapper;

import com.example.finall.dto.GenreDto;
import com.example.finall.mapper.GenreMapper;
import com.example.finall.model.Genre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class GenreMapperTest {

    @Autowired
    private GenreMapper genreMapper;

    @Test
    void convertEntityToDtoTest() {
        Genre genre = new Genre();
        genre.setId(1L);
        genre.setName("Action");

        GenreDto dto = genreMapper.toDto(genre);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getName());

        Assertions.assertEquals(genre.getId(), dto.getId());
        Assertions.assertEquals(genre.getName(), dto.getName());
    }

    @Test
    void convertDtoToEntityTest() {
        GenreDto dto = new GenreDto();
        dto.setId(1L);
        dto.setName("Action");

        Genre genre = genreMapper.toEntity(dto);

        Assertions.assertNotNull(genre);
        Assertions.assertNotNull(genre.getId());
        Assertions.assertNotNull(genre.getName());

        Assertions.assertEquals(dto.getId(), genre.getId());
        Assertions.assertEquals(dto.getName(), genre.getName());
    }

    @Test
    void convertEntityListToDtoList() {
        List<Genre> entityList = new ArrayList<>();

        Genre g1 = new Genre();
        g1.setId(1L);
        g1.setName("Action");

        Genre g2 = new Genre();
        g2.setId(2L);
        g2.setName("Drama");

        entityList.add(g1);
        entityList.add(g2);

        List<GenreDto> dtoList = genreMapper.toDtoList(entityList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertNotEquals(0, dtoList.size());
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i < entityList.size(); i++) {
            Genre entityGenre = entityList.get(i);
            GenreDto dtoGenre = genreMapper.toDto(entityGenre);

            Assertions.assertNotNull(dtoGenre);
            Assertions.assertNotNull(dtoGenre.getId());
            Assertions.assertNotNull(dtoGenre.getName());

            Assertions.assertEquals(entityGenre.getId(), dtoGenre.getId());
            Assertions.assertEquals(entityGenre.getName(), dtoGenre.getName());
        }
    }
}
