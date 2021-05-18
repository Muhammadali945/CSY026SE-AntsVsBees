package core;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * @author Muhammad
 * This is the driver class for the game. It is basically a login page which runs the game if correct credentials are applied.
 * It also registers new users in a binary file "userList.dat" which is in the root directory
 */

public class run_game {
    //Following components are added to the class via run_game.from
    private JPasswordField passwordField;
    private JPanel rootPanel;
    private JButton loginButton;
    private JButton registerButton;
    private JButton resetButton;
    private JTextField nameTextField;
    private JLabel message;
    private user user;
    private userList uList = new userList();


    public run_game() {

        try {
            uList.addMultipleUser(uList.readUserList());


//        System.out.println(cList.showUser(0));
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
                    uList.addUser(user);
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
                    uList = userList.readUserList();
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
                        if ((uList.showUser(i).getUserName().equals(nameTextField.getText())) && (password.equals((uList.showUser(i).getPassword())))) {
                            message.setText("Opening Application");
                            core.level_menu.play();
                            break;
                        } else {
                            message.setText("Either username or password is not correct.");
                            nameTextField.setText("");
                            passwordField.setText("");
                        }
                    }
                }
            }

        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nameTextField.setText("");
                passwordField.setText("");
                message.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("AntVsBees Login Page");
        frame.setContentPane(new run_game().rootPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}

