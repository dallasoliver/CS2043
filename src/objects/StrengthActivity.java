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

}
