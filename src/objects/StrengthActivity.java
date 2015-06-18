package objects;

import java.util.Date;

/**
 * The object class for strength activities.
 * 
 * @author Team 5 - Joel Goddard, Matthew Johnstone, Dallas Oliver
 */
public class StrengthActivity extends Activity {
	/** The amount of weights lifted in pounds. */
	private int weightLifted;
	/** The amount of repetitions performed. */
	private int repetitions;

	/**
	 * Constructor.
	 * 
	 * @param name
	 *            The name of the activity.
	 * @param date
	 *            The date in which the activity was performed.
	 * @param weightLifted
	 *            The amount of weights lifted in pounds.
	 * @param repetitions
	 *            The amount of repetitions performed.
	 */
	public StrengthActivity(String name, Date date, int weightLifted,
			int repetitions) {
		super(name, date);
		this.weightLifted = weightLifted;
		this.repetitions = repetitions;
	}

	/**
	 * Constructor.
	 */
	public StrengthActivity() {
	}

	/**
	 * Getter for the amount of weights lifted in pounds.
	 * 
	 * @return the amount of weights lifted in pounds.
	 */
	public int getWeightLifted() {
		return weightLifted;
	}

	/**
	 * Setter for weights lifted.
	 * 
	 * @param weightLifted
	 *            The amount of weights lifted in pounds.
	 */
	public void setWeightLifted(int weightLifted) {
		this.weightLifted = weightLifted;
	}

	/**
	 * Getter for the amount of repetitions.
	 * 
	 * @return the amount of repetitions.
	 */
	public int getRepetitions() {
		return repetitions;
	}

	/**
	 * Setter for repetitions.
	 * 
	 * @param repetitions
	 *            The amount of repetitions performed.
	 */
	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getType() {
		return "StrengthActivity";
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return "Strength Training Session:"
				+ "\n    Name: "
				+ this.getName()
				+ "\n    Date: "
				+ (this.getDate().toString()).substring(0, 10)
				+ " "
				+ (this.getDate().toString()).substring(
						(this.getDate().toString()).length() - 4,
						(this.getDate().toString()).length())
						+ "\n    Weight Lifted: " + this.getWeightLifted()
						+ "lbs\n    Repetitions: " + this.getRepetitions();
	}
}