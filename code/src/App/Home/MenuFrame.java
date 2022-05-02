package App.Home;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import App.Logic.User;
import App.Start.StartFrame;

public class MenuFrame extends JFrame{

    private String icondir = "assets/nezuko.png";
	private String loginicondir = "assets/nezukoLogin.png";
	private User user;

    public MenuFrame(User user, StartFrame start) {
		// Open this frame and close start frame
		this.setLayout(new BorderLayout());
		this.setTitle("Beesy - " + user.getUsername());
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		start.setVisible(false);
		start.dispose();
		this.user = user;
		// Image
		ImageIcon original = new ImageIcon(icondir);
		this.setIconImage(original.getImage());
        // Components
            // North
            JPanel northPanel = new JPanel();
			    // Container North
				JPanel containerNorth = new JPanel();
				containerNorth.setLayout(new BorderLayout());
				    // Container West inside container North
					JPanel containerWestInNorth = new JPanel();
					containerWestInNorth.setLayout(new BorderLayout());
						// Image
						ImageIcon originalLogin = new ImageIcon(loginicondir);
						int width = 100;
						int height = 100;
						ImageIcon loginScaledIcon = new ImageIcon(originalLogin.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
						JLabel loginIconLabel = new JLabel(loginScaledIcon);
						// User data
						JPanel userDataPanel = new JPanel();
						userDataPanel.setLayout(new BorderLayout());
						JLabel username = new JLabel("@" + user.getUsername());
						JLabel activityCount = new JLabel("Activities: " + user.getActivityCount());
						JLabel projectCount = new JLabel("Projects: " + user.getProjectCount());
						userDataPanel.add(username, BorderLayout.NORTH);
						userDataPanel.add(activityCount, BorderLayout.CENTER);
						userDataPanel.add(projectCount, BorderLayout.SOUTH);
					containerWestInNorth.add(loginIconLabel, BorderLayout.NORTH);
					containerWestInNorth.add(userDataPanel, BorderLayout.CENTER);
					containerNorth.add(containerWestInNorth, BorderLayout.WEST);
					// Container Center inside container North
					JPanel containerCenterInNorth = new JPanel();
					containerCenterInNorth.setLayout(new BorderLayout());
					// FELIPE, AQUI IRA LA INSTANCIA DEL JPANEL QUE ESTAS HACIENDO
					//containerNorth.add(containerCenterInNorth, BorderLayout.CENTER);
			this.add(northPanel, BorderLayout.NORTH);
		//this.pack();
		this.setVisible(true);
    }
}
