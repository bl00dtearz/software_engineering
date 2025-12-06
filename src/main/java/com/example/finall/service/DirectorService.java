package com.example.finall.service;

import com.example.finall.dto.DirectorDto;
import java.util.List;

public interface DirectorService {

    List<DirectorDto> getAll();
    DirectorDto addDirector(DirectorDto directorDto);
    boolean deleteDirector(Long id);
}
