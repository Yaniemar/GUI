import pages.LoginPage;
import pages.SignUpPage;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //called the signUpPage since it has sign-up and log-in button(the modified version)
        SwingUtilities.invokeLater(SignUpPage::new);
    }
}