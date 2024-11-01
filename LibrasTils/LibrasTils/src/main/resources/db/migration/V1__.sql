CREATE TABLE eventos
(
    id        BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    titulo    VARCHAR(255),
    tema      VARCHAR(255),
    tipo      VARCHAR(255),
    data      date,
    horario   time WITHOUT TIME ZONE,
    lugar     VARCHAR(255),
    descricao VARCHAR(255),
    CONSTRAINT pk_eventos PRIMARY KEY (id)
);

CREATE TABLE interpretes
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    cpf             VARCHAR(255),
    "user"          VARCHAR(255),
    nome_completo   VARCHAR(255),
    data_nascimento date,
    genero          VARCHAR(255),
    telefone        VARCHAR(255),
    email           VARCHAR(255),
    senha           VARCHAR(255),
    rua             VARCHAR(255),
    cidade          VARCHAR(255),
    estado          VARCHAR(255),
    cep             VARCHAR(255),
    numero          VARCHAR(255),
    CONSTRAINT pk_interpretes PRIMARY KEY (id)
);

CREATE TABLE usuarios
(
    id              BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    cpf             VARCHAR(255),
    "user"          VARCHAR(255),
    nome_completo   VARCHAR(255),
    data_nascimento date,
    genero          VARCHAR(255),
    telefone        VARCHAR(255),
    email           VARCHAR(255),
    senha           VARCHAR(255),
    rua             VARCHAR(255),
    cidade          VARCHAR(255),
    estado          VARCHAR(255),
    cep             VARCHAR(255),
    numero          VARCHAR(255),
    CONSTRAINT pk_usuarios PRIMARY KEY (id)
);