CREATE TABLE tb_cliente (
	id_cliente SERIAL 		PRIMARY KEY,
	nome_cliente 	 		VARCHAR(100) NOT NULL,
	nome_fantasia			VARCHAR(100) UNIQUE,
	cpf_cnpj_cliente 		VARCHAR(14) NOT NULL UNIQUE,
	rg_cliente	 			VARCHAR(15) UNIQUE,
	titulo_eleitor_cliente  VARCHAR(12) UNIQUE,
	num_contato_cliente 	VARCHAR(11),
	email_cliente 			VARCHAR(100) UNIQUE,
	dt_nascimento_cliente 	DATE NOT NULL,
	tipo_cliente			VARCHAR(4),
	fixo_cliente 			CHAR(1) DEFAULT 'N' NOT NULL
);

CREATE TABLE tb_acesso_portal (
	id_acesso 		SERIAL PRIMARY KEY,
	ds_acesso 		VARCHAR(30) NOT NULL,
	cod_acesso 		VARCHAR(15),
	senha_acesso	VARCHAR(15) NOT NULL,
	fk_cliente 		INTEGER NOT NULL,
	FOREIGN KEY (fk_cliente) REFERENCES tb_cliente (id_cliente)
);

CREATE TABLE tb_servico (
	id_servico SERIAL 		PRIMARY KEY,
	valor_servico 			DECIMAL(10,2) NOT NULL,
	ano_referencia_servico 	VARCHAR(4) NOT NULL,
	data_servico 			date NOT NULL,
	observacoes_servico		VARCHAR(200),
	fk_cliente 				INTEGER NOT NULL,
	FOREIGN KEY (fk_cliente) REFERENCES tb_cliente (id_cliente)
);


CREATE TABLE users(
	username VARCHAR(50) NOT NULL PRIMARY KEY,
	password VARCHAR(255) NOT NULL,
	enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
	username VARCHAR(50) NOT NULL,
	authority VARCHAR(50) NOT NULL,
	CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username,authority);

INSERT INTO users VALUES('LeonnyLino', '$2a$10$6FAlvgV3hBcyhVZ0UrAhquRtVcR91SKYEaczjF2.0BPY5mjmBpbYu', true); --lino321
INSERT INTO authorities VALUES('LeonnyLino', 'ROLE_ADM');
INSERT INTO users VALUES('Renata Aciole', '$2a$10$lZRq2wCt2BnaHVgKXOfBie7vhAlMhsAiOPLqpzsjC/rC2HdCB0VbK', true); --11062016
INSERT INTO authorities VALUES('Renata Aciole', 'ROLE_ADM');
