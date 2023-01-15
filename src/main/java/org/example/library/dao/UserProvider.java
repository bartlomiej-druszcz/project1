package org.example.library.dao;

import org.example.library.model.User;

import java.util.Optional;

public interface UserProvider {
    Optional<User> findUserByLogin(String login);

}
