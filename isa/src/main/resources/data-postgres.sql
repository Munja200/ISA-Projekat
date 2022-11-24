insert into address (city, country, latitude, longitude, number, street) values ('Novi Sad', 'Srbija', 45., 45., '1A', 'Patrijaha Pavla');
insert into address (city, country, latitude, longitude, number, street) values ('Zrenjanin', 'Srbija', 55., 45., '11', 'Futoski put');
insert into address (city, country, latitude, longitude, number, street) values ('Vrbas', 'Srbija', 45., 65., '44', 'Rumenacka');

insert into person (blood_type, date_of_birth, email, gender, information_about_company, jmbg, name, occupation, password, phon_number, role, surname, address_id) values ('A', '2016-02-01', 'radisa@gmail.com','male', 'Ftn', '1231234564598', 'Marko', 'student', 'password', '021123456', 0, 'Marković', 1);
insert into person (blood_type, date_of_birth, email, gender, information_about_company, jmbg, name, occupation, password, phon_number, role, surname, address_id) values ('B', '2000-03-01', 'milica@gmail.com','female', 'Ftn', '2410000805048', 'Milica', 'profesor', 'ftn1', '021123845', 0, 'Savic', 2);
insert into person (blood_type, date_of_birth, email, gender, information_about_company, jmbg, name, occupation, password, phon_number, role, surname, address_id) values ('AB', '2001-07-01', 'jovana@gmail.com','male', 'Ftn', '2410000805018', 'Jovana', 'doktor', 'ftn', '021123756', 0, 'Jovanovic', 3);

insert into registered_user (deleted, person_id) values (false, 2);
insert into registered_user (deleted, person_id) values (false, 3);

insert into question (question, exact_value) values ('Da li imate vise od 50 kg', true);
insert into question (question, exact_value) values ('Da li imate simptome prehlade ili neke bolesti', false);
insert into question (question, exact_value) values ('Da li imate promene na kozi (osip, infekcije)', false);
insert into question (question, exact_value) values ('Da li imate suvise visok ili suvise nizak pritisak', false);
insert into question (question, exact_value) values ('Da li ste pod terapijom  vise ili nije proslo najmanje 7 dana od terapije antibiotika', false);
insert into question (question, exact_value) values ('Da li proslo vise od 6 meseci od probadanja tela i koze (pirsing), tetoviranja ili transfuzije krvi', true);
insert into question (question, exact_value) values ('Da li proslo manje od  7 dana od vadjenja zuba i manjih stomatoloskih intervencija', false);
