drop table if exists good;
drop table if exists option;
drop table if exists cart;

create table good(id varchar primary key, name varchar, provider varchar, price int, shipping_method varchar, shipping_price int, shipping_can_bundle varchar);
create table option(id varchar primary key, good_id varchar, color varchar, size varchar, stock int);
create table cart(id int primary key auto_increment, good_id varchar, option_id varchar, stock int);
