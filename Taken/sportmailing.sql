set names utf8mb4;
set charset utf8mb4;
drop database if exists sportmailing;
create database sportmailing charset utf8mb4;
use sportmailing;

CREATE TABLE sporters (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  emailadres varchar(50) NOT NULL
);

create user if not exists cursist identified by 'cursist';
grant select,insert on sporters to cursist;