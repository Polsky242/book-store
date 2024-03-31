package ru.polskiy.bookstore.mapper;

import org.mapstruct.Mapper;
import ru.polskiy.bookstore.db.entity.User;
import ru.polskiy.bookstore.dto.UserReadDto;

@Mapper(componentModel = "spring")
public interface UserReadMapper {
    UserReadDto toDto(User user);
}
