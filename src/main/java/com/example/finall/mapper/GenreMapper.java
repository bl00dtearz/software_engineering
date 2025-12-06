package com.example.finall.mapper;

import com.example.finall.dto.GenreDto;
import com.example.finall.model.Genre;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface GenreMapper {

    GenreDto toDto(Genre genre);

    Genre toEntity(GenreDto genreDto);

    List<GenreDto> toDtoList(List<Genre> genres);
}
