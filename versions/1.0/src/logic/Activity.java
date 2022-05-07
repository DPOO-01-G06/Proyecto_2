package logic;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Activity implements Serializable{
	
	long startTime;
	long endTime;
	long startTimePause;
	long endTimePause;
	long durationPause;
	long duration = 0;
	private String title;
	private java.util.Date dateI;
	private java.util.Date dateF;
	private Participant responsible;
	private String description;
	private String type;
	private int ID;
	private ArrayList<Register> registers;
	private int projectID;
	//Constructor
	public Activity(String title, Participant responsible, String description,String type,int ID, int projectID) {
		this.title = title;
		this.dateI = new java.util.Date();
		this.dateF = new java.util.Date();
		this.responsible = responsible;
		this.description = description;
		this.type = type;
		this.ID = ID;
		this.projectID = projectID;
		this.registers=new ArrayList<Register>();
	}
	
	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	public long getStartTimePause() {
		return startTimePause;
	}

	public void setStartTimePause(long startTimePause) {
		this.startTimePause = startTimePause;
	}

	public long getEndTimePause() {
		return endTimePause;
	}

	public void setEndTimePause(long endTimePause) {
		this.endTimePause = endTimePause;
	}

	public long getDurationPause() {
		return durationPause;
	}

	public void setDurationPause(long durationPause) {
		this.durationPause = durationPause;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public Participant getResponsible() {
		return responsible;
	}

	public void setResponsible(Participant responsible) {
		this.responsible = responsible;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<Register> getRegisters() {
		return registers;
	}

	public void setRegisters(ArrayList<Register> registers) {
		this.registers = registers;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDateI(java.util.Date dateI) {
		this.dateI = dateI;
	}

	public void setDateF(java.util.Date dateF) {
		this.dateF = dateF;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}

	public void changeDateI(String dateString) {
		this.dateI = parseDate(dateString);
		System.out.println(this.dateI);
	}

	public void changeDateF(String dateString) {
		this.dateF = parseDate(dateString);	
		System.out.println(this.dateF);
	}
	
	 public static Date parseDate(String date) {
	     try {
	         return new SimpleDateFormat("yyyy.MM.dd 'at' h:mm").parse(date);
	     } catch (ParseException e) {
	         return null;
	     }
	  }
	 
	 public void startTimer() {
		 startTime = System.nanoTime();
	 }
	 
	 public void pauseTimer() {
		 startTimePause = System.nanoTime();
	 }
	 
	 public void resumeTimer() {
		endTimePause = System.nanoTime();
		durationPause = (endTimePause - startTimePause);
		duration -= durationPause;
	 }
	 
	 public void stopTimer() {
		 endTime = System.nanoTime();
		 duration += (endTime - startTime);
	 }
	 
	 public long getTime() {
		 return duration;
	 }
	 
	 public String getTitle() {
		 return title;
	 }
	 
	 public String getType() {
		 return type;
	 }
	 
	 public int getID() {
		 return ID;
	 }
	 
	 public int getProjectID() {
		 return projectID;
	 }
	 
	 public Date getDateI() {
		 return dateI;
	 }
	 public Date getDateF() {
		 return dateF;
	 }
	 
	 public int getHourI() {
		 return dateI.getHours();
	 }
	 
	 public int getHourF() {
		 return dateF.getHours();
	 }
}