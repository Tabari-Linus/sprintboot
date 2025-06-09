CREATE TABLE customers(
    customer_id UUID primary key,
    name varchar(64) not null,
    contact_name varchar(128) not null,
    email varchar(128) not null,
    phone varchar(24) not null
);

CREATE TABLE orders(
    order_id UUID primary key,
    customer_id UUID not null,
    order_info varchar (2048) not null,
    foreign key (customer_id) references customers(customer_id)
);

CREATE TABLE users(
    username varchar(50) not null primary key,
    password varchar(500) not null,
    enabled boolean not null
);

CREATE TABLE authorities (
    username varchar(50) not null,
    authority varchar(50) not null,
    CONSTRAINT fk_user FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX idx_auth_username on authorities(username, authority)