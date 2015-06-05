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
		int hours, minutes;
		hours = getTimeSpent() / 60;
		minutes = getTimeSpent() % 60;
		
		return "Cardio Session:"
				+ "\n    Name: "
				+ this.getName()
				+ "\n    Date: "
				+ (this.getDate().toString()).substring(0, 10)
				+ " "
				+ (this.getDate().toString()).substring(
						(this.getDate().toString()).length() - 4,
						(this.getDate().toString()).length())
				+ "\n    Time Spent: " + hours + ":" + minutes;
	}
	
	

}
