package App.Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONArray;

public class Project {
	private int id;
	private String title;
	private String description;
	private String startDate;
	private String endDate;
	private String creator;
	private ArrayList<Integer> tasks;
	private ArrayList<String> users;

	private static ArrayList<Project> projects = new ArrayList<Project>();

	public Project(String title, String description, String startDate, String endDate, String creator) {
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creator = creator;
		this.tasks = new ArrayList<Integer>();
		this.users = new ArrayList<String>();
		this.users.add(creator);
	}

	public void saveData() {
		File projectsFolder = new File("data/projects");
		if (!projectsFolder.exists()) {
			projectsFolder.mkdirs();
		}
		int numProjects = projectsFolder.listFiles().length - 1; // -1 because of the example.json file
		this.id = numProjects;

		File projectFile = new File("data/projects/" + this.id + ".json");
		try {
			PrintWriter writer = new PrintWriter(projectFile);
			JSONObject project = new JSONObject();
			project.put("id", this.id);
			project.put("title", this.title);
			project.put("description", this.description);
			project.put("startDate", this.startDate);
			project.put("endDate", this.endDate);
			project.put("creator", this.creator);
			JSONArray tasks = new JSONArray();
			for (int index : this.tasks) {
				tasks.add(index);
			}
			project.put("tasks", tasks);	
			JSONArray users = new JSONArray();
			for (String user : this.users) {
				users.add(user);
			}
			project.put("users", users);
			writer.write(project.toJSONString());
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void loadAllProjects() {
		File projectsFolder = new File("data/projects");
		if (!projectsFolder.exists()) {
			projectsFolder.mkdirs();
		}
		File[] projectFiles = projectsFolder.listFiles();
		for (File projectFile : projectFiles) {
			if (projectFile.getName().equals("example.json")) {
				continue;
			}
			try {
				Scanner scanner = new Scanner(projectFile);
				String json = scanner.nextLine();
				scanner.close();
				JSONParser parser = new JSONParser();
				JSONObject project = (JSONObject) parser.parse(json);
				int id = Math.toIntExact((long) project.get("id"));
				String title = (String) project.get("title");
				String description = (String) project.get("description");
				String startDate = (String) project.get("startDate");
				String endDate = (String) project.get("endDate");
				String creator = (String) project.get("creator");
				JSONArray tasks = (JSONArray) project.get("tasks");
				JSONArray users = (JSONArray) project.get("users");
				ArrayList<Integer> tasksList = new ArrayList<Integer>();
				for (Object task : tasks) {
					tasksList.add((int) task);
				}
				ArrayList<String> usersList = new ArrayList<String>();
				for (Object user : users) {
					usersList.add((String) user);
				}
				Project projectObject = new Project(title, description, startDate, endDate, creator);
				projectObject.id = id;
				projectObject.tasks = tasksList;
				projectObject.users = usersList;
				projects.add(projectObject);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	// ADDERS
	public void addTask(int taskId) {this.tasks.add(taskId);}

	// GETTERS
	public static ArrayList<Project> getProjects() {return projects;}
	public int getId() {return id;}
	public String getTitle() {return title;}
}