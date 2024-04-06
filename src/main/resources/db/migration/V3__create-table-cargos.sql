CREATE TABLE cargos (
    id UUID PRIMARY KEY,
    area VARCHAR(60) NOT NULL,
    ativo BOOLEAN DEFAULT TRUE,
    id_empresa UUID NOT NULL,
    FOREIGN KEY (id_empresa) REFERENCES empresas(id)
);
