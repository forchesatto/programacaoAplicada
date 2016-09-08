create table cidade(
	codcidade int not null AUTO_INCREMENT primary key,
    nome varchar(100) not null
    );
alter table Endereco add codcidade int;
alter table Endereco add foreign key 
	(codcidade) references cidade(codcidade);
insert into cidade VALUES(1,'XANXERÊ');