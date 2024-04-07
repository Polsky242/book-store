package ru.polskiy.bookstore.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.polskiy.bookstore.db.entity.User;
import ru.polskiy.bookstore.db.repository.UserRepository;
import ru.polskiy.bookstore.db.types.Role;
import ru.polskiy.bookstore.dto.UserCreateEditDto;
import ru.polskiy.bookstore.dto.UserReadDto;
import ru.polskiy.bookstore.integration.IntegrationTestBase;
import ru.polskiy.bookstore.service.UserService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

//@SpringBootTest
//@ActiveProfiles("test")
@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase{
    private final UserService userService;

    @Test
    void createAdmin(){
        UserCreateEditDto userDto=new UserCreateEditDto(
                "test@mail.ru",
                "test",
                "test",
                "test",
                Role.ADMIN
        );
        UserReadDto actualResult =userService.create(userDto);

        assertEquals(userDto.getLogin(),actualResult.getLogin());
        assertEquals(userDto.getFirstName(),actualResult.getFirstName());
        assertEquals(userDto.getLastName(),actualResult.getLastName());
        assertEquals(userDto.getRole(),actualResult.getRole());
    }
    @Test
    void createUser(){
        UserCreateEditDto userDto=new UserCreateEditDto(
                "test@mail.ru",
                "test",
                "test",
                "test",
                null
        );
        UserReadDto actualResult =userService.create(userDto);

        assertEquals(userDto.getLogin(),actualResult.getLogin());
        assertEquals(userDto.getFirstName(),actualResult.getFirstName());
        assertEquals(userDto.getLastName(),actualResult.getLastName());
        assertEquals(Role.USER,actualResult.getRole());
    }
}
