package org.example.library.view;

import org.example.library.api.UserLoginData;
import org.example.library.controller.LoginController;

import java.util.Optional;
import java.util.Scanner;

public class LoginView implements View {

    private final Scanner scanner;
    private final LoginController loginController;
    private Optional<String> message;

    public LoginView(Scanner scanner) {
        this.scanner = scanner;
        this.loginController = new LoginController();
    }

    public LoginView(Optional<String> message) {
        this.scanner = new Scanner(System.in);
        this.loginController = new LoginController();
        this.message = message;
    }

    public void display() {
        loginController.login(getData()).display();
    }

    public UserLoginData getData() {
        message.ifPresent(System.out::println);
        System.out.println("podaj login");
        String login = scanner.nextLine();
        System.out.println("podaj haslo");
        String password = scanner.nextLine();
        return new UserLoginData(login, password);
    }

}