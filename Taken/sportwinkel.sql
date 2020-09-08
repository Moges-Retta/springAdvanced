set names utf8mb4;
set charset utf8mb4;
drop database if exists sportwinkel;
create database sportwinkel charset utf8mb4;
use sportwinkel;

CREATE TABLE artikels (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  naam varchar(50) NOT NULL,
  aankoopprijs decimal(10,2) NOT NULL,
  verkoopprijs decimal(10,2) NOT NULL
);

create user if not exists cursist identified by 'cursist';
grant select,insert on artikels to cursist;