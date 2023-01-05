package com.Api.apiSpring.services;

import com.Api.apiSpring.models.User;

import java.util.Optional;

public interface UserService {
    User createUser(User user);

    Optional<User> getUser(Long userId);

    User updateUser(Long id, User toUpdateUser);

    boolean deleteUser(Long id);
}
