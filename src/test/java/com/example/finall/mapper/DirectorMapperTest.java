package com.example.finall.mapper;

import com.example.finall.dto.DirectorDto;
import com.example.finall.mapper.DirectorMapper;
import com.example.finall.model.Director;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class DirectorMapperTest {

    @Autowired
    private DirectorMapper directorMapper;

    @Test
    void convertEntityToDtoTest() {

        Director director = new Director();
        director.setId(1L);
        director.setFirstName("Christopher");
        director.setLastName("Nolan");
        director.setBirthYear(1970);

        DirectorDto dto = directorMapper.toDto(director);

        Assertions.assertNotNull(dto);
        Assertions.assertNotNull(dto.getId());
        Assertions.assertNotNull(dto.getFirstName());
        Assertions.assertNotNull(dto.getLastName());
        Assertions.assertNotNull(dto.getBirthYear());

        Assertions.assertEquals(director.getId(), dto.getId());
        Assertions.assertEquals(director.getFirstName(), dto.getFirstName());
        Assertions.assertEquals(director.getLastName(), dto.getLastName());
        Assertions.assertEquals(director.getBirthYear(), dto.getBirthYear());
    }

    @Test
    void convertDtoToEntityTest() {

        DirectorDto dto = new DirectorDto();
        dto.setId(1L);
        dto.setFirstName("Christopher");
        dto.setLastName("Nolan");
        dto.setBirthYear(1970);

        Director director = directorMapper.toEntity(dto);

        Assertions.assertNotNull(director);
        Assertions.assertNotNull(director.getId());
        Assertions.assertNotNull(director.getFirstName());
        Assertions.assertNotNull(director.getLastName());
        Assertions.assertNotNull(director.getBirthYear());

        Assertions.assertEquals(dto.getId(), director.getId());
        Assertions.assertEquals(dto.getFirstName(), director.getFirstName());
        Assertions.assertEquals(dto.getLastName(), director.getLastName());
        Assertions.assertEquals(dto.getBirthYear(), director.getBirthYear());
    }

    @Test
    void convertEntityListToDtoList() {

        List<Director> entityList = new ArrayList<>();

        Director d1 = new Director();
        d1.setId(1L);
        d1.setFirstName("Christopher");
        d1.setLastName("Nolan");
        d1.setBirthYear(1970);

        Director d2 = new Director();
        d2.setId(2L);
        d2.setFirstName("Lana");
        d2.setLastName("Wachowski");
        d2.setBirthYear(1965);

        entityList.add(d1);
        entityList.add(d2);

        List<DirectorDto> dtoList = directorMapper.toDtoList(entityList);

        Assertions.assertNotNull(dtoList);
        Assertions.assertNotEquals(0, dtoList.size());
        Assertions.assertEquals(entityList.size(), dtoList.size());

        for (int i = 0; i < entityList.size(); i++) {
            Director entityDirector = entityList.get(i);
            DirectorDto dtoDirector = directorMapper.toDto(entityDirector);

            Assertions.assertNotNull(dtoDirector);
            Assertions.assertNotNull(dtoDirector.getId());
            Assertions.assertNotNull(dtoDirector.getFirstName());
            Assertions.assertNotNull(dtoDirector.getLastName());
            Assertions.assertNotNull(dtoDirector.getBirthYear());

            Assertions.assertEquals(entityDirector.getId(), dtoDirector.getId());
            Assertions.assertEquals(entityDirector.getFirstName(), dtoDirector.getFirstName());
            Assertions.assertEquals(entityDirector.getLastName(), dtoDirector.getLastName());
            Assertions.assertEquals(entityDirector.getBirthYear(), dtoDirector.getBirthYear());
        }
    }
}
