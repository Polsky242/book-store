--changeset polskiy:1
CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY ,
    first_name VARCHAR(255),
    last_name VARCHAR(255),
    login VARCHAR(255) NOT NULL UNIQUE,
    password varchar(255),
    role VARCHAR(255)
);
--changeset polskiy:2
CREATE TABLE IF NOT EXISTS book
(
    id BIGSERIAL PRIMARY KEY ,
    author_name VARCHAR(255),
    genre VARCHAR(255),
    name VARCHAR(255) NOT NULL UNIQUE,
    user_id INT REFERENCES users (id)
);
