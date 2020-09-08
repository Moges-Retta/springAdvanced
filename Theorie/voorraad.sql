set names utf8mb4;
set charset utf8mb4;
drop database if exists voorraad;
create database voorraad charset utf8mb4;
use voorraad;

create table artikels (
  id int unsigned not null primary key,
  voorraad int not null
);

create user if not exists cursist identified by 'cursist';
grant select,insert on artikels to cursist;