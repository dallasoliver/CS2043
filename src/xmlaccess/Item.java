package xmlaccess;


public class Item {
  private String to; 
  private String from;
  private String heading;
  private String message;
 
  public String getTo() {
    return to;
  }
    public void setTo(String to) {
    this.to = to;
  }

  public String getFrom() {
    return from;
  }
public void setFrom(String from) {
    this.from = from;
  }

 public String getHeading() {
    return heading;
  }
  
  public void setHeading(String heading) {
    this.heading = heading;
  }


  public String getMessage() {
    return message;
  }
 public void setMessage(String message) {
    this.message = message;
  }


 
 

  @Override
  public String toString() {
    return "Item [to=" + to + ", from=" + from + ", heading="
        + heading + ", message=" + message +  "]";
  }
} 
