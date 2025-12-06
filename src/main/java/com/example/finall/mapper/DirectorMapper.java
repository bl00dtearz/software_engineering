package com.example.finall.mapper;

import com.example.finall.dto.DirectorDto;
import com.example.finall.model.Director;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface DirectorMapper {

    DirectorDto toDto(Director director);

    Director toEntity(DirectorDto directorDto);

    List<DirectorDto> toDtoList(List<Director> directors);
}
