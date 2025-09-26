PI - Etapa 4 (UI + Banco de Dados)
=================================

Projeto atualizado para a Etapa 4 do PI, com conexão ao MySQL.

Funcionalidades:
- Dashboard com contagem de livros e usuários (dados persistidos no banco MySQL).
- Tela de cadastro de livro (titulo, autor, ano, isbn) com inserção no banco.
- Tela de cadastro de usuário (nome, email, id) com inserção no banco.
- Listagem de livros e contagem atualizadas via consultas ao banco.

Configuração:
1. Criar banco de dados no MySQL:
   ```sql
   CREATE DATABASE pi_etapa4;
   USE pi_etapa4;
   CREATE TABLE usuarios (
     id INT AUTO_INCREMENT PRIMARY KEY,
     nome VARCHAR(100) NOT NULL,
     email VARCHAR(100) NOT NULL,
     codigo VARCHAR(20)
   );
   CREATE TABLE livros (
     id INT AUTO_INCREMENT PRIMARY KEY,
     titulo VARCHAR(150) NOT NULL,
     autor VARCHAR(100) NOT NULL,
     ano INT,
     isbn VARCHAR(20)
   );
   ```

2. Inserir dados iniciais para teste:
   ```sql
   INSERT INTO usuarios (nome, email, codigo) VALUES ('João Silva', 'joao@email.com','U001');
   INSERT INTO livros (titulo, autor, ano, isbn) VALUES ('Dom Casmurro','Machado de Assis',1899,'9788520933102');
   ```

3. Ajustar credenciais no arquivo `DBConnection.java`:
   ```java
   private static final String URL = "jdbc:mysql://localhost:3306/pi_etapa4";
   private static final String USER = "root";
   private static final String PASS = "senha";
   ```

Execução:
- Importar no NetBeans (Maven).
- Executar a classe principal `com.pi.etapa4.Main`.
- Necessário ter o banco MySQL rodando com dados criados.

Observações:
- Dependência `mysql-connector-java` adicionada no `pom.xml`.
- DAO implementado para Livro e Usuário.
