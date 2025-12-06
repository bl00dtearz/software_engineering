package com.example.finall.mapper;

import com.example.finall.dto.MovieDto;
import com.example.finall.model.Movie;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface MovieMapper {

    MovieDto toDto(Movie movie);

    Movie toEntity(MovieDto movieDto);

    List<MovieDto> toDtoList(List<Movie> movies);
}
