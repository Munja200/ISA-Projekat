----------------------ADDRESES------------------------
insert into address (city, country, latitude, longitude, number, street) values ('Zrenjanin', 'Srbija', 73.09, 2.71, '3', 'Zrenjaninska');
insert into address (city, country, latitude, longitude, number, street) values ('Sombor', 'Srbija', 11.73, 63.94, '497', 'Somborska');
insert into address (city, country, latitude, longitude, number, street) values ('Vrsac', 'Srbija', 18.53, 40.48, '1051', 'Vrsacka');
insert into address (city, country, latitude, longitude, number, street) values ('Novi Sad', 'Srbija', 9.89, 45.04, '2680', 'Novosadska');
insert into address (city, country, latitude, longitude, number, street) values ('Bijeljina', 'Bosna Ba', 85.21, 28.72, '633', 'Bijeljinska');

----------------------ROLE------------------------
INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');

----------------------PERSONS------------------------
insert into person (blood_type, date_of_birth, email, enabled, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('A-', '1999-07-07 00:00:00', 'rade@gmail.com', true, 'Male', 'Ftn', 7808765978633, '2017-10-01 21:58:58.508-07', 'Radisa', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '4634368672', 'Bullar', 'rade@gmail.com', 1);
insert into person (blood_type, date_of_birth, email, enabled, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('A+', '2001-05-05 00:00:00', 'ivan@gmail.com', true, 'Male', 'Ftn', 783242348633, '2017-10-01 21:58:58.508-07', 'Ivan', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '42134368672', 'Bullar', 'ivan@gmail.com', 2);
insert into person (blood_type, date_of_birth, email, enabled, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('B-', '1999-09-07 00:00:00', 'milica@gmail.com', true, 'Female', 'Ftn', 214123412342, '2017-10-01 21:58:58.508-07', 'Milica', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '42674665672', 'Bullar', 'milica@gmail.com', 3);

----------------------USER_ROLE------------------------
INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 1); -- admin-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2); -- user-u dodeljujemo rolu ADMIN

----------------------REGISTERED_USERS------------------------
insert into registered_user(deleted, person_id, enabled) values (false, 1, false);
insert into registered_user(deleted, person_id, enabled) values (false, 2, false);

----------------------QUESTION------------------------
insert into question (question, exact_value) values ('Da li imate vise od 50 kg', true);
insert into question (question, exact_value) values ('Da li imate simptome prehlade ili neke bolesti', false);
insert into question (question, exact_value) values ('Da li imate promene na kozi (osip, infekcije)', false);
insert into question (question, exact_value) values ('Da li imate suvise visok ili suvise nizak pritisak', false);
insert into question (question, exact_value) values ('Da li ste pod terapijom  vise ili nije proslo najmanje 7 dana od terapije antibiotika', false);
insert into question (question, exact_value) values ('Da li proslo vise od 6 meseci od probadanja tela i koze (pirsing), tetoviranja ili transfuzije krvi', true);
insert into question (question, exact_value) values ('Da li proslo manje od  7 dana od vadjenja zuba i manjih stomatoloskih intervencija', false);

----------------------CENTER------------------------
insert into center (average_rating, deleted, description, name, address_id) values (1.58, false, 'Vivamus tortor.', 'Wikibox', 4);
insert into center (average_rating, deleted, description, name, address_id) values (6.26, false, 'In eleifend quam a odio.', 'Thoughtstorm', 5);

----------------------CENTER_ADMINISTRATOR------------------------
insert into administrator_center(deleted, center_id, person_id) values (false, 1, 1);
insert into administrator_center(deleted, center_id, person_id) values (false, 1, 2);
