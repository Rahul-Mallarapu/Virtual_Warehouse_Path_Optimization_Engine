package com.example.godown_project;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserService {
    User saveUser(User user);
    String verify(User user);
    UserDetails loadUserByUsername(String username);
}

