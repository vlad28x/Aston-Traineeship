drop schema hb cascade;
create schema hb;
create table users
(
    id         bigserial    not null primary key,
    username   varchar(255) not null unique,
    password   varchar(255) not null,
    email      varchar(255) unique,
    first_name varchar(255),
    last_name  varchar(255)

);
create table employee
(
    user_id   int8 not null primary key references users (id),
    hire_date date,
    position  varchar(255)
);
create table customer
(
    user_id int8 not null primary key references users (id),
    account int8 not null
);
create table project
(
    id          bigserial not null primary key,
    name        varchar(255),
    payment     int8      not null,
    start_date  date,
    customer_id int8 references customer (user_id)
);
create table employee_project
(
    employee_id int8 not null references employee (user_id),
    project_id  int8 not null references project (id)
);
insert into users(username, password)
values ('username1', 'password1'),
       ('username2', 'password2'),
       ('username3', 'password3'),
       ('username4', 'password4'),
       ('username5', 'password5'),
       ('username6', 'password6'),
       ('username7', 'password7'),
       ('username8', 'password8');
insert into employee(user_id, hire_date, position)
values (1, '2020-01-22', 'DEVELOPER'),
       (2, '2020-01-23', 'DESIGNER'),
       (3, '2020-01-24', 'QA_ENGINEER'),
       (4, '2020-01-24', 'DEVOPS'),
       (5, '2020-01-25', 'DEVELOPER'),
       (6, '2020-01-26', 'DESIGNER');
insert into customer(user_id, account)
values (7, 1000000),
       (8, 150000);
insert into project(name, payment, start_date, customer_id)
values ('Cinema project', 300000, '2020-02-22', 7),
       ('School project', 400000, '2020-02-25', 7);
insert into employee_project(project_id, employee_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (2, 5),
       (2, 6),
       (2, 1),
       (2, 3);