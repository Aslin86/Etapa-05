package com.pi.etapa4;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DashboardPanel extends JPanel {
    private AppController controller;
    private JLabel lblCounts;
    private JTable tableBooks;
    private DefaultTableModel booksTableModel;

    public DashboardPanel(AppController controller) {
        this.controller = controller;
        setLayout(new BorderLayout(10,10));
        JPanel top = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Dashboard");
        title.setFont(title.getFont().deriveFont(24f));
        top.add(title, BorderLayout.WEST);

        JPanel buttons = new JPanel();
        JButton btnCadastrarLivro = new JButton("Cadastrar Livro");
        btnCadastrarLivro.addActionListener(e -> controller.showCadastrarLivro());
        JButton btnCadastrarUsuario = new JButton("Cadastrar Usuário");
        btnCadastrarUsuario.addActionListener(e -> controller.showCadastrarUsuario());
        buttons.add(btnCadastrarLivro);
        buttons.add(btnCadastrarUsuario);
        top.add(buttons, BorderLayout.EAST);

        add(top, BorderLayout.NORTH);

        lblCounts = new JLabel("Livros: 0   Usuários: 0");
        add(lblCounts, BorderLayout.SOUTH);

        // Center: table of books
        String[] cols = {"Título", "Autor", "Ano", "ISBN"};
        booksTableModel = new DefaultTableModel(cols, 0) {
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tableBooks = new JTable(booksTableModel);
        add(new JScrollPane(tableBooks), BorderLayout.CENTER);

        // Initial refresh
        refreshStats();
    }

    public void refreshStats() {
        int nBooks = controller.getBooks().size();
        int nUsers = controller.getUsers().size();
        lblCounts.setText(String.format("Livros: %d   Usuários: %d", nBooks, nUsers));

        // Update books table
        booksTableModel.setRowCount(0);
        for (Book b : controller.getBooks()) {
            booksTableModel.addRow(new Object[]{b.getTitle(), b.getAuthor(), b.getYear(), b.getIsbn()});
        }
    }
}
