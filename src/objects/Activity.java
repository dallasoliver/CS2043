package objects;

import java.util.Date;

/**
 * The object definition class for Activity objects.
 * 
 * @author Team 5 - Joel Goddard, Matthew Johnstone, Dallas Oliver
 */
public abstract class Activity {
	/** The date in which the activity was performed. */
	private Date date;
	/** The name of the activity. */
	private String name;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            The name of the activity.
	 * @param date
	 *            The date in which the activity was performed.
	 */
	public Activity(String name, Date date) {
		this.date = date;
		this.name = name;
	}

	/**
	 * Constructor.
	 */
	public Activity() {
	}

	/**
	 * Getter for the date in which the activity was performed.
	 * 
	 * @return the date in which the activity was performed.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Setter for the date
	 * 
	 * @param date
	 *            The date in which the activity was performed.
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * Getter for the activity name.
	 * 
	 * @return the name of the activity.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for the activity name.
	 * 
	 * @param name
	 *            The name of the activity.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Generates a String that contains the information for the Activity object.
	 * 
	 * @return The data stored in the Activity object.
	 */
	public abstract String toString();

	/**
	 * Getter for the type of Activity object.
	 * 
	 * @return the type of Activity object.
	 */
	public abstract String getType();
}