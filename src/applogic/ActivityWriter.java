package applogic;

import java.io.FileOutputStream;
import java.util.LinkedList;




import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import java.util.ListIterator;

import objects.*;
public class ActivityWriter { 
  
  public static void saveConfig(LinkedList<Activity> activities, String configFile) throws Exception {
	    // create an XMLOutputFactory
	    XMLOutputFactory outputFactory = XMLOutputFactory.newInstance();

	    // create XMLEventWriter
	    XMLEventWriter eventWriter = outputFactory
	        .createXMLEventWriter(new FileOutputStream(configFile));

	    // create an EventFactory
	    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	    XMLEvent end = eventFactory.createDTD("\n");

	    // create and write Start Tag
	    StartDocument startDocument = eventFactory.createStartDocument();
	    eventWriter.add(startDocument);
	    eventWriter.add(end);
	    ListIterator iterator = (ListIterator) activities.iterator();
	    openRootNode(eventWriter);
		while(iterator.hasNext()){	
			Activity actIn = (Activity) iterator.next();
			System.out.println("enetered loop");
			if(actIn.getType().equals("StrengthActivity")){
				
			    StrengthActivity strengthActIn = (StrengthActivity)actIn;
				// create config open tag
			    StartElement configStartElement = eventFactory.createStartElement("",
			        "", "StrengthActivity");
			    eventWriter.add(configStartElement);
			    eventWriter.add(end);
		
			    // Write the different nodes
			    createNode(eventWriter, "date", ""+strengthActIn.getDate().getTime());
			    createNode(eventWriter, "name", strengthActIn.getName());
			    createNode(eventWriter, "weightLifted", (""+(strengthActIn.getWeightLifted())));
			    createNode(eventWriter, "repetitions", (""+strengthActIn.getRepetitions()));
		
			    eventWriter.add(eventFactory.createEndElement("", "", "StrengthActivity"));
			    eventWriter.add(end);
			   
			}
			
			if(actIn.getType().equals("CardioActivity")){
			    CardioActivity cardioActIn = (CardioActivity)actIn;
				// create config open tag
			    StartElement configStartElement = eventFactory.createStartElement("",
			        "", "CardioActivity");
			    eventWriter.add(configStartElement);
			    eventWriter.add(end);
		
			    // Write the different nodes
			    createNode(eventWriter, "date", ""+cardioActIn.getDate().getTime());
			    createNode(eventWriter, "name", cardioActIn.getName());
			    createNode(eventWriter, "timeSpent", (""+cardioActIn.getTimeSpent()) );
			   
		
			    eventWriter.add(eventFactory.createEndElement("", "", "CardioActivity"));
			    eventWriter.add(end);
			    
			}
		}
		closeRootNode(eventWriter);
		eventWriter.add(eventFactory.createEndDocument());
	    eventWriter.close();
	  }
  private static void createNode(XMLEventWriter eventWriter, String name,
      String value) throws XMLStreamException {

    XMLEventFactory eventFactory = XMLEventFactory.newInstance();
    XMLEvent end = eventFactory.createDTD("\n");
    XMLEvent tab = eventFactory.createDTD("\t");
    // create Start node
    StartElement sElement = eventFactory.createStartElement("", "", name);
    eventWriter.add(tab);
    eventWriter.add(sElement);
    // create Content
    Characters characters = eventFactory.createCharacters(value);
    eventWriter.add(characters);
    // create End node
    EndElement eElement = eventFactory.createEndElement("", "", name);
    eventWriter.add(eElement);
    eventWriter.add(end);
    System.out.println("created node");

  }
  
  
  private static void openRootNode(XMLEventWriter eventWriter) throws XMLStreamException{
	  XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	  XMLEvent end = eventFactory.createSpace("\n");
	   
	    
	    StartElement sElement = eventFactory.createStartElement("", "", "Activities");
	   
	    eventWriter.add(sElement);
	    eventWriter.add(end);
	    System.out.println("opened root");
  }
  
  private static void closeRootNode(XMLEventWriter eventWriter) throws XMLStreamException{
	  XMLEventFactory eventFactory = XMLEventFactory.newInstance();
	  XMLEvent end = eventFactory.createSpace("\n");
	   
	    
	    EndElement eElement = eventFactory.createEndElement("", "", "Activities");
	    eventWriter.add(eElement);
	    eventWriter.add(end);
	    System.out.println("closed root");
  }

}