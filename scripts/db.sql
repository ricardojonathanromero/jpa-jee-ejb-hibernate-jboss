-- auto-generated definition
create table persons
(
    id        serial
        constraint persons_pk
            primary key,
    name      varchar(50) not null,
    last_name varchar(50) not null,
    email     varchar(100),
    phone     varchar(13)
);

comment on table persons is 'persons_table';

alter table persons
    owner to postgres;

create unique index persons_email_uindex
    on persons (email);

create unique index persons_id_uindex
    on persons (id);

-- auto-generated definition
create table users
(
    id        serial
        constraint users_pk
            primary key,
    username  varchar(30) not null,
    password  varchar(50) not null,
    person_id integer
        constraint users_persons_id_fk
            references persons
);

comment on table users is 'users_Table';

alter table users
    owner to postgres;

create unique index users_id_uindex
    on users (id);


INSERT INTO public.persons (id, name, last_name, email, phone) VALUES (2, 'John', 'Wick', 'john.w@gmail.com', '5591111715');
INSERT INTO public.persons (id, name, last_name, email, phone) VALUES (3, 'Emanuel', 'Villalobos', 'ema.villa@gmail.com', '5545362718');
INSERT INTO public.persons (id, name, last_name, email, phone) VALUES (11, 'Josep', 'Allah', 'joseph@gmail.com', '6643929625');
INSERT INTO public.persons (id, name, last_name, email, phone) VALUES (12, 'Lewis', 'Hamilton', 'lewis.ham@gmail.com', '5563748293');
INSERT INTO public.persons (id, name, last_name, email, phone) VALUES (1, 'Ricardo', 'Example', 'rjromero@gmail.com', '5531492549');

INSERT INTO public.users (id, username, password, person_id) VALUES (1, 'rromero', 'temporal1.', 1);
INSERT INTO public.users (id, username, password, person_id) VALUES (2, 'cromero', 'pass4yeh', 1);
INSERT INTO public.users (id, username, password, person_id) VALUES (4, 'josep273', 'my_password', 11);
INSERT INTO public.users (id, username, password, person_id) VALUES (5, 'lewes.paps', 'myPassW0rd', 12);

