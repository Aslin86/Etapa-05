-- Criação do banco de dados
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- Tabela de usuários
CREATE TABLE users (
    id VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Tabela de livros
CREATE TABLE books (
    isbn VARCHAR(20) PRIMARY KEY,
    title VARCHAR(150) NOT NULL,
    author VARCHAR(100) NOT NULL,
    year INT NOT NULL
);

-- Dados de teste para usuários
INSERT INTO users (id, name, email) VALUES
('U001', 'Maria Silva', 'maria.silva@email.com'),
('U002', 'João Souza', 'joao.souza@email.com'),
('U003', 'Ana Pereira', 'ana.pereira@email.com');

-- Dados de teste para livros
INSERT INTO books (isbn, title, author, year) VALUES
('978-8535914849', 'Dom Casmurro', 'Machado de Assis', 1899),
('978-8520933100', 'O Cortiço', 'Aluísio Azevedo', 1890),
('978-6555522580', 'Capitães da Areia', 'Jorge Amado', 1937);
