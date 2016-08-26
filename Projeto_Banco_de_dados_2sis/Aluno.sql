CREATE TABLE POO_Usuario
(
  id    number(5) constraint pk_user primary key,
  login varchar(100) constraint nn_usu_login not null,
  senha varchar(100) 
);

INSERT INTO POO_Usuario VALUES (1,'Leandro', '75179');