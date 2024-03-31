package ru.polskiy.bookstore.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.polskiy.bookstore.db.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByLogin(String login);
}
