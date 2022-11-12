
DROP table IF EXISTS fabricantes;

create table fabricantes(
    id int auto_increment PRIMARY KEY,
    nombre varchar(100)
);

insert into fabricantes (nombre) values ('HP');
insert into fabricantes (nombre) values ('DELL');
insert into fabricantes (nombre) values ('WESTERN DIGITAL');
insert into fabricantes (nombre) values ('SONY');
insert into fabricantes (nombre) values ('CANON');

DROP table IF EXISTS articulos;

create table articulos(
    id int auto_increment PRIMARY KEY,
    nombre varchar(100),
    precio int,
    id_fabricante int,
    FOREIGN KEY(id_fabricante) REFERENCES fabricantes(id) ON DELETE CASCADE ON UPDATE CASCADE
);

insert into articulos (nombre, precio, id_fabricante) values ('impresoras', 250, 1);
insert into articulos (nombre, precio, id_fabricante) values ('portatiles', 789, 2);
insert into articulos (nombre, precio, id_fabricante) values ('disco ssd', 154, 3);
insert into articulos (nombre, precio, id_fabricante) values ('mouses', 25, 4);
insert into articulos (nombre, precio, id_fabricante) values ('web cams', 57, 5);