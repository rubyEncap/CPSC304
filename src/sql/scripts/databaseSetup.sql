CREATE TABLE app (
    app_name varchar2(20),
    app_manager varchar2(20) not null,
    primary key (app_name)
);

CREATE TABLE account (
    account_id int,
    account_password varchar2(20) not null,
    account_app_name varchar2(20) not null,
    primary key (account_id),
    foreign key (account_app_name) references app(app_name) on delete cascade
);

CREATE TABLE customer (
    customer_id int,
    customer_name varchar2(20) not null,
    customer_phone_number varchar2(11) not null,
    customer_gender varchar2(10) not null,
    customer_address varchar2(20) not null,
    customer_email varchar2(20) not null,
    membership_fee int,
    primary key (customer_id),
    foreign key (customer_id) references account(account_id) on delete cascade
);

CREATE TABLE cso (
    cso_id int,
    cso_name varchar2(20) not null,
    cso_app_name varchar2(20) not null,
    cso_customer_id int,
    cso_salary int,
    primary key (cso_id, cso_app_name),
    foreign key (cso_app_name) references app(app_name) on delete cascade,
    foreign key (cso_customer_id) references customer(customer_id) on delete set null
);

CREATE TABLE deliveryman (
    deliveryman_id int,
    deliveryman_phone_number varchar2(11) not null,
    deliveryman_app_name varchar2(20) not null,
    deliveryman_customer_id int,
    primary key (deliveryman_id, deliveryman_app_name),
    foreign key (deliveryman_app_name) references app(app_name) on delete cascade,
    foreign key (deliveryman_customer_id) references customer(customer_id) on delete set null
);

CREATE TABLE store (
    store_name varchar2(20),
    store_address varchar2(20) not null,
    store_good_type varchar2(20) not null,
    store_app_name varchar2(20),
    primary key (store_name),
    foreign key (store_app_name) references app(app_name) on delete set null
);

CREATE TABLE supplier (
    supplier_name varchar2(20),
    supplier_product varchar2(20) not null,
    supplier_store_name varchar2(20),
    supplier_price int,
    primary key (supplier_name),
    foreign key (supplier_store_name) references store(store_name) on delete set null
);

CREATE TABLE techStaff (
    techStaff_id int,
    techStaff_name varchar2(20) not null,
    techStaff_app_name varchar2(20) not null,
    techStaff_salary int,
    primary key (techstaff_id, techstaff_app_name),
    foreign key (techstaff_app_name) references app(app_name) on delete cascade
);

INSERT INTO app VALUES('Ubereats', 'Uber');
INSERT INTO app VALUES('Foodora', 'Delivery Hero');
INSERT INTO app VALUES('Fantuan', 'Irish Wong');

INSERT INTO account VALUES(11257, '233333', 'Ubereats');
INSERT INTO account VALUES(21367, '765432', 'Foodora');
INSERT INTO account VALUES(11256, '233333', 'Fantuan');
INSERT INTO account VALUES(96342, '6llls32', 'Ubereats');

INSERT INTO customer VALUES(11256, 'John', '7781234567', 'Male', '2205 Lower Mall', 'john222@gmail.com', 0);
INSERT INTO customer VALUES(21367, 'Thomas', '6041234567', 'Male', '41st Avenue', 'thomas@gmail.com', 20);
INSERT INTO customer VALUES(11257, 'Edison', '7782354567', 'Male', 'Richmond', 'edcccc7@gmail.com', null);
INSERT INTO customer VALUES(96342, 'Lily', '6583249876', 'Female', 'Vancouver', 'Lil@gmail.com', 40);

INSERT INTO cso VALUES(12345, 'Uber CS office', 'Ubereats', 11257, 2500);
INSERT INTO cso VALUES(12346, 'Fantuan CS office', 'Fantuan', 11256, 3600);
INSERT INTO cso VALUES(33215, 'Foodora CS office', 'Foodora', 21367, 9000);

INSERT INTO deliveryman VALUES(11666, '6045181111', 'Ubereats', 11256);
INSERT INTO deliveryman VALUES(12272, '6043254856', 'Foodora', null);
INSERT INTO deliveryman VALUES(12666, '6045182222', 'Foodora', 21367);
INSERT INTO deliveryman VALUES(13666, '6045183333', 'Fantuan', 11257);

INSERT INTO store VALUES('A&W', 'UBC village', 'Fast food', 'Ubereats');
INSERT INTO store VALUES('Church’s Chicken', '41st Avenue', 'Fast food', 'Foodora');
INSERT INTO store VALUES('Sura', 'downtown', 'Korean food', 'Fantuan');

INSERT INTO supplier VALUES('Farm Produce', 'Potato', 'A&W', 26);
INSERT INTO supplier VALUES('Chicken Farm', 'Chicken', 'Church’s Chicken', 65);
INSERT INTO supplier VALUES('Sushi Produce', 'Sushi', 'Sura', 34);

INSERT INTO techStaff VALUES(12581, 'Jack', 'Ubereats', 4500);
INSERT INTO techStaff VALUES(13579, 'Jackson', 'Foodora', 4200);
INSERT INTO techStaff VALUES(21467, 'Louis', 'Fantuan', 7800);
