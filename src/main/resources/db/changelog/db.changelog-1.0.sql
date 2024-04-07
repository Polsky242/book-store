--changeset polskiy:1
CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY ,
    login VARCHAR(255) NOT NULL UNIQUE,
    password varchar(255) DEFAULT '{noop}123',
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    role VARCHAR(255)
);
--changeset polskiy:2

CREATE TABLE IF NOT EXISTS author
(
    id BIGSERIAL PRIMARY KEY ,
    name varchar(255)
);
--changeset polskiy:3
CREATE TABLE IF NOT EXISTS book
(
    id BIGSERIAL PRIMARY KEY ,
    author_id BIGINT,
    FOREIGN KEY (author_id)  REFERENCES author(id),
    genre VARCHAR(255),
    name VARCHAR(255) NOT NULL,
    user_id INT REFERENCES users (id)
);

--changeset polskiy:4
CREATE TABLE IF NOT EXISTS user_books
(
    user_id BIGINT,
    book_id BIGINT,
    PRIMARY KEY (user_id,book_id),
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (book_id) REFERENCES book(id)
);