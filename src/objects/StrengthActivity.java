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
		// TODO Auto-generated method stub
		return null;
	}

	

}
