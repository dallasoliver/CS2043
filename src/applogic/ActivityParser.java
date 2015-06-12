package applogic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import objects.Activity;
import objects.CardioActivity;
import objects.StrengthActivity;

public class ActivityParser {
	static final String CARDIOACTIVITY = "CardioActivity";
	static final String NAME = "name";
	static final String DATE = "date";
	static final String TIMESPENT = "timeSpent";
	static final String STRENGTHACTIVITY = "StrengthActivity";
	static final String REPS = "repetitions";
	static final String WEIGHTLIFTED = "weightLifted";

	public static LinkedList<Activity> readConfig(String configFile) {
		LinkedList<Activity> activities = new LinkedList<Activity>();
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
				
				if (event.isStartElement()) {
					StartElement startElement = event.asStartElement();
					if (startElement.getName().getLocalPart() == (CARDIOACTIVITY)) {
						activity = new CardioActivity();

					}
					if (startElement.getName().getLocalPart() == (STRENGTHACTIVITY)) {
						activity = new StrengthActivity();

					}

					if (activity instanceof StrengthActivity) {
						if (event.asStartElement().getName().getLocalPart()
								.equals(NAME)) {
							event = eventReader.nextEvent();
							activity.setName(event.asCharacters().getData());
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(DATE)) {
							event = eventReader.nextEvent();
							activity.setDate(new Date(Long.parseLong(event
									.asCharacters().getData())));
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(REPS)) {
							event = eventReader.nextEvent();
							((StrengthActivity) activity)
									.setRepetitions(Integer.parseInt(event
											.asCharacters().getData()));
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(WEIGHTLIFTED)) {
							event = eventReader.nextEvent();
							((StrengthActivity) activity)
									.setWeightLifted(Integer.parseInt(event
											.asCharacters().getData()));
							continue;
						}
					}

					if (activity instanceof CardioActivity) {
						if (event.asStartElement().getName().getLocalPart()
								.equals(NAME)) {
							event = eventReader.nextEvent();
							activity.setName(event.asCharacters().getData());
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(DATE)) {
							event = eventReader.nextEvent();
							activity.setDate(new Date(Long.parseLong(event
									.asCharacters().getData())));
							continue;
						}
						if (event.asStartElement().getName().getLocalPart()
								.equals(TIMESPENT)) {
							event = eventReader.nextEvent();
							((CardioActivity) activity).setTimeSpent(Integer
									.parseInt(event.asCharacters().getData()));
							continue;
						}
					}
				}
				if (event.isEndElement()) {
					EndElement endElement = event.asEndElement();
					if (endElement.getName().getLocalPart() == (CARDIOACTIVITY)
							|| endElement.getName().getLocalPart() == (STRENGTHACTIVITY)) {
						activities.add(activity);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		return activities;
	}
}