-- add maven dependencies for working with database and Hibernate

create schema `sda-hibernate-67`;   -- replace ## with your group number

-- getting started
create table users(
    id int primary key auto_increment,
    name varchar(255),
    age int,
    created_at datetime
);
insert into users(name, age, created_at) values('John', 25, now());
insert into users(name, age, created_at) values('Andrei', 19, now());
insert into users(name, age, created_at) values('Marian', 30, now());

select * from users;


-- one-to-many
create table posts(
    id int primary key auto_increment,
    content varchar(255)
);
insert into posts(content) values ('Java is best');
insert into posts(content) values ('Hello from Paris');

select * from posts;

create table post_comments(
    id int primary key auto_increment,
    `comment` varchar(255),
    post_id int,
    foreign key (post_id) references posts(id)
);
insert into post_comments(comment, post_id) values ('Yes, you are right', 1), ('noo, hibernate is best', 1);
insert into post_comments(comment, post_id) values ('Bonjour', 2), ('Ola', 2);

select * from post_comments;
select * from posts p left join post_comments pc on p.id = pc.post_id where p.id = 1;


-- many-to-many
create table trainers(
    id int primary key auto_increment,
    name varchar(255)
);
insert into trainers(name) values ('Andrei'), ('Marian'), ('Iustina');
select * from trainers;

create table classrooms(
    id int primary key auto_increment,
    name varchar(255),
    students_number int
);
insert into classrooms(name, students_number) values ('Java01', 12), ('Java02', 10), ('Java03', 20);
select * from classrooms;

create table classroom_trainer (
    id int primary key auto_increment,
    trainer_id int,
    classroom_id int,
    foreign key (trainer_id) references trainers(id),
    foreign key (classroom_id) references classrooms(id)
);

insert into classroom_trainer(trainer_id, classroom_id) values (1, 1), (1, 2), (3, 3);
select * from classroom_trainer;


-- one-to-one
create table capitals (
    id int primary key auto_increment,
    name varchar(255)
);
insert into capitals(name) values ('Bucuresti'), ('Berlin');
select * from capitals;


create table countries (
    id int primary key auto_increment,
    name varchar(255),
    capital_id int unique,
    foreign key (capital_id) references capitals(id)
);
insert into countries(name, capital_id) values ('Romania', 1), ('Germania', 2);
select * from countries;





