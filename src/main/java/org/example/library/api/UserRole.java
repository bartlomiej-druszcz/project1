package org.example.library.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {

    USER("user"),
    ADMIN("admin");

    private final String name;

    //Pamiętaj że wyszukiwanie odbywa się TYLKO WIELKIMI LITERAMI
    public static UserRole find(String name) {
        return valueOf(name);
    }

}
