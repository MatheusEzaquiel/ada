CREATE TABLE administradores (
    id UUID PRIMARY KEY,
    login VARCHAR(150) NOT NULL UNIQUE,
    apelido VARCHAR(60),
    nome_completo VARCHAR(255) NOT NULL,
    email VARCHAR(150) NOT NULL,
    telefone VARCHAR(25) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    foto VARCHAR(150),
    ativo BOOLEAN DEFAULT TRUE,
    role VARCHAR(50),
    id_empresa UUID NOT NULL,
    FOREIGN KEY (id_empresa) REFERENCES empresas(id)
);
