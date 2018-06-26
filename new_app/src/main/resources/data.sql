
-- password is 'admin' (bcrypt encoded) 
insert into user (username, password) values ('admin', '$2a$12$S8g1q3Q6TlWTXRQOdlIGXeLaWRqSn2xJxcVCPwjKnUyGqUbonRa2i');
-- password is 'user' (bcrypt encoded)
insert into user (username, password) values ('user', '$2a$04$Amda.Gm4Q.ZbXz9wcohDHOhOBaNQAkSS1QO26Eh8Hovu3uzEpQvcq');

insert into user_roles (user_id, roles) values (1, 0); -- admin has ROLE_ADMIN
insert into user_roles (user_id, roles) values (2, 1); -- user has ROLE_USER

insert into student (idx, first_name, last_name) values ('SW-1-1', 'Pera', 'Peric');
insert into student (idx, first_name, last_name) values ('SW-2-1', 'Zika', 'Pavlovic');
insert into student (idx, first_name, last_name) values ('SW-3-1', 'Jelena', 'Jankovic');
insert into student (idx, first_name, last_name) values ('SW-4-1', 'Ivana', 'Ivanovic');

insert into departman (name) values ('departman');

insert into professor (first_name, last_name, departman_id) values ('Prof', '1', 1);
insert into professor (first_name, last_name, departman_id) values ('Prof', '2', 1);
insert into professor (first_name, last_name, departman_id) values ('Prof', '3', 1);

insert into subject (name, departman_id, professor_id) values ('Bezbednost u sistemima elektronskog poslovanja',1, 1);
insert into subject (name, departman_id, professor_id) values ('Sistemi bazirani na znanju', 1, 2);
insert into subject (name, departman_id, professor_id) values ('Masinsko ucenje', 1, 3);

insert into examination_period (subject_id, date) values (1, '2018-04-14 14:00:00');
insert into examination_period (subject_id, date) values (3, '2018-04-15 10:00:00');

insert into applying_exams (examination_period_id, student_id, flag) values (1, 1, true);
insert into applying_exams (examination_period_id, student_id, flag) values (1, 2, true);
insert into applying_exams (examination_period_id, student_id, flag) values (2, 1, true);
insert into applying_exams (examination_period_id, student_id, flag) values (2, 2, true);
insert into applying_exams (examination_period_id, student_id, flag) values (2, 3, true);


insert into exam (student_id, subject_id, rating) values (1,1, 10);
insert into exam (student_id, subject_id, rating) values (1,2, 9);
insert into exam (student_id, subject_id, rating) values (3,1, 10);
insert into exam (student_id, subject_id, rating) values (3,3, 6);
insert into exam (student_id, subject_id, rating) values (3,2, 5);




