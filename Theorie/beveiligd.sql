set names utf8mb4;
set charset utf8mb4;
drop database if exists beveiligd;
create database beveiligd charset utf8mb4;
use beveiligd;

CREATE TABLE users (
  username varchar(50) NOT NULL primary key,
  `password` varchar(255) NOT NULL,
  enabled tinyint NOT NULL default 1
);

INSERT INTO users(username,`password`) VALUES
('averell','{bcrypt}$2a$10$HI7LCswjUQmLWvKRyJfVA.P9ZQ3nNKi4GWfW6MKJwTCbeK9MWU.Oi'),
('joe','{bcrypt}$2a$10$3DPuiwzO.I2UYggelBe8NuCHdd7Jblz2cu8K0ZkkguQZYnCIA4u5O');

CREATE TABLE authorities (
  username varchar(50) NOT NULL,
  authority varchar(50) NOT NULL,
  CONSTRAINT authoritiesUsers FOREIGN KEY (username) REFERENCES users(username)
);

INSERT INTO `authorities` VALUES ('averell','helpdeskmedewerker'),('averell','magazijnier'),('joe','manager');

CREATE TABLE gebruikers (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  naam varchar(50) NOT NULL,
  paswoord varchar(255) NOT NULL,
  actief tinyint NOT NULL default 1,
  KEY naam(naam)
);

INSERT INTO gebruikers(naam,paswoord) VALUES
('joe','{bcrypt}$2a$10$3DPuiwzO.I2UYggelBe8NuCHdd7Jblz2cu8K0ZkkguQZYnCIA4u5O'),
('averell','{bcrypt}$2a$10$HI7LCswjUQmLWvKRyJfVA.P9ZQ3nNKi4GWfW6MKJwTCbeK9MWU.Oi');

CREATE TABLE rollen (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  naam varchar(50) NOT NULL unique
);

insert into rollen(naam) values ('manager'),('helpdeskmedewerker'),('magazijnier');


CREATE TABLE gebruikersrollen (
  gebruikerid int unsigned NOT NULL,
  rolid int unsigned NOT NULL,
  PRIMARY KEY (gebruikerid,rolid),
  CONSTRAINT gebruikersrollenRollen FOREIGN KEY (rolid) REFERENCES rollen(id),
  CONSTRAINT gebruikersrollenGebruikers FOREIGN KEY (gebruikerid) REFERENCES gebruikers(id)
);

INSERT INTO `gebruikersrollen` VALUES (1,1),(2,2),(2,3);

create user if not exists cursist identified by 'cursist';
grant select on users to cursist;
grant select on authorities to cursist;
grant select on gebruikers to cursist;
grant select on rollen to cursist;
grant select on gebruikersrollen to cursist;
