package ru.polskiy.bookstore.dto;

import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import ru.polskiy.bookstore.db.types.Role;

@Value
@FieldNameConstants
public class UserCreateEditDto {
    String login;
    String rawPassword;
    String firstName;
    String lastName;
    Role role; //TODO maybe remove this field?
}
