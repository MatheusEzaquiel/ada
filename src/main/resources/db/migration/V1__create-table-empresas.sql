CREATE TABLE empresas (
	id INT PRIMARY KEY IDENTITY(1,1),
	cnpj VARCHAR(18) NOT NULL,
	nome VARCHAR(150) NOT NULL,
	dominio VARCHAR(150) NOT NULL UNIQUE,
	area_atuacao VARCHAR(200),
	localizacao VARCHAR(255) NOT NULL,
	numero VARCHAR(5),
	rua VARCHAR(80),
	bairro VARCHAR(80),
	cidade VARCHAR(40),
	uf CHAR(2),
	pais VARCHAR(40),
	ativo BIT DEFAULT 1
);