package core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import core.user;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

public class login_view {
    private JPasswordField passwordField;
    private JPanel rootPanel;
    private JButton loginButton;
    private JButton registerButton;
    private JButton button3;
    private JTextField nameTextField;
    private JLabel message;
    private user user;
    private userList uList = new userList();



    public static void main(String[] args) {
        JFrame frame = new JFrame("login_view");
        frame.setContentPane(new login_view().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public login_view() {

        try {
            uList.addMultipleCustomer(uList.readCustomerList());


//        System.out.println(cList.showCustomer(0));
        } catch (ClassNotFoundException | IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = String.valueOf(passwordField.getPassword());
                message.setText("");
                //System.out.println(passwordField.getPassword());
                if (nameTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Empty user name");
                } else if (password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Empty Password");
                } else {
                    user = new user(nameTextField.getText(), password);
                    //System.out.println(user.getUserName());
                    uList.addCustomer(user);
                    try {
                        userList.writeToFile(uList);
                    } catch (IOException event) {
                        // TODO Auto-generated catch block
                        event.printStackTrace();
                    }
                    message.setText("New user " + nameTextField.getText() + " has been added");
                    nameTextField.setText("");
                    passwordField.setText("");
                }

            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    uList = userList.readCustomerList();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ClassNotFoundException classNotFoundException) {
                    classNotFoundException.printStackTrace();
                }
                String password = String.valueOf(passwordField.getPassword());
                message.setText("");
                //System.out.println(passwordField.getPassword());
                if (nameTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Empty");
                } else if (password.equals("")) {
                    JOptionPane.showMessageDialog(null, "Empty Password");
                } else {

                    for (int i = 0; i < uList.getSize(); i++) {
                        //System.out.println(nameTextField.getText());
                        if ((uList.showCustomer(i).getUserName().equals(nameTextField.getText())) && (password.equals((uList.showCustomer(i).getPassword())))) {
                            message.setText("Opening Application");
                            core.level_menu.play();
                            break;}
                            else{
                                message.setText("Either username or password is not correct.");
                                nameTextField.setText("");
                                passwordField.setText("");
                            }
                        }
                    }
                }

        });
    }
}

