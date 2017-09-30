package com.example.domain.repository;

import com.example.domain.model.User;

import java.util.List;

public interface UserRepository {
    List<User> getAllUsers();
}
