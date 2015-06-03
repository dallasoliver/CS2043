package xmlaccess;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import objects.Activity;
import objects.CardioActivity;
import objects.StrengthActivity;

public class TestWrite {

  public static void main(String[] args) {
    LinkedList<Activity> activities = new LinkedList<Activity>();
    
    for(int i = 0; i < 11; i++){
    	if(i % 2 == 0){
    		activities.add(new CardioActivity((""+ i), new Date(2*i*10), 3*i));
    	}
    	else
    		activities.add(new StrengthActivity(""+i, new Date(3*i*100), i*3, i*10));
    }
    
	StaxWriter configFile = new StaxWriter();
    configFile.setFile("activities.xml");
    try {
      configFile.saveConfig(activities);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
} 
