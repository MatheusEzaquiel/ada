CREATE TABLE registro_ponto (
	id INT PRIMARY KEY IDENTITY(1,1),
	data DATE,
	horario_entrada DATETIME,
	horario_saida DATETIME,
	horario_intervalo_entrada DATETIME,
	horario_intervalo_saida DATETIME,
	presenca_wifi BIT NOT NULL,
	ativo BIT DEFAULT 1,

	id_funcionario INT NOT NULL,
	FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id)
);