package org.example.library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data//z automatu tworzy konstruktor, gettery , settery
@AllArgsConstructor
public class User {
    private String name;

}
