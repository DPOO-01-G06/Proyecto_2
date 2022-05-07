package start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class SignInPanel extends JPanel implements ActionListener{

    private MainWindow home;
    private String defaultUsername = "Username";
    private String defaultPassword = "Password";
    private JTextField username;
    private JPasswordField password;
    private JButton signIn;

    public SignInPanel(MainWindow frame) {
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
            JPanel southPanel = new JPanel();
            southPanel.setBackground(Color.WHITE);
            username = new JTextField(defaultUsername,20);
            password = new JPasswordField(defaultPassword,20);
            southPanel.add(username);
            southPanel.add(password);
            add(southPanel, BorderLayout.CENTER);
            signIn = new JButton("Sign In");
            signIn.addActionListener(this);
            add(signIn, BorderLayout.SOUTH);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		home.validar(username.getText(),password.getText());
		
	}
}
