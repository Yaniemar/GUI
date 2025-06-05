/* Revellame, Marianne T.
   BSIT 2-2
   SignUpPage
   The modified version with log in and sign up button to have multiple account
*/

package pages;

import dal.admins.AdminDAO;

import javax.swing.*;
import java.awt.*;

public class SignUpPage extends JFrame {
    private final AdminDAO adminDao = new AdminDAO();
    private final JTextField usernameField;
    private final JPasswordField passwordField;
    private final JButton signInButton;
    private final JButton signUpButton;

    public SignUpPage() {
        setTitle("Admin Login");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(usernameLabel, gbc);

        usernameField = new JTextField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(usernameField, gbc);

        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        add(passwordLabel, gbc);

        passwordField = new JPasswordField(15);
        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.LINE_START;
        add(passwordField, gbc);

        signInButton = new JButton("Log In");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(signInButton, gbc);

        signUpButton = new JButton("Sign Up");
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(signUpButton, gbc);

        signInButton.addActionListener(e -> handleLogin());
        signUpButton.addActionListener(e -> handleSignUp());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.");
            return;
        }

        boolean valid = adminDao.checkIfAdminExists(username, password);
        if (valid) {
            JOptionPane.showMessageDialog(this, "Login successful!");
            new StudentPage();

            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.");
        }
    }

    //action when sign-Up button is clicked
    private void handleSignUp() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both username and password.");
            return;
        }

        boolean valid=adminDao.addAccount(username, password);

        if (valid) {
            JOptionPane.showMessageDialog(this, "Sign-Up successful!");
            new LoginPage();

            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Username already exist. Please create a new username!");
        }
    }
}
