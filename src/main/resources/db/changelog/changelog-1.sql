--liquibase formatted sql
--changeset vlad28x:000000-create-users-table
create table users
(
    id         bigserial    not null primary key,
    username   varchar(255) not null unique,
    password   varchar(255) not null,
    email      varchar(255) unique,
    first_name varchar(255),
    last_name  varchar(255)

);

--changeset vlad28x:000001-create-employee-table
create table employee
(
    user_id   int8 not null primary key references users (id),
    hire_date date,
    position  varchar(255)
);

--changeset vlad28x:000002-create-customer-table
create table customer
(
    user_id int8 not null primary key references users (id),
    account int8 not null
);

--changeset vlad28x:000003-create-project-table
create table project
(
    id          bigserial not null primary key,
    name        varchar(255),
    payment     int8      not null,
    start_date  date,
    customer_id int8 references customer (user_id)
);

--changeset vlad28x:000004-create-employee_project-table
create table employee_project
(
    employee_id int8 not null references employee (user_id),
    project_id  int8 not null references project (id)
);

--changeset vlad28x:000005-insert-some-data-users
insert into users(username, password, email, first_name, last_name)
values ('username1', 'password1', 'user1@mail.ru', 'firstname1', 'lastname1'),
       ('username2', 'password2', 'user2@mail.ru', 'firstname2', 'lastname2'),
       ('username3', 'password3', 'user3@mail.ru', 'firstname3', 'lastname3'),
       ('username4', 'password4', 'user4@mail.ru', 'firstname4', 'lastname4'),
       ('username5', 'password5', 'user5@mail.ru', 'firstname5', 'lastname5'),
       ('username6', 'password6', 'user6@mail.ru', 'firstname6', 'lastname6'),
       ('username7', 'password7', 'user7@mail.ru', 'firstname7', 'lastname7'),
       ('username8', 'password8', 'user8@mail.ru', 'firstname8', 'lastname8');

--changeset vlad28x:000006-insert-some-data-employee
insert into employee(user_id, hire_date, position)
values (1, '2020-01-22', 'DEVELOPER'),
       (2, '2020-01-23', 'DESIGNER'),
       (3, '2020-01-24', 'QA_ENGINEER'),
       (4, '2020-01-24', 'DEVOPS'),
       (5, '2020-01-25', 'DEVELOPER'),
       (6, '2020-01-26', 'DESIGNER');

--changeset vlad28x:000007-insert-some-data-customer
insert into customer(user_id, account)
values (7, 1000000),
       (8, 150000);

--changeset vlad28x:000008-insert-some-data-project
insert into project(name, payment, start_date, customer_id)
values ('Cinema project', 300000, '2020-02-22', 7),
       ('School project', 400000, '2020-02-25', 7);

--changeset vlad28x:000009-insert-some-data-employee_project
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