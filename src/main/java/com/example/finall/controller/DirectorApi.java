package com.example.finall.controller;

import com.example.finall.dto.DirectorDto;
import com.example.finall.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/director")
public class DirectorApi {

    private final DirectorService directorService;

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ROLE_USER','ROLE_ADMIN')")
    public ResponseEntity<List<DirectorDto>> getAll() {
        return new ResponseEntity<>(directorService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<DirectorDto> addDirector(@RequestBody DirectorDto directorDto) {
        DirectorDto added = directorService.addDirector(directorDto);
        return new ResponseEntity<>(added, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<?> deleteDirector(@PathVariable Long id) {
        boolean deleted = directorService.deleteDirector(id);
        if (!deleted) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Director not found");
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
