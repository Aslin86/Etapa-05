package com.pi.etapa4;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AppController {
    private JPanel mainPanel;
    private CardLayout cardLayout;
    private DashboardPanel dashboardPanel;
    private CadastrarLivroPanel cadastrarLivroPanel;
    private CadastrarUsuarioPanel cadastrarUsuarioPanel;

    private UsuarioDAO usuarioDAO = new UsuarioDAO();
    private LivroDAO livroDAO = new LivroDAO();

    public AppController() {
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        dashboardPanel = new DashboardPanel(this);
        cadastrarLivroPanel = new CadastrarLivroPanel(this);
        cadastrarUsuarioPanel = new CadastrarUsuarioPanel(this);

        mainPanel.add(dashboardPanel, "dashboard");
        mainPanel.add(cadastrarLivroPanel, "cadastrarLivro");
        mainPanel.add(cadastrarUsuarioPanel, "cadastrarUsuario");

        showDashboard();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public void showDashboard() {
        dashboardPanel.refreshStats();
        cardLayout.show(mainPanel, "dashboard");
    }

    public void showCadastrarLivro() {
        cadastrarLivroPanel.resetForm();
        cardLayout.show(mainPanel, "cadastrarLivro");
    }

    public void showCadastrarUsuario() {
        cadastrarUsuarioPanel.resetForm();
        cardLayout.show(mainPanel, "cadastrarUsuario");
    }

    public void addBook(Book b) {
        livroDAO.inserir(b);
        dashboardPanel.refreshStats();
    }

    public List<Book> getBooks() {
        return livroDAO.listarTodos();
    }

    public void addUser(User u) {
        usuarioDAO.inserir(u);
        dashboardPanel.refreshStats();
    }

    public List<User> getUsers() {
        return usuarioDAO.listarTodos();
    }
}
