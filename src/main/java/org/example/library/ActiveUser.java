package org.example.library;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.library.api.UserRole;

import java.util.Set;

@AllArgsConstructor
@Getter
public class ActiveUser {

    private final String login;
    private final String name;
    private final Set<UserRole> userRoles;

}
