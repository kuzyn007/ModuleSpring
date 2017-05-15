/* EXAMPLE: ADD BOOKS */
INSERT INTO `test`.`book` (`title`, `author`, `isbn`) VALUES ('Krzyżacy', 'Henryk Sienkiewicz', '123456789');
INSERT INTO `test`.`book` (`title`, `author`, `isbn`) VALUES ('Dziady', 'Adam Mickiewicz', '123434567');
INSERT INTO `test`.`book` (`title`, `author`, `isbn`) VALUES ('Dym', 'Maria Konopnicka', '987654321');

/* EXAMPLE: ADD ROLES */
insert into user_role(role, description) VALUES ("ROLE_USER", "default role for user");







/*
INSERT INTO users(username,password,enabled)
VALUES ('jan','jan123', true);

INSERT INTO users(username,password,enabled)
VALUES ('ania','Asdf1234', true);

INSERT INTO authorities (username, authority)
VALUES ('jan', 'ROLE_USER');

INSERT INTO authorities (username, authority)
VALUES ('jan', 'ROLE_ADMIN');

INSERT INTO authorities (username, authority)
VALUES ('ania', 'ROLE_USER');*/