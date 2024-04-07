INSERT INTO users (id, first_name, last_name, login, role)
VALUES (1,'Ivan','Ivanov','ivan@mail.ru','USER'),
        (2,'Petr','Petrov','petr@mail.ru','ADMIN');
SELECT SETVAL('users_id_seq',(SELECT MAX(id) FROM users));

INSERT INTO author(id, name)
VALUES (1,'Mikhail Bulgakov'),
       (2,'Daniel Defoe');
SELECT SETVAL('author_id_seq',(SELECT MAX(id) FROM author));

INSERT INTO book (id, genre, name,author_id)
VALUES (1,'Fantasy','The Master and Margarita',1),
       (2,'Adventure','Robinson Crusoe',2);
SELECT SETVAL('book_id_seq',(SELECT MAX(id) FROM book));

INSERT INTO user_books (user_id, book_id)
VALUES (1,1),
       (1,2),
       (2,2);