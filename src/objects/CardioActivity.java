package objects;

import java.util.Date;

/**
 * The object class for cardio activities.
 * 
 * @author Team 5 - Joel Goddard, Matthew Johnstone, Dallas Oliver
 */
public class CardioActivity extends Activity {
	/** The amount of time spent on the activity in minutes. */
	private int timeSpent;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            The name of the activity.
	 * @param date
	 *            The date in which the activity was performed.
	 * @param timeSpent
	 *            The amount of time spent on the activity in minutes.
	 */
	public CardioActivity(String name, Date date, int timeSpent) {
		super(name, date);
		this.setTimeSpent(timeSpent);
	}

	/**
	 * Constructor.
	 */
	public CardioActivity() {
	}

	/**
	 * Returns the amount of time spent on activity.
	 * 
	 * @return the amount of time spent on activity.
	 */
	public int getTimeSpent() {
		return timeSpent;
	}

	/**
	 * Setter for time spent on activity.
	 * 
	 * @param timeSpent
	 *            The revised time spent.
	 */
	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getType() {
		return "CardioActivity";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		String time = "";
		int hours, minutes;
		hours = getTimeSpent() / 60;
		minutes = getTimeSpent() % 60;
		if (minutes < 10) {
			time += hours + ":0" + minutes;
		} else {
			time += hours + ":" + minutes;
		}

		return "Cardio Session:"
		+ "\n    Name: "
		+ this.getName()
		+ "\n    Date: "
		+ (this.getDate().toString()).substring(0, 10)
		+ " "
		+ (this.getDate().toString()).substring(
				(this.getDate().toString()).length() - 4,
				(this.getDate().toString()).length())
				+ "\n    Time Spent: " + time;
	}
}