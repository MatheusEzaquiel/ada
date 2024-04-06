CREATE TABLE registro_ponto (
    id UUID PRIMARY KEY,
    data DATE,
    horario_entrada TIMESTAMP,
    horario_saida TIMESTAMP,
    horario_intervalo_entrada TIMESTAMP,
    horario_intervalo_saida TIMESTAMP,
    ssid_atual VARCHAR(150) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    id_funcionario UUID NOT NULL,
    FOREIGN KEY (id_funcionario) REFERENCES funcionarios(id)
);
