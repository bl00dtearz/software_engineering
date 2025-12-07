package com.example.finall.service;

import com.example.finall.dto.DirectorDto;
import com.example.finall.service.DirectorService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
public class DirectorServiceTest {

    @Autowired
    private DirectorService directorService;

    @Test
    void getAllTest() {
        List<DirectorDto> directors = directorService.getAll();

        Assertions.assertNotNull(directors);
        Assertions.assertNotEquals(0, directors.size());

        for (DirectorDto director : directors) {
            Assertions.assertNotNull(director.getId());
            Assertions.assertNotNull(director.getFirstName());
            Assertions.assertNotNull(director.getLastName());
            Assertions.assertNotNull(director.getBirthYear());
        }
    }

    @Test
    void addDirectorTest() {
        DirectorDto director = new DirectorDto();
        director.setFirstName("Quentin");
        director.setLastName("Tarantino");
        director.setBirthYear(1963);

        DirectorDto added = directorService.addDirector(director);

        Assertions.assertNotNull(added);
        Assertions.assertNotNull(added.getLastName());
        Assertions.assertNotNull(added.getFirstName());
        Assertions.assertNotNull(added.getBirthYear());

        Assertions.assertEquals(director.getFirstName(), added.getFirstName());
        Assertions.assertEquals(director.getLastName(), added.getLastName());
        Assertions.assertEquals(director.getBirthYear(), added.getBirthYear());
    }

    @Test
    void deleteDirectorTest() {
        Random random = new Random();
        int randomIndex = random.nextInt(directorService.getAll().size());
        Long id = directorService.getAll().get(randomIndex).getId();

        Assertions.assertTrue(directorService.deleteDirector(id));

        DirectorDto directorDto = directorService.getAll().stream()
                .filter(d -> d.getId().equals(id))
                .findFirst()
                .orElse(null);

        Assertions.assertNull(directorDto);
    }
}

