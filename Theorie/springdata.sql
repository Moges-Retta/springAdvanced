set names utf8mb4;
set charset utf8mb4;
drop database if exists springdata;
create database springdata charset utf8mb4;
use springdata;

create table filialen (
  id int unsigned not null auto_increment primary key,
  naam varchar(50) not null,
  gemeente varchar(50) not null,
  omzet decimal(10,2)
);

create table werknemers(
  id int unsigned not null auto_increment primary key,
  voornaam varchar(50) not null,
  familienaam varchar(50) not null,
  filiaalId int unsigned not null,
  constraint werknemersFilialen foreign key (filiaalId) references filialen(id)
);

/*create user if not exists cursist identified by 'cursist';*/
grant select,insert,update,delete on filialen to cursist;
grant select,insert,update,delete on werknemers to cursist;