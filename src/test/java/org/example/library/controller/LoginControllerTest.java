package org.example.library.controller;

import org.example.library.api.UserLoginData;
import org.example.library.api.UserRole;
import org.example.library.model.Role;
import org.example.library.model.User;
import org.example.library.service.UserService;
import org.example.library.view.LoginView;
import org.example.library.view.MainMenuView;
import org.example.library.view.View;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.example.library.ApplicationContext.getActiveUser;

class LoginControllerTest {

    LoginController loginController = new LoginController(
            new UserService(
                    login -> Optional.of(new User(
                            1,
                            "login",
                            "password",
                            "name",
                            "email",
                            List.of(
                                    new Role(1, "USER"),
                                    new Role(2, "ADMIN")
                            ),
                            null)
                    )
            )
    );

    @Test
    void shouldReturnMainMenuViewWhenUserIsPresent() {
        View result = loginController.login(new UserLoginData("login", "password"));
        assertThat(result).isInstanceOf(MainMenuView.class);
    }

    @Test
    void shouldReturnLoginViewWhenUserLoginDataIsIncorrect() {
        View result = loginController.login(new UserLoginData("login", "incorrectPassword"));
        assertThat(result).isInstanceOf(LoginView.class);
    }

    @Test
    void shouldSetProperActiveUserInApplicationContextForCorrectlyLoggedUser() {
        //when
        loginController.login(new UserLoginData("login", "password"));
        //then
        assertThat(getActiveUser().getLogin()).isEqualTo("login");
        assertThat(getActiveUser().getName()).isEqualTo("name");
        assertThat(getActiveUser().getUserRoles()).containsAll(Set.of(
                        UserRole.USER,
                        UserRole.ADMIN
                )
        );
    }
}
