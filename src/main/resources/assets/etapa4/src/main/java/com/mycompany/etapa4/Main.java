package com.pi.etapa4;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("PI - Etapa 3 (UI)");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);

            AppController controller = new AppController();
            frame.setContentPane(controller.getMainPanel());
            frame.setVisible(true);
        });
    }
}
