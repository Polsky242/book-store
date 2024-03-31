package ru.polskiy.bookstore.dto;

import lombok.Value;
import ru.polskiy.bookstore.db.types.Role;

@Value
public class UserReadDto {
    Long id;
    String login;

    String firstName;
    String lastName;
    Role role;
}

