//package ru.polskiy.bookstore.mapper;
//
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import ru.polskiy.bookstore.db.entity.User;
//import ru.polskiy.bookstore.dto.UserCreateEditDto;
//
//@Mapper
//public interface UserCreateEditMapper {
//
//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "password", source = "rawPassword")
//    User toEntity(UserCreateEditDto userCreateEditDto);
//}
