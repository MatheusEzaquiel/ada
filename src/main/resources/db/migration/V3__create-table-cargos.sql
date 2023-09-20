CREATE TABLE cargos (
	id INT PRIMARY KEY IDENTITY(1,1),
	area VARCHAR(60) NOT NULL,
	ativo BIT DEFAULT 1,
	id_empresa INT NOT NULL,
	FOREIGN KEY (id_empresa) REFERENCES empresas(id),
);