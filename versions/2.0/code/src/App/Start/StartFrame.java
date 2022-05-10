package App.Start;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import App.Home.MenuFrame;
import App.Logic.User;

public class StartFrame extends JFrame{

	private String icondir = "assets/circlenezuko.png";
	private String loginicondir = "assets/nezuko.png";
	private boolean hasAccess = true;
	private User user;
	private JButton accessButton;
	private AccessPanel accessPanel;
	private StartClickManager clickManager = new StartClickManager(this);

	public StartFrame() {
		// Basics of window
		setLayout(new BorderLayout());
		setTitle("Beesy");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Image
		ImageIcon original = new ImageIcon(icondir);
		int width = 120; //original.getIconWidth() / 2;
        int height = 120; //original.getIconHeight() / 2;
		ImageIcon scaledIcon = new ImageIcon(original.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		JLabel iconLabel = new JLabel(scaledIcon);
		setIconImage(original.getImage());
		// Image for pfp
		ImageIcon originalLogin = new ImageIcon(loginicondir);
		ImageIcon loginScaledIcon = new ImageIcon(originalLogin.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
		JLabel loginIconLabel = new JLabel(loginScaledIcon);
		// Components
		    // North
			JPanel northPanel = new JPanel();
			northPanel.setLayout(new BorderLayout());
			northPanel.setBackground(Color.WHITE);
			northPanel.add(loginIconLabel, BorderLayout.NORTH);
			northPanel.add(new JLabel("Beesy",SwingConstants.CENTER), BorderLayout.SOUTH);
			add(northPanel, BorderLayout.NORTH);
			// Centre
			JPanel centrePanel = new JPanel();
			centrePanel.setBackground(Color.WHITE);
			    // I already have an account / Sign up
				String[] options = {"Sign up", "I already have an account"};
				int result = JOptionPane.showOptionDialog(null, "Do you have an account?", "Sign up", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (result == 0) {
					// Sign up
					accessPanel = new SignUpPanel(this);
					accessButton = accessPanel.getAccessButton();
				} else {
					// Sign In
					accessPanel = new SignInPanel(this);
					accessButton = accessPanel.getAccessButton();
				}
				centrePanel.add(accessPanel);
				accessButton.addActionListener(clickManager);
			add(centrePanel, BorderLayout.SOUTH);
		// Show
		pack();
		setVisible(true);
	}

	public JButton getAccessButton() {
		return accessButton;
	}

	public void setAccessStatus(boolean hasAccess) {
		this.hasAccess = hasAccess;
	}

	public void moveToMenuFrame() {
		if (hasAccess) {
			MenuFrame menuFrame = new MenuFrame(user,this);
		} else {
			accessPanel.clearFields();
			JOptionPane.showMessageDialog(null, "You don't have access to this application sign up instead.");
		}
	}

	public boolean getUserWasCreated(){
		return user.getWasCreated();
	}

	public void setUser() throws FileNotFoundException{
		accessPanel.setUsername();
		accessPanel.setPassword();
		user = new User(accessPanel.getUsername(), accessPanel.getPassword());
	}

	public static void main(String[] args){
		new StartFrame();
	}
}
