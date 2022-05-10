package App.Home;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;

public class MenuClickManager implements ActionListener{
    private MenuFrame home;
    private NewTaskFrame newTaskFrame;
    private NewProjectFrame newProjectFrame;
    HashMap<String,JButton> buttonMap;

    public MenuClickManager(MenuFrame home) {
        this.home = home;
        this.buttonMap = home.getButtons();
    }

    @Override
    public void actionPerformed(ActionEvent e) throws RuntimeException{
        System.out.println("MenuClickManager: actionPerformed");
        JButton button = (JButton) e.getSource();
        if (button == buttonMap.get("newTask")) {
            System.out.println("newtask pressed");
            home.moveToNewTaskFrame();
            this.buttonMap = home.getButtons();
            this.newTaskFrame = home.getNewTaskFrame();
        }
        else if (button == buttonMap.get("newProject")){
            System.out.println("newproject pressed");
            home.moveToNewProjectFrame();
        }
        else if (button == buttonMap.get("search")){

        }
        else if (button == buttonMap.get("createTask")){
            System.out.println("createtask pressed");
            newTaskFrame.createTask();
        }
        else if (button == buttonMap.get("projectButton")){
            System.out.println("projectButton pressed");
            newTaskFrame.createProject();
            this.newProjectFrame = newTaskFrame.getNewProjectFrame();
            this.buttonMap = home.getButtons();
        }
        else if (button == buttonMap.get("cancelButtonProject")){
            System.out.println("cancelButtonProject pressed");
            newProjectFrame.cancelProject();
        }
        else if (button == buttonMap.get("createProjectButtonProject")){
            System.out.println("createProjectButtonProject pressed");
            newProjectFrame = home.getNewProjectFrame();
            newProjectFrame.createProject();
            if (newProjectFrame.openedFromHome){
                home.setVisible(true);
            }
        }
    }
    
}
