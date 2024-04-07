package ru.polskiy.bookstore.mapper;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.polskiy.bookstore.db.entity.User;
import ru.polskiy.bookstore.db.types.Role;
import ru.polskiy.bookstore.dto.UserCreateEditDto;

import java.util.Optional;

import static java.util.function.Predicate.not;

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
    public User map(UserCreateEditDto fromObject, User toObject) {
        copy(fromObject,toObject);
        return toObject;
    }
    private void copy(UserCreateEditDto object, User user){
        user.setLogin(object.getLogin());
        user.setFirstName(object.getFirstName());
        user.setLastName(object.getLastName());
//        user.setPassword(passwordEncoder.encode(object.getRawPassword())); //TODO password should be change another way
        Optional.ofNullable(object.getRawPassword())
                .filter(StringUtils::hasText)
                .map(passwordEncoder::encode)
                .ifPresent(user::setPassword);
        user.setRole(object.getRole()); //TODO idk is it ok to set role from object
    }
}
