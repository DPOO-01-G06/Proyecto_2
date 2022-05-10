package App.Home;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

import org.jdesktop.swingx.JXMonthView;

import App.Logic.Project;
import App.Logic.User;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class NewProjectFrame extends JFrame{
    
    private MenuFrame home;
    private User user;
    private JTextField projectNameField;
    private JTextArea projectDescriptionField;
    private JXMonthView endDatePicker;
    private JLabel endDateLabel;
    private JButton cancelButton;
    private JButton createProjectButton;
    private HashMap<String,JButton> buttonMap = new HashMap<String,JButton>(); 
    private MenuClickManager clickManager;
    protected boolean openedFromHome = false;

    public NewProjectFrame(MenuFrame home) {
        this.home = home;
        this.user = home.getUser();
        this.clickManager = this.home.getClickManager();
        // Basics of window
        setLayout(new BorderLayout());
        setTitle("Beesy - New Project");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Image
        setIconImage(home.getIconImage());
        // Components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
            // Project title
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.fill = GridBagConstraints.BOTH;
            JLabel projectNameLabel = new JLabel("Project title");
            projectNameLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel.add(projectNameLabel, c);
            c.gridx = 1;
            c.gridy = 0;
            this.projectNameField = new JTextField();
            panel.add(projectNameField, c);
            // Project description
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.fill = GridBagConstraints.BOTH;
            JLabel projectDescriptionLabel = new JLabel("Project description");
            projectDescriptionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel.add(projectDescriptionLabel, c);
            c.gridx = 1;
            c.gridy = 1;
            this.projectDescriptionField = new JTextArea();
            panel.add(projectDescriptionField, c);
            // StartDate
            c.gridx = 0;
            c.gridy = 2;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.fill = GridBagConstraints.BOTH;
            JLabel startDateLabel = new JLabel("Start date");
            startDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel.add(startDateLabel, c);
            c.gridx = 1;
            c.gridy = 2;
            JXMonthView startDatePicker = new JXMonthView();
            panel.add(startDatePicker, c);
            // EndDate
            c.gridx = 0;
            c.gridy = 3;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.fill = GridBagConstraints.BOTH;
            this.endDateLabel = new JLabel("End date");
            this.endDateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
            panel.add(endDateLabel, c);
            c.gridx = 1;
            c.gridy = 3;
            this.endDatePicker = new JXMonthView();
            panel.add(endDatePicker, c);
            // Buttons
            c.gridx = 0;
            c.gridy = 4;
            c.gridwidth = 1;
            c.gridheight = 1;
            c.fill = GridBagConstraints.BOTH;
            this.createProjectButton = new JButton("Create project");
            panel.add(createProjectButton, c);
            c.gridx = 1;
            c.gridy = 4;
            this.cancelButton = new JButton("Cancel");
            panel.add(cancelButton, c);

        setButtons();
        add(panel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public void cancelProject(){
        this.dispose();
    }

    public void createProject(){
        String projectName = this.projectNameField.getText();
        String projectDescription = this.projectDescriptionField.getText();
        String startDate = this.endDatePicker.getSelectionDate().toString();
        String endDate = this.endDatePicker.getSelectionDate().toString();
        Project project = new Project(projectName, projectDescription, startDate, endDate, this.user.getUsername());
        project.saveData();
        this.user.addProject(project.getId());
        this.home.reloadData();
        if (this.home.getNewTaskFrame() != null) {
            this.home.getNewTaskFrame().setProjectChosen(project);
            this.home.getNewTaskFrame().reloadData();
            this.home.getNewTaskFrame().addProject(project);
            this.home.getNewTaskFrame().setVisible(true);
        }
        this.dispose();
    }

    // SETTERS
    public void setButtons(){
        buttonMap.put("cancelButtonProject", cancelButton);
        buttonMap.put("createProjectButtonProject", createProjectButton);
        for (String key : buttonMap.keySet()) {
            buttonMap.get(key).addActionListener(this.clickManager);
        }
    }
    
    // GETTERS
    public HashMap<String,JButton> getButtonMap(){return this.buttonMap;}

}
