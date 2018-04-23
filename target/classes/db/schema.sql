drop table if EXISTS elib.categories;

create table elib.categories(
id INTEGER PRIMARY key auto_increment,
name VARCHAR(100) not null unique,
category_id integer null,
CONSTRAINT fk_category FOREIGN key(category_id) REFERENCES elib.categories(id)
);

create table elib.publishers(
id INTEGER PRIMARY key auto_increment,
name VARCHAR(150) not null unique,
date date not NULL
);

CREATE TABLE ELIB.Users(
ID Int not null primary key auto_increment,
FULLNAME VARCHAR (200) not null,
EMAIL VARCHAR(200) not null UNIQUE ,
PASSWORD VARCHAR(60) not null,
IMAGE VARCHAR (200) null,
PHONE varchar(30) null,
ROLE tinyint DEFAULT 0 not null ,
STATUS tinyint DEFAULT 0 not null
);

create table elib.books(
id INTEGER PRIMARY key auto_increment,
name VARCHAR(100) not null unique,
description text null,
image VARCHAR(100) null,
download VARCHAR(100) not NULL ,
language VARCHAR(100) not NULL ,
publisher_id integer null,
page int default 0 not null,
status VARCHAR (30) not NULL ,
date date not null,
CONSTRAINT fk_publisher FOREIGN key(publisher_id) REFERENCES elib.publishers(id)
);

create table elib.category_book(
Category_Id int not null,
Book_Id int not null,
CONSTRAINT fk_ck_category FOREIGN key(Category_Id) REFERENCES elib.categories(id),
CONSTRAINT fk_ck_book FOREIGN key(Book_Id) REFERENCES elib.books(id)
);


create table elib.counter(
Id int not null,
View int DEFAULT 0 not null,
Download int DEFAULT 0 not null,
CONSTRAINT fk_counter_book FOREIGN key(Id) REFERENCES elib.books(id)
);

create table elib.feedbacks(
id INTEGER PRIMARY key auto_increment,
name VARCHAR(150) not null,
email VARCHAR(150) not null,
message text not null,
date timestamp not null
);
