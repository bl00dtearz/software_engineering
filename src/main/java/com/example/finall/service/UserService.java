package com.example.finall.service;

import com.example.finall.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    void register(User model);

}
