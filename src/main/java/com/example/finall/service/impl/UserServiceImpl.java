package com.example.finall.service.impl;

import com.example.finall.model.Permission;
import com.example.finall.model.User;
import com.example.finall.repository.PermissionRepository;
import com.example.finall.repository.UserRepository;
import com.example.finall.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final PermissionRepository permissionRep;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user != null) {
            return user;
        }
        throw new UsernameNotFoundException("User not found with email: " + username);
    }

    @Override
    public void register(User model) {
        User existing = userRepository.findByEmail(model.getEmail());
        if (existing == null) {
            model.setPassword(passwordEncoder.encode(model.getPassword()));

            Permission userRole = permissionRep.findByName("ROLE_USER");
            if (userRole == null) {
                throw new IllegalStateException("ROLE_USER permission not found in DB!");
            }

            model.setPermissions(List.of(userRole));
            userRepository.save(model);
        }
    }
}

