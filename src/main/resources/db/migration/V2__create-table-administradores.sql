CREATE TABLE administradores (
	id INT PRIMARY KEY IDENTITY(1,1),
	login VARCHAR(150) NOT NULL UNIQUE,
	apelido VARCHAR(60),
	nome_completo VARCHAR(255) NOT NULL,
	email VARCHAR(150) NOT NULL,
	telefone VARCHAR(25) NOT NULL,
	senha VARCHAR(100) NOT NULL,
	foto VARCHAR(150),
	ativo BIT DEFAULT 1,

	id_empresa INT NOT NULL,
	FOREIGN KEY (id_empresa) REFERENCES empresas(id)
);