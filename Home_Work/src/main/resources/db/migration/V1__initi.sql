create table users
(
    id       bigserial,
    username varchar(30) not null,
    password varchar(80) not null,
    email    varchar(50) unique,
    primary key (id)
);

create table roles
(
    id   serial,
    name varchar(50) not null,
    primary key (id)
);

CREATE TABLE users_roles
(
    user_id bigint not null,
    role_id int    not null,
    primary key (user_id, role_id),
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (id)
);

create table scope
(
    id      bigserial not null,
    user_id bigint not null,
    scops   int,
    primary key (id),
    foreign key (user_id) references users (id)
);

insert into roles (name)
values ('ROLE_USER'),
       ('ROLE_ADMIN');

insert into users (username, password, email)
values ('user', '$2a$04$Fx/SX9.BAvtPlMyIIqqFx.hLY2Xp8nnhpzvEEVINvVpwIPbA3v/.i', 'user@gmail.com'),
       ('user2', '$2y$12$0x8G..uV2zKRwZLMg47ZduZvetXbH7A8qlcVNQf74VbCFY2eP68Aq', 'user2@gmail.com');

insert into users_roles (user_id, role_id)
values (1, 1),
       (1, 2),
       (2, 1);

insert into scope (user_id, scops)
values (1, 1),
       (2, 2);


