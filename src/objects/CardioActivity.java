package objects;

import java.util.Date;

public class CardioActivity extends Activity{
	private int timeSpent;
	public CardioActivity(String name, Date date, int timeSpent) {
		super(name, date);
		this.timeSpent = timeSpent;
	}

}
