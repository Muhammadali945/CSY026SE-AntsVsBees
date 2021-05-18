package core;

import javax.swing.*;
import java.awt.*;

public class login {

    private JFrame frame;
    private JPanel panel;
    private JLabel usernameLabel;
    private JLabel passwprdLabel;
    private JTextField usernameText;
    private JPasswordField passwprdText;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login window = new login();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public login(){
        initialize();
    }

    private void initialize() {frame = new JFrame();
        frame.setSize( 600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Login Page");

        panel = new JPanel();
        frame.add(panel);

        panel.setBackground(Color.gray);
        panel.setLayout(null);

        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(30,80,80,20);
        panel.add(usernameLabel);

        usernameText = new JTextField();
        usernameText.setBounds(160, 80, 80, 20);
        panel.add(usernameText);

        frame.setVisible(true);

    }


}

