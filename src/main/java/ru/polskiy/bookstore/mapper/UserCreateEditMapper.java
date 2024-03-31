package ru.polskiy.bookstore.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ru.polskiy.bookstore.db.entity.User;
import ru.polskiy.bookstore.db.types.Role;
import ru.polskiy.bookstore.dto.UserCreateEditDto;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper {
    private final PasswordEncoder passwordEncoder;
    public User toEntity(UserCreateEditDto userDto){
        return User
                .builder()
                .login(userDto.getLogin())
                .password(passwordEncoder.encode(userDto.getRawPassword()))
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .role(Role.USER)
                .build();
    }
}
