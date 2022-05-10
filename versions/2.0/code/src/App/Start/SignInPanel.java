package App.Start;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInPanel extends AccessPanel{

    private JFrame home;
    private String defaultUsername = "User";
    private String defaultPassword = "123";
    private String username;
    private String password;
    private JButton signInButton;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public SignInPanel(JFrame frame) {
        // Basics of window
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        home = frame;
        // Components
            // North
            JPanel northPanel = new JPanel();
            northPanel.setBackground(Color.WHITE);
            northPanel.add(new JLabel("Sign In"));
            add(northPanel, BorderLayout.NORTH);
            // Center
            JPanel centrePanel = new JPanel();
                // Container
                JPanel container = new JPanel();
                container.setLayout(new BorderLayout());
                container.setBackground(Color.WHITE);
                usernameField = new JTextField(defaultUsername,20);
                passwordField = new JPasswordField(defaultPassword,20);
                container.add(usernameField, BorderLayout.NORTH);
                container.add(passwordField, BorderLayout.CENTER);
                centrePanel.add(container);
            centrePanel.setBackground(Color.WHITE);
            add(centrePanel, BorderLayout.CENTER);
            // South
            JPanel southPanel = new JPanel();
            southPanel.setBackground(Color.WHITE);
            JButton signIn = new JButton("Sign In");
            this.signInButton = signIn;
            southPanel.add(signIn);
            add(southPanel, BorderLayout.SOUTH);
    }

    @Override
    public JButton getAccessButton() {
        return this.signInButton;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void clearFields() {
        this.username = "";
        this.password = "";
        usernameField.setText(defaultUsername);
        passwordField.setText(defaultPassword);
    }

    @Override
    public void setUsername() {
        this.username = usernameField.getText();
    }

    @Override
    public void setPassword() {
        this.password = new String(passwordField.getPassword());
    }
}
