package objects;

import java.util.Date;

public class Activity {
	private Date date;
	private String name;
	
	public Activity(String name, Date date){
		this.date = date;
		this.name = name;
		
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
