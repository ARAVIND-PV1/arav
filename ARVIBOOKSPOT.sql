create database arvibookspot;
use arvibookspot;
create table book(
id int(11) not null,
name varchar(20) not null,
edition int(11) not null,
price int(11) not null,
primary key(id));


insert into book(id,name,edition,price)values(01,"Harry Potter",1,1300.00);
insert into book(id,name,edition,price)values(02,"MY BIOGRAPHY ",10,9999.00);
select id,name,edition,price from book;
