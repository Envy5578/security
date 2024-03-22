create table users (
    id bigint generated always as identity primary key,
    firstname varchar(40) not null,
    lastname varchar (40) not null,
    password varchar(100) not null,
    email varchar(100) not null,
    active boolean not null default true
);


create table roles (
    id bigint generated always as identity  primary key,
    role_name varchar(30) not null
);

create table tokens (
    id bigint generated always as identity  primary key,
    reset_token varchar(255) not null,
    refresh_token varchar(255) not null
);

create table user_token(
    id bigint generated always as identity  primary key,
    user_id int REFERENCES users(id),
    token_id int REFERENCES tokens(id)
);

create table user_roles (
    id bigint generated always as identity primary key,
    user_id int REFERENCES users(id),
    role_id int REFERENCES roles(id)
);

