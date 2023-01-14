package org.example.library.service;

import org.example.library.api.UserLoginData;
import org.example.library.model.User;

import java.util.Optional;

public interface UserLoginChecker {

    Optional<User> checkAndGet(UserLoginData userLoginData);

}