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

	public PersonalFitnessTrackerLogic(String configFile) {
		this.configFile = configFile;
		activities = ActivityParser.readConfig(configFile);
	}

	public void addCardioActivity(String name, Date date, String timeSpent)
			throws Exception {
		String errorMessage = "The following errors have occured:\n";
		boolean isError = false;
		Date now = new Date();
		now.setTime(System.currentTimeMillis());
		if (name.isEmpty()) {
			errorMessage += "The activity name may not be blank.\n";
			isError = true;
		}
		if (date == null || date.after(now)) {
			errorMessage += "The date must be on or before today.\n";
			isError = true;
		}
		if (timeSpent.isEmpty()) {
			errorMessage += "The duration of the activity must be specified\n";
			isError = true;
		}
		int time = 0;
		try {
			time = Integer.parseInt(timeSpent);
		} catch (NumberFormatException e) {
			errorMessage += "Only numeric characters may be entered for time spent.\n";
			isError = true;
		}
		if(time < 0){
			errorMessage += "Only positive numbers may be entered for time.";
			isError = true;
		}
		if(isError){
			throw new Exception(errorMessage);
		}
		Activity newActivity = new CardioActivity(name, date, time);
		activities.add(newActivity);
		saveXML();
	}

	public void addStrengthActivity(String name, Date date, String weights,
			String reps) throws Exception {
		String errorMessage = "The following errors have occured:\n";
		boolean isError = false;
		Date now = new Date();
		now.setTime(System.currentTimeMillis());
		if (name.isEmpty()) {
			errorMessage += "The activity name may not be blank.\n";
			isError = true;
		}
		if (date == null || date.after(now)) {
			errorMessage += "The date must be on or before today.\n";
			isError = true;
		}
		int repetitions = 0;
		int weightsLifted = 0;
		try {
			repetitions = Integer.parseInt(reps);
		} catch (NumberFormatException e) {
			errorMessage += "Only numeric characters may be entered for repetitions";
			isError = true;
		}
		if(repetitions < 0){
			errorMessage += "Only positive numbers may be entered for repetitions.";
			isError = true;
		}
		try {
			weightsLifted = Integer.parseInt(weights);
		} catch (NumberFormatException e) {
			errorMessage += "Only numeric characters may be entered for weights lifted.";
			isError = true;
		}
		if(weightsLifted < 0){
			errorMessage += "Only positive numbers may be entered for weights lifted.";
			isError = true;
		}
		if(isError){
			throw new Exception(errorMessage);
		}
		Activity newActivity = new StrengthActivity(name, date, weightsLifted,
				repetitions);
		activities.add(newActivity);
		saveXML();
	}

	private void saveXML() throws Exception {
		ActivityWriter.saveConfig(activities, configFile);
	}

	public String searchByDate(Date date) {
		if (date == null) {
			return "";
		}
		LinkedList<Activity> resultsList = new LinkedList<Activity>();
		Iterator<Activity> it = activities.iterator();
		while (it.hasNext()) {
			Activity act = it.next();
			if (act.getDate().equals(date)) {
				resultsList.add(act);
			}
		}
		return display(resultsList);
	}

	private String display(LinkedList<Activity> activities) {
		String ret = "";
		Iterator<Activity> it = activities.iterator();
		while (it.hasNext()) {
			Activity act = it.next();
			ret += act.toString() + "\n";
		}
		if (ret.isEmpty()) {
			ret = "There are no recorded sessions for this date.";
		}
		return ret;
	}

}