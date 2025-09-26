package com.pi.etapa4;

import javax.swing.*;
import java.awt.*;

public class CadastrarLivroPanel extends JPanel {
    private AppController controller;
    private JTextField tfTitle, tfAuthor, tfYear, tfISBN;
    private JLabel lblMessage;

    public CadastrarLivroPanel(AppController controller) {
        this.controller = controller;
        setLayout(new BorderLayout(10,10));
        JLabel title = new JLabel("Cadastrar Livro");
        title.setFont(title.getFont().deriveFont(20f));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6,6,6,6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("Título:"), gbc);
        gbc.gridx = 1;
        tfTitle = new JTextField(30);
        form.add(tfTitle, gbc);

        gbc.gridx = 0; gbc.gridy++;
        form.add(new JLabel("Autor:"), gbc);
        gbc.gridx = 1;
        tfAuthor = new JTextField(30);
        form.add(tfAuthor, gbc);

        gbc.gridx = 0; gbc.gridy++;
        form.add(new JLabel("Ano:"), gbc);
        gbc.gridx = 1;
        tfYear = new JTextField(10);
        form.add(tfYear, gbc);

        gbc.gridx = 0; gbc.gridy++;
        form.add(new JLabel("ISBN:"), gbc);
        gbc.gridx = 1;
        tfISBN = new JTextField(20);
        form.add(tfISBN, gbc);

        add(form, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        JButton btnSave = new JButton("Salvar");
        btnSave.addActionListener(e -> saveBook());
        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(e -> controller.showDashboard());
        bottom.add(btnSave);
        bottom.add(btnBack);

        lblMessage = new JLabel(" ");
        add(lblMessage, BorderLayout.SOUTH);
        add(bottom, BorderLayout.PAGE_END);
    }

    private void saveBook() {
        String title = tfTitle.getText().trim();
        String author = tfAuthor.getText().trim();
        String yearStr = tfYear.getText().trim();
        String isbn = tfISBN.getText().trim();

        if (title.isEmpty() || author.isEmpty()) {
            lblMessage.setText("Título e autor são obrigatórios.");
            return;
        }
        int year = 0;
        if (!yearStr.isEmpty()) {
            try {
                year = Integer.parseInt(yearStr);
            } catch (NumberFormatException ex) {
                lblMessage.setText("Ano inválido.");
                return;
            }
        }
        Book b = new Book(title, author, year, isbn);
        controller.addBook(b);
        lblMessage.setText("Livro salvo com sucesso.");
        resetForm();
    }

    public void resetForm() {
        tfTitle.setText("");
        tfAuthor.setText("");
        tfYear.setText("");
        tfISBN.setText("");
        lblMessage.setText(" ");
    }
}
