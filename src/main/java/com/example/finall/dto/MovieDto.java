package com.example.finall.dto;


import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {

    private Long id;
    private String title;
    private int releaseYear;

    private DirectorDto director;

    private List<GenreDto> genres = new ArrayList<>();
}
