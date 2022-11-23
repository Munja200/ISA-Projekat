insert into address (city, country, latitude, longitude, number, street) values ('Novi Sad', 'Srbija', 45., 45., '1A', 'Patrijaha Pavla');
insert into address (city, country, latitude, longitude, number, street) values ('Novi Sad', 'Srbija', 30., 30., '10', 'Centra Prvog');
insert into address (city, country, latitude, longitude, number, street) values ('Novi Sad', 'Srbija', 31., 31., '11', 'Centra Drugog');
insert into person (blood_type, date_of_birth, email, gender, information_about_company, jmbg, name, occupation, password, phon_number, role, surname, address_id) values ('A', '2016-02-01', 'radisa.stojkic@gmail.com','male', 'Ftn', '1231234564598', 'Marko', 'student', 'password', '021123456', 0, 'Marković', 1);

insert into question (question, exact_value) values ('Da li imate vise od 50 kg', true);
insert into question (question, exact_value) values ('Da li imate simptome prehlade ili neke bolesti', false);
insert into question (question, exact_value) values ('Da li imate promene na kozi (osip, infekcije)', false);
insert into question (question, exact_value) values ('Da li imate suvise visok ili suvise nizak pritisak', false);
insert into question (question, exact_value) values ('Da li ste pod terapijom  vise ili nije proslo najmanje 7 dana od terapije antibiotika', false);
insert into question (question, exact_value) values ('Da li proslo vise od 6 meseci od probadanja tela i koze (pirsing), tetoviranja ili transfuzije krvi', true);
insert into question (question, exact_value) values ('Da li proslo manje od  7 dana od vadjenja zuba i manjih stomatoloskih intervencija', false);

insert into center (average_rating, deleted, description, name, address_id) values (5.5, false, 'Prvi objekat', 'Prvak', 2);
insert into center (average_rating, deleted, description, name, address_id) values (4.5, false, 'Drugi objekat', 'Drugak', 3);