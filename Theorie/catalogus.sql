set names utf8mb4;
set charset utf8mb4;
drop database if exists catalogus;
create database catalogus charset utf8mb4;
use catalogus;

create table artikels (
  id int unsigned not null auto_increment primary key,
  naam varchar(50) not null,
  gemaakt datetime not null
);

create user if not exists cursist identified by 'cursist';
grant select,insert on artikels to cursist;