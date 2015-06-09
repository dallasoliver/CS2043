package objects;

import java.util.Date;

public class StrengthActivity extends Activity {

	private int weightLifted;
	private int repetitions;

	public StrengthActivity(String name, Date date, int weightLifted, int repetitions) {
		super(name, date);
		this.weightLifted = weightLifted;
		this.repetitions = repetitions;
	}

	public StrengthActivity() {
	}

	public int getWeightLifted() {
		return weightLifted;
	}

	public void setWeightLifted(int weightLifted) {
		this.weightLifted = weightLifted;
	}

	public int getRepetitions() {
		return repetitions;
	}

	public void setRepetitions(int repetitions) {
		this.repetitions = repetitions;
	}

	@Override
	public String getType() {
		return "StrengthActivity";
	}

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