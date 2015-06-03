package xmlaccess;

import java.util.List;

import objects.*;



public class TestRead {
  public static void main(String args[]) {
    StaXParser read = new StaXParser();
    List<Activity> readConfig = read.readConfig("activities.xml");
    for (Activity activity : readConfig) {
      System.out.println(activity.getName());
    }
  }
} 
