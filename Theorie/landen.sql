set names utf8mb4;
set charset utf8mb4;
drop database if exists landen;
create database landen charset utf8mb4;
use landen;

create table landen (
  code char(2) not null primary key,
  naam varchar(255) not null
);

insert into landen(code, naam) values
('BE','België'),
('NL','Nederland'),
('LU','Luxemburg');

create user if not exists cursist identified by 'cursist';
grant select on landen to cursist;