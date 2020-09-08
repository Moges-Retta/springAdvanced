use catalogus;

create table artikelsgemaakt (
  id int unsigned not null primary key,
  naam varchar(50) not null
);

create user if not exists cursist identified by 'cursist';
grant select,insert,delete on artikelsgemaakt to cursist;