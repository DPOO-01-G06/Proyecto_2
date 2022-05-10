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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import App.Logic.Task;
import App.Logic.Project;
import App.Logic.User;

public class NewTaskFrame extends JFrame{

    private JButton createTaskButton;
    private JTextField TaskNameField;
    private JTextArea TaskDescriptionField;
    private JTextField TaskTypeField;
    private JXMonthView TaskEndDateField;
    private JTextField TaskStartHourField;
    private JTextField TaskEndHourField;
    private MenuClickManager clickManager;
    private HashMap<String,JButton> buttonMap = new HashMap<String,JButton>();
    private Project projectChosen = null;
    private User userChosen;
    private MenuFrame home;
    private ArrayList<Project> projects;
    private JButton projectButton;
    private NewProjectFrame newProjectFrame;
    JComboBox<String> projectPicker;

    public NewTaskFrame(MenuFrame home) {
        this.home = home;
        this.clickManager = this.home.getClickManager();
        this.userChosen = this.home.getUser();
        Project.loadAllProjects();
        this.projects = Project.getProjects();
        // Basics of window
		setLayout(new BorderLayout());
		setTitle("Beesy - New Task");
		setSize(500, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        // Image
        setIconImage(home.getIconImage());
        // Components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(5, 5, 5, 5);
        c.fill = GridBagConstraints.BOTH;
            // Project picker
            c.gridx = 0;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridheight = 1;
            JLabel projectLabel = new JLabel("Project");
            panel.add(projectLabel, c);
            c.gridx = 1;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridheight = 1;
            this.projectPicker = new JComboBox<String>();
            for (Project p : this.projects) {
                projectPicker.addItem(p.getTitle());
            }
            panel.add(projectPicker, c);
            c.gridx = 2;
            c.gridy = 0;
            c.gridwidth = 1;
            c.gridheight = 1;
            projectButton = new JButton("Create Project");
            panel.add(projectButton, c);
            // Task name
            c.gridx = 0;
            c.gridy = 1;
            c.gridwidth = 2;
            c.gridheight = 1;
            JLabel TaskNameLabel = new JLabel("Task title");
            panel.add(TaskNameLabel, c);
            c.gridx = 2;
            c.gridy = 1;
            c.gridwidth = 2;
            c.gridheight = 1;
            TaskNameField = new JTextField();
            panel.add(TaskNameField, c);
            // Task description
            c.gridx = 0;
            c.gridy = 2;
            c.gridwidth = 2;
            c.gridheight = 1;
            JLabel TaskDescriptionLabel = new JLabel("Task description");
            panel.add(TaskDescriptionLabel, c);
            c.gridx = 2;
            c.gridy = 2;
            c.gridwidth = 2;
            c.gridheight = 1;
            TaskDescriptionField = new JTextArea();
            TaskDescriptionField.setLineWrap(true);
            TaskDescriptionField.setWrapStyleWord(true);
            panel.add(TaskDescriptionField, c);
            // Task type
            c.gridx = 0;
            c.gridy = 3;
            c.gridwidth = 2;
            c.gridheight = 1;
            JLabel TaskTypeLabel = new JLabel("Task type");
            panel.add(TaskTypeLabel, c);
            c.gridx = 2;
            c.gridy = 3;
            c.gridwidth = 2;
            c.gridheight = 1;
            TaskTypeField = new JTextField();
            panel.add(TaskTypeField, c);
            // Task end date
            c.gridx = 0;
            c.gridy = 4;
            c.gridwidth = 2;
            c.gridheight = 1;
            JLabel TaskEndDateLabel = new JLabel("Task end date");
            panel.add(TaskEndDateLabel, c);
            c.gridx = 2;
            c.gridy = 4;
            c.gridwidth = 2;
            c.gridheight = 1;
            TaskEndDateField = new JXMonthView();
            panel.add(TaskEndDateField, c);
            // Task start hour
            c.gridx = 0;
            c.gridy = 5;
            c.gridwidth = 2;
            c.gridheight = 1;
            JLabel TaskStartHourLabel = new JLabel("Task start hour");
            panel.add(TaskStartHourLabel, c);
            c.gridx = 2;
            c.gridy = 5;
            c.gridwidth = 2;
            c.gridheight = 1;
            TaskStartHourField = new JTextField();
            panel.add(TaskStartHourField, c);
            // Task end hour
            c.gridx = 0;
            c.gridy = 6;
            c.gridwidth = 2;
            c.gridheight = 1;
            JLabel TaskEndHourLabel = new JLabel("task end hour");
            panel.add(TaskEndHourLabel, c);
            c.gridx = 2;
            c.gridy = 6;
            c.gridwidth = 2;
            c.gridheight = 1;
            TaskEndHourField = new JTextField();
            panel.add(TaskEndHourField, c);
            // Create Task button
            c.gridx = 0;
            c.gridy = 7;
            c.gridwidth = 4;
            c.gridheight = 1;
            createTaskButton = new JButton("Create task");
            panel.add(createTaskButton, c);
        add(panel);
        // Last configurations
        setVisible(true);
        pack();
    }

    public void setButtons(){
        buttonMap.put("createTask", createTaskButton);
        buttonMap.put("projectButton", projectButton);
        for (String key : buttonMap.keySet()) {
            buttonMap.get(key).addActionListener(clickManager);
        }
    }

    public HashMap<String,JButton> getButtons(){
        return buttonMap;
    }

    public void createTask(){
        String taskTitle = TaskNameField.getText();
        String taskDescription = TaskDescriptionField.getText();
        String taskType = TaskTypeField.getText();
        String taskEndDate = TaskEndDateField.getSelectionDate().toString();
        String taskStartHour = TaskStartHourField.getText();
        String taskEndHour = TaskEndHourField.getText();
        Task task = new Task(taskTitle, taskDescription, taskType, taskEndDate, taskStartHour, taskEndHour);
        task.setUser(userChosen.getUsername());
        task.setProject(projectChosen == null? -1 : projectChosen.getId());
        task.saveData();
        userChosen.addTask(task.getId());
        this.dispose();
        home.reloadData();
        home.setVisible(true);
    }

    public void createProject(){
        this.newProjectFrame = new NewProjectFrame(home);
        home.addButtons(newProjectFrame.getButtonMap());
    }

    public void addProject(Project project){
        this.projects.add(project);
        projectPicker.addItem(project.getTitle());
    }

    public NewProjectFrame getNewProjectFrame(){return newProjectFrame;}

    public void setProjectChosen(Project projectChosen){
        this.projectChosen = projectChosen;
    }

    public void reloadData(){

    }
}
