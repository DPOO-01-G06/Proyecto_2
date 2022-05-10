package App.Home;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import App.Logic.Project;
import App.Logic.User;
import App.Start.StartFrame;

public class MenuFrame extends JFrame{

    private String icondir = "assets/circlenezuko.png";
	private String loginicondir = "assets/nezukokillsyou.png";
	private User user;
	private JButton newTaskButton;
	private JButton newProjectButton;
	private JTextField searchBar;
	private JButton searchButton;
	private HashMap<String,JButton> buttonMap = new HashMap<String,JButton>();
	private MenuClickManager clickManager = new MenuClickManager(this);
	private NewTaskFrame newTaskFrame;
	private int taskCount;
	private int projectCount;
	private JLabel taskCountLabel;
	private JLabel projectCountLabel;
	private NewProjectFrame newProjectFrame;

    public MenuFrame(User user, StartFrame start) {
		// Open this frame and close start frame
		this.setLayout(new BorderLayout());
		this.setTitle("Beesy - " + user.getUsername());
		this.setSize(500, 500);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		start.setVisible(false);
		start.dispose();
		this.taskCount = user.getTaskCount();
		this.projectCount = user.getProjectCount();
		// Image
		ImageIcon original = new ImageIcon(icondir);
		this.setIconImage(original.getImage());
        // Components
			// Image for pfp
			ImageIcon originalLogin = new ImageIcon(loginicondir);
			int width = 80;
			int height = 80;
			ImageIcon loginScaledIcon = new ImageIcon(originalLogin.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
			JLabel loginIconLabel = new JLabel(loginScaledIcon, SwingConstants.CENTER);
		// Center panel
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		centerPanel.setBackground(Color.WHITE);
		    // Center - Center
			JPanel centerCenterPanel = new JPanel();
			centerCenterPanel.setLayout(new BorderLayout());
			centerCenterPanel.setBackground(Color.WHITE);
			centerCenterPanel.add(loginIconLabel, BorderLayout.NORTH);
			centerCenterPanel.add(new JLabel("@" + user.getUsername(), SwingConstants.CENTER), BorderLayout.CENTER);
			    // Center - Center - South
				JPanel centerCenterSouthPanel = new JPanel();
				centerCenterSouthPanel.setLayout(new BorderLayout());
				centerCenterSouthPanel.setBackground(Color.WHITE);
				JLabel taskCountLabel = new JLabel("Tasks: " + user.getTaskCount(), SwingConstants.CENTER);
				this.taskCountLabel = taskCountLabel;
				JLabel projectCountLabel = new JLabel("Projects: " + user.getProjectCount(), SwingConstants.CENTER);
				this.projectCountLabel = projectCountLabel;
				centerCenterSouthPanel.add(taskCountLabel, BorderLayout.CENTER);
				centerCenterSouthPanel.add(projectCountLabel, BorderLayout.SOUTH);
			centerCenterPanel.add(centerCenterSouthPanel, BorderLayout.SOUTH);
			centerPanel.add(centerCenterPanel, BorderLayout.CENTER);
			// Center - East
			JPanel centerEastPanel = new JPanel();
			centerEastPanel.setLayout(new BorderLayout());
			centerEastPanel.setBackground(Color.WHITE);
			    // Center - East - Center
				JPanel centerEastNorthPanel = new JPanel();
				centerEastNorthPanel.setLayout(new BorderLayout());
				centerEastNorthPanel.setBackground(Color.WHITE);
				    // Buttons for new items
				   	this.newTaskButton = new JButton("New Task");
					this.newTaskButton.setBorder(new EmptyBorder(5,0,5,0));
					this.newTaskButton.setPreferredSize(new Dimension(20, 15));
					this.newProjectButton = new JButton("New Project");
					this.newProjectButton.setBorder(new EmptyBorder(5,0,5,0));
					this.newProjectButton.setPreferredSize(new Dimension(20, 15));
					centerEastNorthPanel.add(this.newTaskButton, BorderLayout.CENTER);
					centerEastNorthPanel.add(this.newProjectButton, BorderLayout.SOUTH);
				centerEastPanel.add(centerEastNorthPanel, BorderLayout.NORTH);
				// Center - East - South
				JPanel centerEastSouthPanel = new JPanel();
				centerEastSouthPanel.setLayout(new BorderLayout());
				centerEastSouthPanel.setBackground(Color.WHITE);
				    // Search bar for general purpose
					JTextField searchBar = new JTextField();
					searchBar.setPreferredSize(new Dimension(40, 18));
					searchBar.setBorder(new EmptyBorder(0, 0, 0, 0));
					searchBar.setBackground(Color.WHITE);
					searchBar.setForeground(Color.BLACK);
					searchBar.setHorizontalAlignment(SwingConstants.CENTER);
					searchBar.setToolTipText("@User || #Task || &Project");
					searchBar.setFont(new java.awt.Font("Arial", 0, 14));
					searchBar.setBorder(new EmptyBorder(0, 0, 0, 0));
					searchBar.setMargin(new Insets(0, 0, 0, 0));
					this.searchBar = searchBar;
					JButton searchButton = new JButton("Find");
					searchButton.setPreferredSize(new Dimension(50, 30));
					searchButton.setBackground(Color.WHITE);
					searchButton.setForeground(Color.BLACK);
					searchButton.setFont(new java.awt.Font("Arial", 0, 14));
					searchButton.setBorder(new EmptyBorder(0, 0, 0, 0));
					searchButton.setMargin(new Insets(0, 0, 0, 0));
					this.searchButton = searchButton;
				centerEastSouthPanel.add(searchBar, BorderLayout.CENTER);
				centerEastSouthPanel.add(searchButton, BorderLayout.EAST);
			centerEastPanel.add(centerEastSouthPanel, BorderLayout.SOUTH);
			centerEastPanel.setBorder(new EmptyBorder(40,10,10,40));
			centerPanel.add(centerEastPanel, BorderLayout.EAST);
		centerPanel.setBorder(new EmptyBorder(10,10,10,10));
		this.add(centerPanel, BorderLayout.CENTER);
		// South Panel
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new BorderLayout());
		    // South - West
			JPanel southWestPanel = new JPanel();
			southWestPanel.setLayout(new BorderLayout());
				// South - West labels
				JLabel southWestLabel = new JLabel("<html><font color='#006699'><u>About</u></font></html>");
				southWestLabel.setFont(new java.awt.Font("Arial", 0, 14));
				southWestLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
				southWestPanel.add(southWestLabel, BorderLayout.CENTER);
				JLabel southWestLabel2 = new JLabel("<html><font color='#006699'><u>Help</u></font></html>");
				southWestLabel2.setFont(new java.awt.Font("Arial", 0, 14));
				southWestLabel2.setBorder(new EmptyBorder(0, 0, 0, 0));
				southWestPanel.add(southWestLabel2, BorderLayout.SOUTH);
				// South - West buttons
				JButton aboutButton = new JButton("About");
				aboutButton.setFont(new java.awt.Font("Arial", 0, 14));
				aboutButton.setBorder(new EmptyBorder(0, 0, 0, 0));
			southWestPanel.add(aboutButton, BorderLayout.WEST);
			JButton helpButton = new JButton("Help");
			helpButton.setFont(new java.awt.Font("Arial", 0, 14));
			helpButton.setBorder(new EmptyBorder(0, 0, 0, 0));
			southWestPanel.add(helpButton, BorderLayout.EAST);
			southPanel.add(southWestPanel, BorderLayout.WEST);
			// South - Center
			JPanel southCenterPanel = new JPanel();
			southCenterPanel.setLayout(new BorderLayout());
				// South - Center labels
				JLabel southCenterLabel = new JLabel("<html><font color='#006699'><u>Log Out</u></font></html>");
				southCenterLabel.setFont(new java.awt.Font("Arial", 0, 14));
				southCenterLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
				southCenterPanel.add(southCenterLabel, BorderLayout.CENTER);
				JLabel southCenterLabel2 = new JLabel("<html><font color='#006699'><u>Exit</u></font></html>");
				southCenterLabel2.setFont(new java.awt.Font("Arial", 0, 14));
				southCenterLabel2.setBorder(new EmptyBorder(0, 0, 0, 0));
				southCenterPanel.add(southCenterLabel2, BorderLayout.SOUTH);
				// South - Center buttons
				JButton logOutButton = new JButton("Log Out");
				logOutButton.setFont(new java.awt.Font("Arial", 0, 14));
				logOutButton.setBorder(new EmptyBorder(0, 0, 0, 0));
			southCenterPanel.add(logOutButton, BorderLayout.WEST);
			JButton exitButton = new JButton("Exit");
			exitButton.setFont(new java.awt.Font("Arial", 0, 14));
			exitButton.setBorder(new EmptyBorder(0, 0, 0, 0));
			southCenterPanel.add(exitButton, BorderLayout.EAST);
			southPanel.add(southCenterPanel, BorderLayout.CENTER);
			// South - East
			JPanel southEastPanel = new JPanel();
			southEastPanel.setLayout(new BorderLayout());
				// South - East labels
				JLabel southEastLabel = new JLabel("<html><font color='#006699'><u>Log In</u></font></html>");
				southEastLabel.setFont(new java.awt.Font("Arial", 0, 14));
				southEastLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
				southEastPanel.add(southEastLabel, BorderLayout.CENTER);
				JLabel southEastLabel2 = new JLabel("<html><font color='#006699'><u>Register</u></font></html>");
				southEastLabel2.setFont(new java.awt.Font("Arial", 0, 14));
				southEastLabel2.setBorder(new EmptyBorder(0, 0, 0, 0));
				southEastPanel.add(southEastLabel2, BorderLayout.SOUTH);
				// South - East buttons
				JButton logInButton = new JButton("Log In");
				logInButton.setFont(new java.awt.Font("Arial", 0, 14));
				logInButton.setBorder(new EmptyBorder(0, 0, 0, 0));
				southEastPanel.add(logInButton, BorderLayout.WEST);
				JButton registerButton = new JButton("Register");
				registerButton.setFont(new java.awt.Font("Arial", 0, 14));
				registerButton.setBorder(new EmptyBorder(0, 0, 0, 0));
				southEastPanel.add(registerButton, BorderLayout.EAST);
			southPanel.add(southEastPanel, BorderLayout.EAST);
		southPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
		this.user = User.findUser(user.getUsername());
		reloadData();
		setButtons();
		this.add(southPanel, BorderLayout.SOUTH);
		this.pack();
		this.setVisible(true);
    }

	public void setButtons(){
		this.buttonMap.put("newTask", newTaskButton);
		this.buttonMap.put("newProject", newProjectButton);
		this.buttonMap.put("search", searchButton);
		for (String key : this.buttonMap.keySet()){
			JButton button = this.buttonMap.get(key);
			button.addActionListener(clickManager);
		}
	}

	public HashMap<String,JButton> getButtons() {
		return this.buttonMap;
	}

	public void moveToNewTaskFrame() {
		this.setVisible(false);
		this.newTaskFrame = new NewTaskFrame(this);
		this.newTaskFrame.setButtons();
		this.buttonMap.putAll(newTaskFrame.getButtons());
	}

	public void addButtons(HashMap<String,JButton> buttons) {
		this.buttonMap.putAll(buttons);
	}

	public MenuClickManager getClickManager() {
		return this.clickManager;
	}

	public NewTaskFrame getNewTaskFrame() {
		return this.newTaskFrame;
	}

	public NewProjectFrame getNewProjectFrame() {
		return this.newProjectFrame;
	}

	public User getUser() {
		return this.user;
	}

	public void moveToNewProjectFrame() {
		this.setVisible(false);
		this.newProjectFrame = new NewProjectFrame(this);
		this.newProjectFrame.setButtons();
		this.buttonMap.putAll(newProjectFrame.getButtonMap());
		newProjectFrame.openedFromHome = true;
	}

	public void reloadData(){
		this.user = User.findUser(this.user.getUsername());
		this.taskCount = user.getTaskCount();
		this.projectCount = user.getProjectCount();
		this.taskCountLabel.setText("Tasks: " + this.taskCount);
		this.projectCountLabel.setText("Projects: " + this.projectCount);
	}
}
