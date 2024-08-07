-- Criação da tabela de usuários
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL
);

-- Criação da tabela de produtos
CREATE TABLE products (
                          id SERIAL PRIMARY KEY,
                          name VARCHAR(255) NOT NULL,
                          description TEXT,
                          price DECIMAL(10, 2) NOT NULL,
                          brand VARCHAR(255),
                          category VARCHAR(255),
                          state VARCHAR(255)
);
