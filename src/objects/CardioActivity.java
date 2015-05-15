package objects;

import java.util.Date;

public class CardioActivity extends Activity{
	private int timeSpent;
	
	public CardioActivity(String name, Date date, int timeSpent) {
		super(name, date);
		this.setTimeSpent(timeSpent);
		
	}

	public CardioActivity() {
		
	}

	@Override
	public String getType() {
		return "CardioActivity";
	}

	public int getTimeSpent() {
		return timeSpent;
	}

	public void setTimeSpent(int timeSpent) {
		this.timeSpent = timeSpent;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getType() + this.getTimeSpent() + this.getDate();
	}
	
	

}
