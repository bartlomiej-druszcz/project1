package org.example.library.view;

import org.example.library.api.UserLoginData;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class LoginViewTest {

    UserLoginData expectedResult = new UserLoginData("testUser", "testPassword");

    @Test
    void shouldProvideUserLoginDataBasedOnUserInput() throws FileNotFoundException {
        //given
        LoginView loginView = new LoginView(
                new Scanner(new File("src/test/resources/view.login/loginUserInput.txt"))
        );
        //when
        UserLoginData result = loginView.getData();
        //then
        assertThat(result).isEqualTo(expectedResult);
    }

}