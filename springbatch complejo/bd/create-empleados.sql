use acme_catalog;

create table if not exists empleados (cif varchar(10) NOT NULL, nombre varchar(20), apellidos varchar(20), edad integer, primary key (cif));

