package xmlaccess;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import objects.Activity;
import objects.CardioActivity;
import objects.StrengthActivity;

public class StaXParser {
	static final String TO = "to";
	static final String FROM = "from";
	static final String HEADING = "heading";
	static final String MESSAGE = "message";
	static final String NOTE = "note";
	
	static final String CARDIOACTIVITY = "CardioActivity";
	static final String NAME = "name";
	static final String DATE = "date";
	static final String TIMESPENT = "timeSpent";
	static final String STRENGTHACTIVITY = "StrengthActivity";
	static final String REPS = "repetitions";
	static final String WEIGHTLIFTED = "weightLifted";
	

	@SuppressWarnings({ "unchecked", "null" })
	public LinkedList<Activity> readConfig(String configFile) {
		List<Activity> activities = new ArrayList<Activity>();
		try {
			// First, create a new XMLInputFactory
			XMLInputFactory inputFactory = XMLInputFactory.newInstance();
			// Setup a new eventReader
			InputStream in = new FileInputStream(configFile);
			XMLEventReader eventReader = inputFactory.createXMLEventReader(in);
			// read the XML document
			Activity activity = null;

			while (eventReader.hasNext()) {
				XMLEvent event = eventReader.nextEvent();
//--
				boolean isCardio = false;
				
				
				
				
				
				
				
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					// If we have an item element, we create a new item
					if (startElement.getName().getLocalPart() == (CARDIOACTIVITY)) {
						activity = new CardioActivity();
						
					}
					if (startElement.getName().getLocalPart() == (STRENGTHACTIVITY)) {
						activity = new StrengthActivity();
						
					}
					
					if(activity instanceof StrengthActivity){
						if (event.asStartElement().getName().getLocalPart()
								.equals(NAME)) {
							event = eventReader.nextEvent();
							activity.setName(event.asCharacters().getData());
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(DATE)) {
							event = eventReader.nextEvent();
							//TODO dateformatexception
							activity.setDate(new Date(Long.parseLong(event.asCharacters().getData())));
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(REPS)) {
							event = eventReader.nextEvent();
							//TODO numberformatexception
							((StrengthActivity) activity).setRepetitions(Integer.parseInt(event.asCharacters().getData()));
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(WEIGHTLIFTED)) {
							event = eventReader.nextEvent();
							//TODO numberformatexception
							((StrengthActivity) activity).setWeightLifted(Integer.parseInt(event.asCharacters().getData()));
							continue;
						}
					}

					
					if(activity instanceof CardioActivity){
						if (event.asStartElement().getName().getLocalPart()
								.equals(NAME)) {
							event = eventReader.nextEvent();
							activity.setName(event.asCharacters().getData());
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(DATE)) {
							event = eventReader.nextEvent();
							//TODO dateformatexception
							activity.setDate(new Date(Long.parseLong(event.asCharacters().getData())));
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(TIMESPENT)) {
							event = eventReader.nextEvent();
							//TODO dateformatexception
							((CardioActivity) activity).setTimeSpent(Integer.parseInt(event.asCharacters().getData()));
							continue;
						}
						
						
					}

				}
				// If we reach the end of an item element, we add it to the list
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (CARDIOACTIVITY)
							||endElement.getName().getLocalPart() == (STRENGTHACTIVITY)) {
						activities.add(activity);
					}
				}
			
//--
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return activities;
	}

}