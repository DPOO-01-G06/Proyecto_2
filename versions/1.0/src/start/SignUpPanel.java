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

public class SignUpPanel extends JPanel implements ActionListener{

    private MainWindow home;
    private String defaultUsername = "Username";
    private String defaultPassword = "Password";
    private JTextField username;
    private JTextField nombre;
    private JPasswordField password;

    public SignUpPanel(MainWindow frame) {
        // Basics of window
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        home = frame;
        // Components
            // North
            JPanel northPanel = new JPanel();
            northPanel.setBackground(Color.WHITE);
            northPanel.add(new JLabel("Sign Up"));
            add(northPanel, BorderLayout.NORTH);
            // Center
            JPanel centrePanel = new JPanel();
            centrePanel.setBackground(Color.WHITE);
            username = new JTextField(defaultUsername,20);
            password = new JPasswordField(defaultPassword,20);
            nombre =new JTextField("ingrese nombre",20);
            centrePanel.add(username);
            centrePanel.add(nombre);
            centrePanel.add(password);
            add(centrePanel, BorderLayout.CENTER);
            // South
            JButton signUp = new JButton("Sign Up");
            signUp.addActionListener(this);
            add(signUp,BorderLayout.SOUTH);
    }

	@Override
	public void actionPerformed(ActionEvent arg0) {
		home.sign(username.getText(),nombre.getText(), password.getText());
		
		
	}
}
