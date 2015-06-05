package applogic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Date;

import objects.Activity;
import objects.CardioActivity;
import objects.StrengthActivity;

public class PersonalFitnessTrackerLogic {
	private LinkedList<Activity> activities;
	private String configFile;
	
	public PersonalFitnessTrackerLogic(String configFile){
		this.configFile = configFile;
		activities = ActivityParser.readConfig(configFile);
	}
	public void addCardioActivity(String name, Date date, String timeSpent) throws Exception{
		Date now = new Date();
		now.setTime(System.currentTimeMillis());
		if(name.isEmpty()){
			throw new Exception("You must enter an activity name.");
		}
		if(date.after(now) || date == null){
			throw new Exception("You must choose a date on or before today.");
		}
		if(timeSpent.isEmpty()){
			throw new Exception("You must specify how long the activity took.");
		}
		int time;
		try{
			time = Integer.parseInt(timeSpent);
		}
		catch(NumberFormatException e){
			throw new Exception("You must enter numeric characters for time spent.");
		}
		Activity newActivity = new CardioActivity(name, date, time);
		activities.add(newActivity);
		saveXML();
	}
	public void addStrengthActivity(String name, Date date, String weights, String reps) throws Exception{
		Date now = new Date();
		now.setTime(System.currentTimeMillis());
		if(name.isEmpty()){
			throw new Exception("You must enter an activity name.");
		}
		if(date.after(now)){
			throw new Exception("You must choose a date on or before today.");
		}
		int repetitions;
		int weightsLifted;
		try{
			repetitions = Integer.parseInt(reps);
		}
		catch(NumberFormatException e){
			throw new Exception("You must enter numeric characters for repetitions");
		}
		try{
			weightsLifted = Integer.parseInt(weights);
		}
		catch(NumberFormatException e){
			throw new Exception("You must enter numeric characters for weights lifted");
		}
		
		Activity newActivity = new StrengthActivity(name, date, weightsLifted, repetitions);
		activities.add(newActivity);
		saveXML();
	}
	private void saveXML() throws Exception{
		ActivityWriter.saveConfig(activities, configFile);
	}
	public String searchByDate(Date date){
		if(date == null){
			return "";
		}
		LinkedList<Activity> resultsList = new LinkedList<Activity>();
		Iterator<Activity> it = activities.iterator();
		while(it.hasNext()){
			Activity act = it.next();
			if(act.getDate().equals(date)){
				resultsList.add(act);
			}
		}
		return display(resultsList);
	}
	private String display(LinkedList<Activity> activities){
		String ret = "";
		Iterator<Activity> it = activities.iterator();
		while(it.hasNext()){
			Activity act = it.next();
			ret += act.toString() + "\n";
		}
		if(ret.isEmpty()){
			ret = "There are no recorded sessions for this date.";
		}
		return ret;
	}
	
}
