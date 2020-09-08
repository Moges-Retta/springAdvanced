set names utf8mb4;
set charset utf8mb4;
drop database if exists artikelsenartikelgroepen;
create database artikelsenartikelgroepen charset utf8mb4;
use artikelsenartikelgroepen;

create table artikelGroepen (
  id int unsigned not null auto_increment primary key,
  naam varchar(50) not null
);

create table artikels (
  id int unsigned not null auto_increment primary key,
  naam varchar(50) not null,
  prijs decimal(10,2) not null,
  artikelGroepId int unsigned not null,
  constraint artikelsArtikelGroepen foreign key (artikelGroepId) references artikelgroepen(id)
);

create user if not exists cursist identified by 'cursist';
grant select,insert on artikelGroepen to cursist;
grant select,insert on artikels to cursist;