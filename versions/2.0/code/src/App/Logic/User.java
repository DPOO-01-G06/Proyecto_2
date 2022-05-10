package App.Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class User {

    private boolean wasCreated = false;
    private static boolean wantToSave = true;
    private String username;
    private String password;
    private static String accountsdir = "data/accounts.txt";

    private ArrayList<Integer> tasks; // List of tasks ID's
    private ArrayList<Integer> projects; // List of projects ID's

    public User(String username, String password) throws FileNotFoundException{
        ArrayList<ArrayList<Integer>> data = findUserData(username);
        this.username = username;
        this.password = password;
        if (data != null){ // Sign in
            this.wasCreated = false;
            this.tasks = data.get(0);
            this.projects = data.get(1);
        } else { // Sign up
            this.wasCreated = true;
            this.tasks = new ArrayList<Integer>();
            this.projects = new ArrayList<Integer>();
        }
        if (wantToSave){
            saveData();
        }
    }

    public void saveData(){
        boolean found = false;
        String realData = this.username + ":" + this.password + ":" + this.tasks.toString() + ":" + this.projects.toString();
        try {
            Scanner sc = new Scanner(new File(accountsdir));
            ArrayList<String> lines = new ArrayList<String>();
            while (sc.hasNextLine()) {
                String current = sc.nextLine();
                String[] parts = current.split(":");
                if (parts[0].equals(this.username)){
                    found = true;
                    lines.add(realData);
                } else {lines.add(current);}
            }
            sc.close();
            if (!found){lines.add(realData);}

            PrintWriter pw = new PrintWriter(new File(accountsdir));
            for (String line : lines) {
                pw.println(line);
            }  
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<ArrayList<Integer>> findUserData(String username){
        ArrayList<ArrayList<Integer>> userData = null;
        try {
            Scanner sc = new Scanner (new File(accountsdir));
            while (sc.hasNextLine()){
                String[] line = sc.nextLine().split(":");
                if (line[0].equals(username)){
                    userData = retrieveLists(line);
                    break;
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {ex.printStackTrace();} return userData;
    }

    private static ArrayList<ArrayList<Integer>> retrieveLists(String[] line) throws FileNotFoundException{
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tasks = new ArrayList<Integer>();
        ArrayList<Integer> projects = new ArrayList<Integer>();
        if (line[2].length() > 2){
            for (String s : line[2].substring(1, line[2].length() - 1).split(",")){
                if (s.length() > 0){tasks.add(Integer.parseInt(s.strip()));}
            }
            for (String s : line[3].substring(1, line[3].length() - 1).split(",")){
                if (s.length() > 0){projects.add(Integer.parseInt(s.strip()));}
            }
        }
        lists.add(tasks);
        lists.add(projects);
        return lists;
    }

    public static User findUser(String username){
        User user = null;
        try {
            Scanner sc = new Scanner (new File(accountsdir));
            while (sc.hasNextLine()){
                String[] line = sc.nextLine().split(":");
                if (line[0].equals(username)){
                    user = new User(line[0], line[1]);
                    break;
                }
            }
            sc.close();
        } catch (FileNotFoundException ex) {ex.printStackTrace();} return user;
    }

    // GETTERS
    public String getUsername(){return username;}
    public int getTaskCount(){return tasks.size();}
    public int getProjectCount(){return projects.size();}
    public boolean getWasCreated(){return wasCreated;}
    // ADDERS
    public void addTask(int taskID){tasks.add(taskID);saveData();}
    public void addProject(int projectID){projects.add(projectID);saveData();}
    // REMOVERS
    public void removetask(int taskID){tasks.remove(taskID);}
    public void removeProject(int projectID){projects.remove(projectID);}
}
