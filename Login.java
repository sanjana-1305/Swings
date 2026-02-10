package Swings;
import javax.swing.*;
import java.awt.event.*;

public class Login {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Secure Login");
        frame.setSize(400, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // --- UI Components ---
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(50, 30, 100, 30);
        frame.add(userLabel);

        JTextField userField = new JTextField();
        userField.setBounds(150, 30, 150, 30);
        frame.add(userField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(50, 80, 100, 30);
        frame.add(passLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(150, 80, 150, 30);
        frame.add(passField);

        // --- Buttons ---
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(80, 140, 100, 30); // Moved to the left slightly
        frame.add(loginButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(200, 140, 100, 30); // Added next to Login
        frame.add(resetButton);

        // --- Logic for Login ---
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passField.getPassword());

                if (username.equals("admin") && password.equals("123")) {
                    JOptionPane.showMessageDialog(frame, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // --- Logic for Reset ---
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userField.setText(""); // Clears username
                passField.setText(""); // Clears password
                userField.requestFocus(); // Puts the typing cursor back in the username box
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}