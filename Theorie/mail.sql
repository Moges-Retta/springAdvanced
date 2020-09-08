set names utf8mb4;
set charset utf8mb4;
drop database if exists mail;
create database mail charset utf8mb4;
use mail;

CREATE TABLE leden (
  id int unsigned not null auto_increment primary key,
  voornaam varchar(50) not null,
  familienaam varchar(50) not null,
  emailadres varchar(50) not null,
  lidsinds date not null
);

create user if not exists cursist identified by 'cursist';
grant select,insert on leden to cursist;