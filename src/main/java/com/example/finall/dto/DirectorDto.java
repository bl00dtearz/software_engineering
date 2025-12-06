package com.example.finall.dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String birthYear;
}
