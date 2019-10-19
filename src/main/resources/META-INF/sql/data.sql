INSERT INTO authors (firstName, lastName, email, pesel) VALUES('Jan', 'Kowalski', 'janek@gmail.com', '90010110000');
INSERT INTO authors (firstName, lastName, email, pesel) VALUES('Jan', 'Jankowski', 'janko@gamil.com', '91010110000');
INSERT INTO publishers (name, nip, regon) VALUES('Nowa Era', '123', '1234');
INSERT INTO publishers (name, nip, regon) VALUES('PWN', '12','555');
INSERT INTO publishers (name, nip, regon) VALUES('Helion','44','44');
INSERT INTO publishers (name, nip, regon) VALUES('Kaktus','567', '999');

-- INSERT INTO personalDetails ('Warszawa', 'Jędrula', 'Jedrzejowski', 'ks janusza', '42' );

INSERT INTO categories (name) VALUES ('category111');
INSERT INTO categories (name) VALUES ('category222');

INSERT INTO books (description, proposition, rating, title, category_id) VALUES ('descripiton1', false, 3, 'title1', 1);

INSERT INTO books (description, proposition, rating, title, category_id) VALUES ('descripiton2', false, 5, 'title123', 1);