

DROP DATABASE IF EXISTS killjoyadventure;
CREATE DATABASE killjoyadventure;
USE killjoyadventure;

create table activity
(
    activity_id   int not null primary key AUTO_INCREMENT,
    activity_name varchar(50) not null,
    constraint UK_5r4i41tgx3i6b91p5wvsmfqvp
        unique (activity_name)
);

create table customer
(
    customer_id    int not null primary key AUTO_INCREMENT,
    customer_email varchar(50),
    customer_name  varchar(20),
    constraint UK_qy5hqprdvx8o3dcidcfmf17x4
        unique (customer_email)
);

create table employee
(
    employee_id int not null primary key AUTO_INCREMENT,
    employee_email       varchar(50),
    employee_name        varchar(20),
    constraint UK_fopic1oh5oln2khj8eat6ino0
        unique (employee_email)
);

create table timeslot
(
    timeslot_id     int  not null primary key AUTO_INCREMENT,
    time_slot_start time not null,
    activity_id     int  not null,
    employee_id     int  not null,
    constraint FK195yegskfil5df2l5j9qv7rfp
        foreign key (activity_id) references activity (activity_id),
    constraint FKikco54w95u4a8ng4jpbg9f1vd
        foreign key (employee_id) references employee (employee_id)
);

create table reservation
(
    reservation_id int not null primary key AUTO_INCREMENT,
    activity_id    int not null,
    customer_id    int not null,
    timeslot_id    int not null,
    constraint FK41v6ueo0hiran65w8y1cta2c2
        foreign key (customer_id) references customer (customer_id),
    constraint FKbq8ayr5v3o8wbx483seomo9wq
        foreign key (timeslot_id) references timeslot (timeslot_id),
    constraint FKf56tgucgqr62fno50bpmhdc99
        foreign key (activity_id) references activity (activity_id)
);


