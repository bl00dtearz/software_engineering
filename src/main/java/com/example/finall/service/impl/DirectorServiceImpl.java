package com.example.finall.service.impl;

import com.example.finall.dto.DirectorDto;
import com.example.finall.mapper.DirectorMapper;
import com.example.finall.model.Director;
import com.example.finall.repository.DirectorRepository;
import com.example.finall.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DirectorServiceImpl implements DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorMapper directorMapper;

    @Override
    public List<DirectorDto> getAll() {
        List<Director> directors = directorRepository.findAll();
        return directorMapper.toDtoList(directors);
    }

    @Override
    public DirectorDto addDirector(DirectorDto directorDto) {
        Director director = directorMapper.toEntity(directorDto);
        directorRepository.save(director);
        return directorMapper.toDto(director);
    }

    @Override
    public boolean deleteDirector(Long id) {
        Director director = directorRepository.findById(id).orElse(null);
        if (director != null) {
            directorRepository.deleteById(id);
            return true;
        } else {
            System.out.println("Director with id " + id + " not found");
            return false;
        }
    }
}
