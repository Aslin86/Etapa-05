package com.pi.etapa4;

import javax.swing.*;
import java.awt.*;

public class CadastrarUsuarioPanel extends JPanel {
    private AppController controller;
    private JTextField tfName, tfEmail, tfId;
    private JLabel lblMessage;

    public CadastrarUsuarioPanel(AppController controller) {
        this.controller = controller;
        setLayout(new BorderLayout(10,10));
        JLabel title = new JLabel("Cadastrar Usuário");
        title.setFont(title.getFont().deriveFont(20f));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6,6,6,6);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0; gbc.gridy = 0;
        form.add(new JLabel("Nome:"), gbc);
        gbc.gridx = 1;
        tfName = new JTextField(30);
        form.add(tfName, gbc);

        gbc.gridx = 0; gbc.gridy++;
        form.add(new JLabel("Email:"), gbc);
        gbc.gridx = 1;
        tfEmail = new JTextField(30);
        form.add(tfEmail, gbc);

        gbc.gridx = 0; gbc.gridy++;
        form.add(new JLabel("ID (opcional):"), gbc);
        gbc.gridx = 1;
        tfId = new JTextField(20);
        form.add(tfId, gbc);

        add(form, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        JButton btnSave = new JButton("Salvar");
        btnSave.addActionListener(e -> saveUser());
        JButton btnBack = new JButton("Voltar");
        btnBack.addActionListener(e -> controller.showDashboard());
        bottom.add(btnSave);
        bottom.add(btnBack);

        lblMessage = new JLabel(" ");
        add(lblMessage, BorderLayout.SOUTH);
        add(bottom, BorderLayout.PAGE_END);
    }

    private void saveUser() {
        String name = tfName.getText().trim();
        String email = tfEmail.getText().trim();
        String id = tfId.getText().trim();

        if (name.isEmpty() || email.isEmpty()) {
            lblMessage.setText("Nome e email são obrigatórios.");
            return;
        }
        User u = new User(name, email, id);
        controller.addUser(u);
        lblMessage.setText("Usuário salvo com sucesso.");
        resetForm();
    }

    public void resetForm() {
        tfName.setText("");
        tfEmail.setText("");
        tfId.setText("");
        lblMessage.setText(" ");
    }
}
