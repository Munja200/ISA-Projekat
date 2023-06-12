----------------------ADDRESES------------------------
insert into address (city, country, latitude, longitude, number, street) values ('Zrenjanin', 'Srbija', 73.09, 2.71, '3a', 'Zrenjaninska');
insert into address (city, country, latitude, longitude, number, street) values ('Sombor', 'Srbija', 11.73, 63.94, '4b', 'Somborska');
insert into address (city, country, latitude, longitude, number, street) values ('Vrsac', 'Srbija', 18.53, 40.48, '15a', 'Vrsacka');
insert into address (city, country, latitude, longitude, number, street) values ('Novi Sad', 'Srbija', 9.89, 45.04, '26a', 'Novosadska');
insert into address (city, country, latitude, longitude, number, street) values ('Bijeljina', 'Bosna i Hercegovina', 85.21, 28.72, '63b', 'Bijeljinska');

----------------------ROLE------------------------
INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN_CENTER');

----------------------PERSONS------------------------
insert into person (blood_type, date_of_birth, email, enabled, is_first_login,  gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('A-', '1999-07-07 00:00:00', 'micasplavaric24@gmail.com', true, false, 'Male', 'Ftn', 7808765978633, '2017-10-01 21:58:58.508-07', 'Radisa', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+(123)45/678-8012', 'Radic', 'micasplavaric24@gmail.com', 1);
insert into person (blood_type, date_of_birth, email, enabled, is_first_login, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('A+', '2001-05-05 00:00:00', 'ivan@gmail.com', true, false, 'Male', 'Ftn', 7832423486334, '2017-10-01 21:58:58.508-07', 'Ivan', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+(123)45/678-9024', 'Ivanic', 'ivan@gmail.com', 2);
insert into person (blood_type, date_of_birth, email, enabled, is_first_login, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('B-', '1999-09-07 00:00:00', 'milica@gmail.com', true, false, 'Female', 'Ftn', 2141234123425, '2017-10-01 21:58:58.508-07', 'Milica', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+(123)45/678-9019', 'Milic', 'milica@gmail.com', 3);
insert into person (blood_type, date_of_birth, email, enabled, is_first_login, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('A+', '1999-09-07 00:00:00', 'dejana@gmail.com', true, true, 'Female', 'Ftn', 1234567891234, '2017-10-01 21:58:58.508-07', 'Dejana', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+(123)45/678-9012', 'Dejanic', 'dejana@gmail.com', 3);
insert into person (blood_type, date_of_birth, email, enabled, is_first_login, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('B+', '1998-08-07 00:00:00', 'ivana@gmail.com', true, false, 'Female', 'Ftn', 5284123412342, '2017-10-01 21:58:58.508-07', 'Ivana', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '+(123)45/678-9712', 'Ivanovic', 'ivana@gmail.com', 4);

----------------------USER_ROLE------------------------
INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 1); -- admin-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2); -- user-u dodeljujemo rolu ADMIN
INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 3); -- user-u dodeljujemo rolu ADMIN_CENTER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 3); -- user-u dodeljujemo rolu ADMIN_CENTER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (4, 3); -- user-u dodeljujemo rolu ADMIN_CENTER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (5, 1); -- user-u dodeljujemo rolu USER

----------------------REGISTERED_USERS------------------------
insert into registered_user(deleted, person_id, enabled) values (false, 1, false);
insert into registered_user(deleted, person_id, enabled) values (false, 2, false);
insert into registered_user(deleted, person_id, enabled) values (false, 3, false);
insert into registered_user(deleted, person_id, enabled) values (false, 4, false);
insert into registered_user(deleted, person_id, enabled) values (false, 5, false);

----------------------QUESTION------------------------
insert into question (question, exact_value) values ('Da li imate vise od 50 kg', false);
insert into question (question, exact_value) values ('Da li imate simptome prehlade ili neke bolesti', false);
insert into question (question, exact_value) values ('Da li imate promene na kozi (osip, infekcije)', false);
insert into question (question, exact_value) values ('Da li imate suvise visok ili suvise nizak pritisak', false);
insert into question (question, exact_value) values ('Da li ste pod terapijom  vise ili nije proslo najmanje 7 dana od terapije antibiotika', false);
insert into question (question, exact_value) values ('Da li proslo vise od 6 meseci od probadanja tela i koze (pirsing), tetoviranja ili transfuzije krvi', false);
insert into question (question, exact_value) values ('Da li proslo manje od  7 dana od vadjenja zuba i manjih stomatoloskih intervencija', false);

----------------------CENTER------------------------
insert into center (average_rating, deleted, description, name, address_id) values (1.58, false, 'Vivamus tortor.', 'Wikibox', 4);
insert into center (average_rating, deleted, description, name, address_id) values (6.26, false, 'In eleifend quam a odio.', 'Thoughtstorm', 5);

----------------------RADNO-VREME------------------------
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-15 07:00:00', '2023-06-15 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-16 07:00:00', '2023-06-16 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-17 07:00:00', '2023-06-17 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-18 07:00:00', '2023-06-18 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-19 07:00:00', '2023-06-19 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-20 07:00:00', '2023-06-20 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-22 07:00:00', '2023-06-22 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-24 07:00:00', '2023-06-24 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-30 07:00:00', '2023-06-30 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-20 07:00:00', '2023-06-20 22:00:00', 2);

----------------------ZAKAZANI-TERMINI------------------------
insert into termin (korisnik_id, kraj_termina, pocetak_termina, trajanje, center_id) values (1, '2023-08-20 08:00:00', '2023-08-20 09:00:00', 11, 1);

----------------------SLOBODNI-TERMINI------------------------
insert into termin (korisnik_id, kraj_termina, pocetak_termina, trajanje, center_id) values (null, '2023-06-20 09:00:00', '2023-06-20 08:00:00', 11, 1);
insert into termin (korisnik_id, kraj_termina, pocetak_termina, trajanje, center_id) values (null, '2023-06-22 09:00:00', '2023-06-22 08:00:00', 13, 1);
insert into termin (korisnik_id, kraj_termina, pocetak_termina, trajanje, center_id) values (null, '2023-06-24 09:00:00', '2023-06-24 08:00:00', 10, 1);
insert into termin (korisnik_id, kraj_termina, pocetak_termina, trajanje, center_id) values (null, '2023-06-20 09:00:00', '2023-06-20 08:30:00', 12, 2);

----------------------CENTER_ADMINISTRATOR------------------------
insert into administrator_center(deleted, center_id, person_id) values (false, 1, 2);
insert into administrator_center(deleted, center_id, person_id) values (false, 1, 3);
insert into administrator_center(deleted, center_id, person_id) values (false, 1, 4);

----------------------COMPLAINT----------------------
insert into complaint(id, answer, complaint, person_id) values (1, null, 'Los objekat skroz na skroz', 1);
insert into complaint(id, answer, complaint, person_id) values (2, null, 'Zalicu se koliko god treba', 1);
insert into complaint(id, answer, complaint, person_id) values (3, null, 'Ne valja', 1);
insert into complaint(id, answer, complaint, person_id) values (4, null, '123', 1);
insert into complaint(id, answer, complaint, person_id) values (5, null, 'Da li radi', 1);
insert into complaint(id, answer, complaint, person_id) values (6, null, 'Ne ne radi', 5);
insert into complaint(id, answer, complaint, person_id) values (7, null, 'Nemam kola i bas me briga', 1);
insert into complaint(id, answer, complaint, person_id) values (8, null, 'UAAAA UAAAA UAAAA UAAAA UAAAA UAAAA UAAAA UAAAA UAAAA UAAAA UAAAA UAAAA', 1);
insert into complaint(id, answer, complaint, person_id) values (9, null, 'Ide gas', 3);
insert into complaint(id, answer, complaint, person_id) values (10, null, 'Colonija ofc', 1);
insert into complaint(id, answer, complaint, person_id) values (11, null, 'Pazi sad', 1);
insert into complaint(id, answer, complaint, person_id) values (12, null, 'JAHS DIPSAH DOIASHHIOHDIO NUAHDIHN IOUASDHI JAHS DIPSAH DOIASH ODHHIO NUSAHUI DHNIOU SHIDHNU IOASHIDH INASHIDH IONASHID HINOASHIDHI NUOASHNI UDHNIUDH SINOAHI ODHIO HIOHDIO NUAHDIHN IOUASDHI', 1);

----------------------APPOINTMENT------------------------
insert into appointment(id, enabled, end_time, start_time, text, version, center_id, registered_user_id) values (1, false, '2023-01-29 12:00:00', '2023-01-29 11:30:00', ' ', 1, 1, 1);
insert into appointment(id, enabled, end_time, start_time, text, version, center_id, registered_user_id) values (2, false, '2023-01-29 10:00:00', '2023-01-29 09:30:00',' ', 1, 1, null);
insert into appointment(id, enabled, end_time, start_time, text, version, center_id, registered_user_id) values (3, false, '2023-01-30 10:00:00', '2023-01-30 09:30:00',' ', 1, 1, 3);
insert into appointment(id, enabled, end_time, start_time, text, version, center_id, registered_user_id) values (4, false, '2023-01-30 12:00:00', '2023-01-30 11:30:00',' ', 1, 1, null);
insert into appointment(id, enabled, end_time, start_time, text, version, center_id, registered_user_id) values (5, false, '2023-01-30 12:30:00', '2023-01-30 11:30:00',' ', 1, 1, 5);

----------------------QUESTION_FORM----------------

--------------------REGISTER_USER_APPOINTMENT------------
insert into registered_user_appointments(registered_user_id, appointments_id) values (1, 1);
insert into registered_user_appointments(registered_user_id, appointments_id) values (2, 2);
insert into registered_user_appointments(registered_user_id, appointments_id) values (2, 4);
insert into registered_user_appointments(registered_user_id, appointments_id) values (3, 3);
insert into registered_user_appointments(registered_user_id, appointments_id) values (5, 5);


--------------------------BLOOD---------------------------

insert into blood(id, blood_type, quantity, center_id) values (1, 'A-', 50, 1);
insert into blood(id, blood_type, quantity, center_id) values (2, 'B-', 70, 1);
insert into blood(id, blood_type, quantity, center_id) values (3, 'A+', 20, 1);
insert into blood(id, blood_type, quantity, center_id) values (4, 'B+', 10, 1);
insert into blood(id, blood_type, quantity, center_id) values (5, 'AB+', 28, 1);
insert into blood(id, blood_type, quantity, center_id) values (6, 'AB-', 49, 1);
insert into blood(id, blood_type, quantity, center_id) values (7, '0-', 15, 1);
insert into blood(id, blood_type, quantity, center_id) values (8, '0+', 7, 1);

--------------------------GRADE---------------------------

insert into grade(id, center_id, score, person_id) values (1, 1, 5, 1);
insert into grade(id, center_id, score, person_id) values (2, 1, 8, 2);
insert into grade(id, center_id, score, person_id) values (3, 1, 4, 3);


