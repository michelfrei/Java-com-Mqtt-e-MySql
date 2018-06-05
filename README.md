# Trabalho_SD

TLDR;
Indo direto ao código
Trabalho_SD/Pub/src/main/java/
Trabalho_SD/Sub/src/main/java/
tabelas Sql no final desse arquivo do arquivo



---------------------------------------------------------------------------------------------------
Trabalho_SD/Pub/src/main/java/

Trabalho de Sistemas Distribuidos:
O primeiro software ira realizar o cadastro de uma informação em um banco de dados (pode
ser qualquer banco, como mysql, sqlserver, oracle, etc.). Após isso, irá realizar uma publicação
no Mosquitto do ID inserido.
O segundo software estará escutando na rede pela entrada no Mosquitto que será realizada
pelo primeiro software. Quando ele receber a mensagem, deverá abrir o banco de dados,
recuperar a informação que foi gravada no primeiro software e fazer a gravação desta
informação em outro banco de dados.

O codigo foi construido em java e utiliza o Mysql como banco de dados.

---------------------------------------------------------------------------------------------------
As tabelas e bancos usados foram os seguintes

create database sys;
create database bank2;

create table sys.peoples(
	id int(5) auto_increment primary key,
    nome varchar(255) not null,
    idade int(3) not null,
    endereco varchar(255) not null,
	cpf varchar(16) not null
)

create table bank2.peoples2(
	id int(5) primary key,
    nome varchar(255) not null,
    idade int(3) not null,
    endereco varchar(255) not null,
	cpf varchar(16) not null
)
-------------------------------------------------------------------------------------------------
