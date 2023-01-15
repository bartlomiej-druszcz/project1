package org.example.library.controller;

import org.example.library.api.UserLoginData;
import org.example.library.dao.UserDao;
import org.example.library.model.User;
import org.example.library.service.UserLoginChecker;
import org.example.library.service.UserService;
import org.example.library.view.LoginView;
import org.example.library.view.MainMenuView;
import org.example.library.view.View;

import java.util.Optional;

public class LoginController {

    private UserLoginChecker userLoginChecker;

    public LoginController() {
        this.userLoginChecker = new UserService(new UserDao());
    }

    public LoginController(UserLoginChecker userLoginChecker) {
        this.userLoginChecker = userLoginChecker;
    }

    public View login(UserLoginData userLoginData) {
        Optional<User> user = userLoginChecker.checkAndGet(userLoginData);
        if (user.isPresent()) {
            return new MainMenuView();
        }
        return new LoginView(Optional.of("Podano niepoprawne dane logowania"));
    }
}