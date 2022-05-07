package logic;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


public class Project implements Serializable{

	private String name;
	private String dateI;
	private String dateF;
	private String tipo;
	private String descripcion;
	private Participant creator;
	private ArrayList<Activity> activities;
	
	private int ID;
	//public final static SimpleDateFormat formato=new SimpleDateFormat("dd/HH/mm" );
	//Constructor
	public Project(String name, String dateI, String dateF, Participant creator, int ID, String tipo, String descripcion) {
		this.name = name;
		this.dateI = dateI;
		this.dateF = dateF;
		this.creator = creator;
		this.ID = ID;
		this.tipo=tipo;
		this.descripcion=descripcion;
		this.activities = new ArrayList<Activity>();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDateI() {
		return dateI;
	}

	public void setDateI(String dateI) {
		this.dateI = dateI;
	}

	public String getDateF() {
		return dateF;
	}

	public void setDateF(String dateF) {
		this.dateF = dateF;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Participant getCreator() {
		return creator;
	}

	public void setCreator(Participant creator) {
		this.creator = creator;
	}

	public ArrayList<Activity> getActivities() {
		return activities;
	}

	public void setActivities(ArrayList<Activity> activities) {
		this.activities = activities;
	}

	

	public void setID(int iD) {
		ID = iD;
	}

	public String getNombre(){return this.name;}
	public void setNombre(String name){this.name = name;}
	
	
	
	public void addActivity(Activity activity) {
		activities.add(activity);
	}
	
	public int getSize(){
		return activities.size();
	}
	
	public int getID() {
		return ID;
	}
	
	public ArrayList<Activity> getactivities()
	{
		return activities;
	}
	
}