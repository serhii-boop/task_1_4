create schema if not exists my_shop;

use my_shop;

create table suppliers (
supplier_id int not null auto_increment primary key,
supplier_name varchar(45) not null,
city varchar(45) not null,
country varchar(45) not null
);

create table categories (
category_id int not null auto_increment primary key,
category_name varchar(45) not null,
description text
);

create table products (
product_id int not null auto_increment primary key,
product_name varchar(45) not null,
supplier_id int,
category_id int,
price float, 
foreign key (supplier_id) references suppliers (supplier_id),
foreign key (category_id) references categories (category_id)
);








