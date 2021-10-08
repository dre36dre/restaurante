create database menu;

create table pedido(

id int not null auto_increment primary key,
nome varchar(40),
quantidade int,
preco double,
tamanho varchar(10),
dataCadastro date)