----------------------ADDRESES------------------------
insert into address (city, country, latitude, longitude, number, street) values ('Zrenjanin', 'Srbija', 73.09, 2.71, '3', 'Zrenjaninska');
insert into address (city, country, latitude, longitude, number, street) values ('Sombor', 'Srbija', 11.73, 63.94, '497', 'Somborska');
insert into address (city, country, latitude, longitude, number, street) values ('Vrsac', 'Srbija', 18.53, 40.48, '1051', 'Vrsacka');
insert into address (city, country, latitude, longitude, number, street) values ('Novi Sad', 'Srbija', 9.89, 45.04, '2680', 'Novosadska');
insert into address (city, country, latitude, longitude, number, street) values ('Bijeljina', 'Bosna Ba', 85.21, 28.72, '633', 'Bijeljinska');

----------------------ROLE------------------------
INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN_CENTER');

----------------------PERSONS------------------------
insert into person (blood_type, date_of_birth, email, enabled, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('A-', '1999-07-07 00:00:00', 'rade@gmail.com', true, 'Male', 'Ftn', 7808765978633, '2017-10-01 21:58:58.508-07', 'Radisa', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '4634368672', 'Radic', 'rade@gmail.com', 1);
insert into person (blood_type, date_of_birth, email, enabled, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('A+', '2001-05-05 00:00:00', 'ivan@gmail.com', true, 'Male', 'Ftn', 783242348633, '2017-10-01 21:58:58.508-07', 'Ivan', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '42134368672', 'Ivanic', 'ivan@gmail.com', 2);
insert into person (blood_type, date_of_birth, email, enabled, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('B-', '1999-09-07 00:00:00', 'milica@gmail.com', true, 'Female', 'Ftn', 214123412342, '2017-10-01 21:58:58.508-07', 'Milica', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '42674665672', 'Milic', 'milica@gmail.com', 3);
insert into person (blood_type, date_of_birth, email, enabled, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('A+', '1999-09-07 00:00:00', 'dejana@gmail.com', true, 'Female', 'Ftn', 314123412342, '2017-10-01 21:58:58.508-07', 'Dejana', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '47674665672', 'Bullar', 'dejana@gmail.com', 3);
insert into person (blood_type, date_of_birth, email, enabled, gender, information_about_company, jmbg, last_password_reset_date, name, occupation, password, phon_number, surname, username, address_id) values ('B+', '1998-08-07 00:00:00', 'ivana@gmail.com', true, 'Female', 'Ftn', 284123412342, '2017-10-01 21:58:58.508-07', 'Ivana', 'occupation', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', '58674665672', 'Ivanovic', 'ivana@gmail.com', 4);

----------------------USER_ROLE------------------------
INSERT INTO USER_ROLE (user_id, role_id) VALUES (1, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 1); -- admin-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (2, 2); -- user-u dodeljujemo rolu ADMIN
INSERT INTO USER_ROLE (user_id, role_id) VALUES (3, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (4, 3); -- user-u dodeljujemo rolu ADMIN_CENTER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (5, 1); -- user-u dodeljujemo rolu USER

----------------------REGISTERED_USERS------------------------
insert into registered_user(deleted, person_id, enabled) values (false, 1, false);
insert into registered_user(deleted, person_id, enabled) values (false, 2, false);
insert into registered_user(deleted, person_id, enabled) values (false, 3, false);
insert into registered_user(deleted, person_id, enabled) values (false, 4, false);
insert into registered_user(deleted, person_id, enabled) values (false, 5, false);

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

----------------------RADNO-VREME------------------------
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-11 07:00:00', '2023-06-11 22:00:00', 1);
insert into radno_vreme (vreme_otvaranja, vreme_zatvaranja, center_id) values ('2023-06-12 07:00:00', '2023-06-12 22:00:00', 1);

----------------------TERMINI------------------------
insert into termin (kraj_termina, pocetak_termina, trajanje, center_id) values ('2023-06-13 07:00:00', '2023-06-13 22:00:00', 11, 1);
insert into termin (kraj_termina, pocetak_termina, trajanje, center_id) values ('2023-06-15 07:00:00', '2023-06-15 22:00:00', 13, 1);
insert into termin (kraj_termina, pocetak_termina, trajanje, center_id) values ('2023-06-17 07:00:00', '2023-06-17 22:00:00', 10, 1);
insert into termin (kraj_termina, pocetak_termina, trajanje, center_id) values ('2023-06-20 07:00:00', '2023-06-20 22:00:00', 12, 2);

----------------------CENTER_ADMINISTRATOR------------------------
insert into administrator_center(deleted, center_id, person_id) values (false, 1, 1);
insert into administrator_center(deleted, center_id, person_id) values (false, 1, 2);
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
insert into question_form(id, date, deleted, registered_user_id) values (1, '2023-01-12', false, 1);
insert into question_form(id, date, deleted, registered_user_id) values (2, '2023-01-12', false, 2);


--------------------REGISTER_USER_APPOINTMENT------------
insert into registered_user_appointments(registered_user_id, appointments_id) values (1, 1);
insert into registered_user_appointments(registered_user_id, appointments_id) values (2, 2);
insert into registered_user_appointments(registered_user_id, appointments_id) values (2, 4);
insert into registered_user_appointments(registered_user_id, appointments_id) values (3, 3);
insert into registered_user_appointments(registered_user_id, appointments_id) values (5, 5);
