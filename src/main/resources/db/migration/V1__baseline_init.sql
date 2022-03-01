CREATE TABLE tb_cliente (
	id_cliente SERIAL PRIMARY KEY,
	nome_cliente VARCHAR(100) NOT NULL,
	cpf_cliente VARCHAR(11) NOT NULL UNIQUE,
    rg_cliente	VARCHAR(15) NOT NULL UNIQUE,
    titulo_eleitor_cliente  VARCHAR(12) NOT NULL UNIQUE,
    num_contato_cliente VARCHAR(11),
    email_cliente VARCHAR(100) UNIQUE,
    dt_nascimento_cliente date NOT NULL,
	ultimo_valor_cobrado_cliente decimal(10,2)
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

INSERT INTO users VALUES('LeonnyLino', '$2a$10$6FAlvgV3hBcyhVZ0UrAhquRtVcR91SKYEaczjF2.0BPY5mjmBpbYu', true);
INSERT INTO authorities VALUES('LeonnyLino', 'ROLE_ADM');
INSERT INTO users VALUES('Renata Aciole', '$2a$10$lZRq2wCt2BnaHVgKXOfBie7vhAlMhsAiOPLqpzsjC/rC2HdCB0VbK', true);
INSERT INTO authorities VALUES('Renata Aciole', 'ROLE_ADM');