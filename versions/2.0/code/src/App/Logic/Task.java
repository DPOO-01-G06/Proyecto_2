package App.Logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class Task {

	private int id;
	private String title;
	private String description;
	private String type;
	private String endDate;
	private String startHour;
	private String endHour;
	private String user;
	private int project;

	public Task(String title, String description, String type, String endDate, String startHour, String endHour) {
		this.title = title;
		this.description = description;
		this.type = type;
		this.endDate = endDate;
		this.startHour = startHour;
		this.endHour = endHour;
	}

	public void saveData(){
		File tasksFolder = new File("data/tasks");
		if (!tasksFolder.exists()) {
			tasksFolder.mkdirs();
		}
		int numTasks = tasksFolder.listFiles().length - 1; // -1 because of the example.json file
		this.id = numTasks;
		
		File taskFile = new File("data/tasks/" + this.id + ".json");
		try {
			PrintWriter writer = new PrintWriter(taskFile);
			JSONObject task = new JSONObject();
			task.put("id", this.id);
			task.put("title", this.title);
			task.put("description", this.description);
			task.put("type", this.type);
			task.put("endDate", this.endDate);
			task.put("startHour", this.startHour);
			task.put("endHour", this.endHour);
			task.put("user", this.user);
			task.put("project", this.project == -1? null : this.project);
			writer.println(task);
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// SETTERS
	public void setUser(String user) {this.user = user;}
	public void setProject(int project) {this.project = project;}
	// GETTERS
	public int getId() {return this.id;}
}