- Criação da tabela de usuários utilizando o flyway, com o arquivo V1_create_users_table.sql

CREATE TABLE tb_users (
    id BINARY(16) NOT NULL PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
);

- Inserindo usuários iniciais

INSERT INTO tb_users (id, username, email) VALUES (UNHEX(REPLACE('11111111-1111-1111-1111-111111111111', '-', '')), 'Giovanni', 'giovanni@example.com');
INSERT INTO tb_users (id, username, email) VALUES (UNHEX(REPLACE('22222222-2222-2222-2222-222222222222', '-', '')), 'Maria', 'maria@example.com');
INSERT INTO tb_users (id, username, email) VALUES (UNHEX(REPLACE('33333333-3333-3333-3333-333333333333', '-', '')), 'Carlos', 'carlos@example.com');
INSERT INTO tb_users (id, username, email) VALUES (UNHEX(REPLACE('44444444-4444-4444-4444-444444444444', '-', '')), 'Ana', 'ana@example.com');
INSERT INTO tb_users (id, username, email) VALUES (UNHEX(REPLACE('55555555-5555-5555-5555-555555555555', '-', '')), 'Pedro', 'pedro@example.com');