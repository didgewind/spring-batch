create database if not exists acme_catalog;
use acme_catalog;
SET storage_engine=INNODB;

grant all on acme_catalog.* to maza@localhost identified by 'maza';

delete from products;

create table products
(
  id character(9) not null,
  name character varying(50),
  description character varying(255),
  price float,
  update_timestamp timestamp,
  constraint product_pkey primary key (id)
);

SET foreign_key_checks = 0;

## INSERCIONES ##

insert into products (id,name,description,price,update_timestamp) values('PR....215','Nokia 2610 Phone','',102.23,'2010-06-30 16:23:22.904');


SET foreign_key_checks = 1;