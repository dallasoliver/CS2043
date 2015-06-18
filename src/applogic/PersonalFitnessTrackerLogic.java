package applogic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Date;
import objects.Activity;
import objects.CardioActivity;
import objects.StrengthActivity;

/**
 * Performs the app logic for the Personal Fitness Tracker application
 * 
 * @author Team 5 - Joel Goddard, Matthew Johnstone, Dallas Oliver
 */
public class PersonalFitnessTrackerLogic {
	/** The list of activities. */
	private LinkedList<Activity> activities;
	/** The name of the XML file in which data is stored/read. */
	private String configFile;

	/**
	 * Constructor.
	 * 
	 * @param configFile
	 *            The name of the XML file in which data may be read/stored.
	 */
	public PersonalFitnessTrackerLogic(String configFile) {
		this.configFile = configFile;
		activities = ActivityParser.readConfig(configFile);
	}

	/**
	 * Adds cardio activity to the activity list and updates XML file.
	 * 
	 * @param name
	 *            The name of the activity.
	 * @param date
	 *            The date of when the activity was performed.
	 * @param timeSpent
	 *            The amount of time spent in doing the activity.
	 * @throws Exception
	 *             if one of the given parameters is not in the proper format.
	 */
	public void addCardioActivity(String name, Date date, String timeSpent)
			throws Exception {
		String errorMessage = "The following errors have occurred:\n";
		boolean isError = false;

		// Performs check for any errors in input.
		if (name.isEmpty()) {
			errorMessage += "The activity name must be specified.\n";
			isError = true;
		}
		Date now = new Date();
		now.setTime(System.currentTimeMillis());
		if (date == null || date.after(now)) {
			errorMessage += "The date must be on or before today.\n";
			isError = true;
		}
		int time = 0;
		if (timeSpent.isEmpty()) {
			errorMessage += "The duration of the activity must be specified\n";
			isError = true;
		} else {
			try {
				time = Integer.parseInt(timeSpent);
			} catch (NumberFormatException e) {
				errorMessage += "The time spent must be numeric.\n";
				isError = true;
			}
			if (time < 0) {
				errorMessage += "The time spent must be above zero.";
				isError = true;
			}
		}

		if (isError) {
			throw new Exception(errorMessage);
		}

		Activity newActivity = new CardioActivity(name, date, time);
		activities.add(newActivity);
		saveXML();
	}

	/**
	 * Adds strength activity to the activity list and updates the XML file.
	 * 
	 * @param name
	 *            The name of the activity.
	 * @param date
	 *            The date of when the activity was performed.
	 * @param weights
	 *            The amount of weights lifted in pounds.
	 * @param reps
	 *            The amount of repetitions performed.
	 * @throws Exception
	 *             if one of the given parameters is not in the proper format.
	 */
	public void addStrengthActivity(String name, Date date, String weights,
			String reps) throws Exception {
		String errorMessage = "The following errors have occurred:\n";
		boolean isError = false;

		// Performs check for any errors in input.
		if (name.isEmpty()) {
			errorMessage += "The activity name must be specified.\n";
			isError = true;
		}
		Date now = new Date();
		now.setTime(System.currentTimeMillis());
		if (date == null || date.after(now)) {
			errorMessage += "The date must be on or before today.\n";
			isError = true;
		}
		int repetitions = 0;
		if (reps.isEmpty()) {
			errorMessage += "The number of repetitions must be specified.\n";
			isError = true;
		} else {
			try {
				repetitions = Integer.parseInt(reps);
			} catch (NumberFormatException e) {
				errorMessage += "The number of repetitions must be numeric";
				isError = true;
			}
			if (repetitions < 0) {
				errorMessage += "The number of repetitions must be above zero.";
				isError = true;
			}
		}
		int weightsLifted = 0;
		if (weights.isEmpty()) {
			errorMessage += "The amount of weight lifted must be specified.\n";
			isError = true;
		} else {
			try {
				weightsLifted = Integer.parseInt(weights);
			} catch (NumberFormatException e) {
				errorMessage += "The amount of weight lifted must be numeric.";
				isError = true;
			}
			if (weightsLifted < 0) {
				errorMessage += "The amount of weight lifted must be above zero.";
				isError = true;
			}
		}

		if (isError) {
			throw new Exception(errorMessage);
		}

		Activity newActivity = new StrengthActivity(name, date, weightsLifted,
				repetitions);
		activities.add(newActivity);
		saveXML();
	}

	/**
	 * Saves the list of activities to an XML file.
	 * 
	 * @throws Exception
	 *             if any errors occur during file save.
	 */
	private void saveXML() throws Exception {
		ActivityWriter.saveConfig(activities, configFile);
	}

	/**
	 * Searches through the activity list for activities that match the given
	 * date.
	 * 
	 * @param date
	 *            The date in which we're looking for activities.
	 * @return The toString information for each of the activities that match.
	 * @throws Exception
	 *             if the given parameter is not in the proper format.
	 */
	public String searchByDate(Date date) throws Exception {
		String errorMessage = "The following errors have occured:\n";
		boolean isError = false;

		// Performs check for any errors in input.
		Date now = new Date();
		now.setTime(System.currentTimeMillis());
		if (date == null) {
			return "";
		}
		if (date.after(now)) {
			errorMessage += "The date must be on or before today.\n";
			isError = true;
		}

		if (isError) {
			throw new Exception(errorMessage);
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

	/**
	 * Goes through a list of activities and generates a String containing the
	 * toString information.
	 * 
	 * @param activities
	 *            The given list of activities in which we're parsing.
	 * @return The toString information for all activities in the given list.
	 */
	private String display(LinkedList<Activity> activities) {
		String ret = "";
		Iterator<Activity> it = activities.iterator();
		while (it.hasNext()) {
			Activity act = it.next();
			ret += act.toString() + "\n";
		}
		if (ret.isEmpty()) {
			ret = "There are no recorded workout sessions for this date.";
		}
		return ret;
	}

}