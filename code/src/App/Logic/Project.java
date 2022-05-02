package App.Logic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import OldLogic.*;

public class Project {

	private String name;
	private String dateI;
	private String dateF;
	private Participant creator;
	private ArrayList<Activity> activities;
	static HashMap<String,Participant> participants = new HashMap<String,Participant>();
	private int ID;
	//public final static SimpleDateFormat formato=new SimpleDateFormat("dd/HH/mm" );
	//Constructor
	public Project(String name, String dateI, String dateF, Participant creator, int ID) {
		this.name = name;
		this.dateI = dateI;
		this.dateF = dateF;
		this.creator = creator;
		this.ID = ID;
		this.activities = new ArrayList<Activity>();
		this.participants = new HashMap<String,Participant>();
		addParticipant(creator);
	}
	
	public String getNombre(){return this.name;}
	public void setNombre(String name){this.name = name;}
	
	public void addParticipant(Participant participant) {
		participants.put(participant.getCorreo(),participant);
	}
	
	public void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	public int getSize(){
		return activities.size();
	}
	
	public int getID() {
		return ID;
	}
	
	public boolean containsParticipant(Participant participant) {
		return participants.containsKey(participant.getCorreo());
	}
}