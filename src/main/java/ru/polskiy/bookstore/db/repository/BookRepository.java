package ru.polskiy.bookstore.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.polskiy.bookstore.db.entity.Book;

public interface BookRepository extends JpaRepository<Book,Long> {
}
