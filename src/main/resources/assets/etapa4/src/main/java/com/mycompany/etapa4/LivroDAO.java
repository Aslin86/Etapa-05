package com.pi.etapa4;

import java.sql.*;
import java.util.*;

public class LivroDAO {
    public void inserir(Book b) {
        String sql = "INSERT INTO livros (isbn, title, author,year) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, b.getTitle());
            stmt.setString(2, b.getAuthor());
            stmt.setInt(3, b.getYear());
            stmt.setString(4, b.getIsbn());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> listarTodos() {
        List<Book> lista = new ArrayList<>();
        String sql = "SELECT * FROM livros";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Book(
                    rs.getString("isbn"),
                    rs.getString("title"),
                    rs.getInt("autor"),
                    rs.getString("year")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
