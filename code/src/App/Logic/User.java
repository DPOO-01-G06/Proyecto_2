package App.Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class User {

    private String username;
    private String password;
    private static String accountsdir = "data/accounts.txt";

    private ArrayList<Integer> activities; // List of activities ID's
    private ArrayList<Integer> projects; // List of projects ID's

    public User(String username, String password) throws FileNotFoundException{
        this.username = username;
        this.password = password;

        this.activities = new ArrayList<Integer>();
        this.projects = new ArrayList<Integer>();

        String activitiesText = "-1";
        String projectsText = "-1";

        PrintWriter pw = new PrintWriter(accountsdir);
        pw.println(this.username + ":" + this.password + ":" + activitiesText + ":" + projectsText); // Username:Password:{list of activities}:{list of projects}
        pw.close();
    }

    public void loadData() {
        try {
            Scanner sc = new Scanner(new File(accountsdir));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(":");
                if (parts[0].equals(this.username)) {
                    String[] activitiesText = parts[2].split(",");
                    for (String activity : activitiesText) {
                        if (activity.equals("-1")) {
                            continue;
                        }
                        this.activities.add(Integer.parseInt(activity));
                    }
                    String[] projectsText = parts[3].split(",");
                    for (String project : projectsText) {
                        if (project.equals("-1")) {
                            continue;
                        }
                        this.projects.add(Integer.parseInt(project));
                    }
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveData() {
        try {
            Scanner sc = new Scanner(new File(accountsdir));
            ArrayList<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            sc.close();

            PrintWriter pw = new PrintWriter(accountsdir);
            for (String line : lines) {
                String[] parts = line.split(":");
                if (parts[0].equals(this.username)) {
                    String activitiesText = "";
                    for (Integer activity : this.activities) {
                        activitiesText += activity + ",";
                    }
                    activitiesText = activitiesText.substring(0, activitiesText.length() - 1);
                    String projectsText = "";
                    for (Integer project : this.projects) {
                        projectsText += project + ",";
                    }
                    projectsText = projectsText.substring(0, projectsText.length() - 1);
                    pw.println(this.username + ":" + this.password + ":" + activitiesText + ":" + projectsText);
                } else {
                    pw.println(line);
                }
            }
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addActivity(int activityid) {
        this.activities.add(activityid);
        Collections.sort(this.activities);
    }

    public void addProject(int projectid) {
        this.projects.add(projectid);
        Collections.sort(this.projects);
    }

    public void removeActivity(int activityid) {
        this.activities.remove(activityid);
    }

    public void removeProject(int projectid) {
        this.projects.remove(projectid);
    }

    public String getUsername() {
        return this.username;
    }

    public int getActivityCount() {
        return this.activities.size();
    }

    public int getProjectCount() {
        return this.projects.size();
    }

    public static User signIn(String username, String password) {
        try {
            Scanner sc = new Scanner(new File(accountsdir));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] parts = line.split(":");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    User user = new User(username, password);
                    String[] activitiesText = parts[2].split(",");
                    for (String activity : activitiesText) {
                        user.activities.add(Integer.parseInt(activity));
                    }
                    String[] projectsText = parts[3].split(",");
                    for (String project : projectsText) {
                        user.projects.add(Integer.parseInt(project));
                    }
                    return user;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
