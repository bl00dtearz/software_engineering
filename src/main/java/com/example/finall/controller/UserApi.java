package com.example.finall.controller;

import com.example.finall.model.User;
import com.example.finall.service.MovieService;
import com.example.finall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class UserApi {

    private final UserService myUserService;
    private final MovieService movieService;

    @PostMapping("/register")
    public void register(@RequestBody User model) {
        myUserService.register(model);
    }

    @GetMapping("/movies")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(movieService.getAll());
    }
}
