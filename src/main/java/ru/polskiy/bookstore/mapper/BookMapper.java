package ru.polskiy.bookstore.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.polskiy.bookstore.db.entity.Book;
import ru.polskiy.bookstore.dto.BookDto;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(target = "id",ignore = true)
    @Mapping(target = "author",ignore = true)
    @Mapping(target = "users",ignore = true)
    Book toEntity(BookDto dto);
    BookDto toDto(Book book);
}
