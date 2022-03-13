create schema if not exists netology;

create table if not exists netology.customers
(
    id int primary key auto_increment,
    name varchar(25),
    surname varchar(25),
    age int,
    phone_number varchar(15)
    );
create unique index CUSTOMERS_ID_INDEX on netology.customers (id);

create table if not exists netology.orders
(
    id int primary key auto_increment,
    date datetime,
    customer_id int,
    product_name varchar(15),
    amount int,
    foreign key (customer_id) references netology.customers(id)
    );
create unique index ORDERS_ID_INDEX on netology.orders (id);

INSERT INTO netology.customers (name, surname, age, phone_number)
VALUES
    ('Иван1','Иванв', 26,'+77777777777'),
    ('Alexey','Иванв', 26, '+77777777777'),
    ('Иван3','Ивнов', 27, '+77777777777'),
    ('ALEXEY','Ивов', 28, '+77777777777'),
    ('Иван5','Иван', 29, '+77777777777'),
    ('alexey','Dанов', 30, '+77777777777');


INSERT INTO netology.orders (date, customer_id, product_name, amount)
VALUES
    (NOW(), 1, 'product name 1', 2),
    (NOW(), 2, 'product name 2', 3),
    (NOW(), 3, 'product name 3', 4),
    (NOW(), 3, 'product name 4', 3),
    (NOW(), 4, 'product name 5', 6),
    (NOW(), 2, 'product name 6', 7);