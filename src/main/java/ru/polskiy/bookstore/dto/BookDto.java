package ru.polskiy.bookstore.dto;

import ru.polskiy.bookstore.db.types.Genre;

public record BookDto(String name, String authorName, Genre genre) {
}
