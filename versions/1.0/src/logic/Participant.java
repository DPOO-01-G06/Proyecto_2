package logic;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Participant implements Serializable{
		//Atributos
		private String nombre;
		private String correo;
		private String contrasena;
		private String reportFileName;
		private ArrayList<Activity> activities;
		private int ID;
		private String reportText = "";
		
		private long totalTime = 0;
		private long avgTime;
		private HashMap<String,Long> dayStats;
		//Constructor
		public Participant(String pCorreo, String nombre, String contrasena) {
			this.nombre=nombre;
			this.contrasena=contrasena;
			this.correo=pCorreo;
			this.ID = 0;
			this.reportFileName = correo + "_" + nombre + "_" + ID;
			this.activities = new ArrayList<Activity>();
			this.dayStats = new HashMap<String,Long>();
		}
		
		public String getContrasena() {
			return contrasena;
		}

		public void setContrasena(String contrasena) {
			this.contrasena = contrasena;
		}

		public String getReportFileName() {
			return reportFileName;
		}

		public void setReportFileName(String reportFileName) {
			this.reportFileName = reportFileName;
		}

		public ArrayList<Activity> getActivities() {
			return activities;
		}

		public void setActivities(ArrayList<Activity> activities) {
			this.activities = activities;
		}

		public int getID() {
			return ID;
		}

		public void setID(int iD) {
			ID = iD;
		}

		public String getReportText() {
			return reportText;
		}

		public void setReportText(String reportText) {
			this.reportText = reportText;
		}

		public long getTotalTime() {
			return totalTime;
		}

		public void setTotalTime(long totalTime) {
			this.totalTime = totalTime;
		}

		public long getAvgTime() {
			return avgTime;
		}

		public void setAvgTime(long avgTime) {
			this.avgTime = avgTime;
		}

		public HashMap<String, Long> getDayStats() {
			return dayStats;
		}

		public void setDayStats(HashMap<String, Long> dayStats) {
			this.dayStats = dayStats;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		public String getNombre() {
			return nombre;
		}
		public String getCorreo() {
			return correo;
		}
		
		public Activity findActivity(int ID) {
			for (Activity i: activities) {
				if (i.getID() == ID) {
					return i;
				}
			}
			return null;
		}
		
		public String createReport() {
			String dateI;
			String dateF;
			int hourI;
			int hourF;
			long duration;
			int restantI;
			long valueI;
			int restantF;
			long valueF;
			
			for (Activity i : activities) {
				
				
				
				totalTime += i.getTime();
				dateI = dateToString(i.getDateI());
				dateF = dateToString(i.getDateF());
				hourI = i.getHourI();
				hourF = i.getHourF();
				duration = i.getTime()*60;
				restantI = 24-hourI;
				if (duration >= restantI) {
					valueI = restantI;
				} else {valueI = duration;}
				restantF = 24-hourF;
				if (duration >= restantF) {
					valueF = restantF;
				} else {valueF = duration;}
				
				if (dayStats.containsKey(dateF)) {
					dayStats.put(dateF,dayStats.get(dateF)+valueF);
				} else {
					dayStats.put(dateF,valueF);
				}
				
				if (dayStats.containsKey(dateI)) {
					dayStats.put(dateI,dayStats.get(dateI)+valueI);
				} else {
					dayStats.put(dateI,valueI);
				}
			}
			
			avgTime = totalTime/activities.size();
			
			reportText += "NAME: " + nombre + "\nEMAIL: " + correo + "\n# OF ACTIVITIES DONE: " + activities.size();
			reportText += "\nTOTAL TIME: " + totalTime + "\nAVERAGE TIME FOR ACTIVITY: " + avgTime + "\nACTIVITIES:\n";
			
			for (Activity i: activities) {
				reportText += i.getTitle() + "\n" + i.getType() + "\n" + i.getID() + "\n" + i.getProjectID();
			}
			
			reportText += "\nTIME SPENT EACH DAY:\n";
			
			for (String i : dayStats.keySet()) {
				reportText += i + "   " + dayStats.get(i) + "\n";
			}
			
			return reportText;
		}
		
		public String dateToString(Date date) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
			String strDate = dateFormat.format(date);
			return strDate;
		}
		
		public void addActivity(Activity activity) {
			activities.add(activity);
		}
}
