set names utf8mb4;
set charset utf8mb4;
drop database if exists rest;
create database rest charset utf8mb4;
use rest;

CREATE TABLE filialen (
  id int unsigned NOT NULL AUTO_INCREMENT primary key,
  naam varchar(50) NOT NULL,
  gemeente varchar(50) NOT NULL,
  omzet decimal(10,2)
);

INSERT INTO filialen(naam,gemeente,omzet) VALUES
('Andros','Brussel',1000),
('Delos','Dendermonde',2000),
('Gavdos','Genk',3000),
('Hydra','Heverlee',4000),
('Ikaria','Wevelgem',5000),
('Oinouses','Oostende',6000);

/*create user if not exists cursist identified by 'cursist';*/
grant select,insert,update,delete on filialen to cursist;