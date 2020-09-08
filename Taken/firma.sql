set names utf8mb4;
set charset utf8mb4;
drop database if exists firma;
create database firma charset utf8mb4;
use firma;

CREATE TABLE werknemers (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  familienaam varchar(50) NOT NULL,
  voornaam varchar(50) NOT NULL,
  emailAdres varchar(100) NOT NULL unique,
  paswoord varchar(100) NOT NULL
);

INSERT INTO werknemers(familienaam,voornaam,emailAdres,paswoord) VALUES
 ('Mieke','Devos','mieke.devos@firma.be','{bcrypt}$2a$10$i4MlDK9l7YM.cpwCY68j4OJP7CEin5.wFDJCptUP7CQWHnNPh6xjy'),
 ('Jan','De Mol','jan.demol@firma.be','{bcrypt}$2a$10$i4MlDK9l7YM.cpwCY68j4OJP7CEin5.wFDJCptUP7CQWHnNPh6xjy'),
 ('Ann','De Pauw','ann.depauw@firma.be','{bcrypt}$2a$10$i4MlDK9l7YM.cpwCY68j4OJP7CEin5.wFDJCptUP7CQWHnNPh6xjy');
 
create user if not exists cursist identified by 'cursist';
grant select on werknemers to cursist;