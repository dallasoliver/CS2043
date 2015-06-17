package test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.LinkedList;

import objects.Activity;
import objects.CardioActivity;

import org.junit.Before;
import org.junit.Test;

import applogic.ActivityParser;
import applogic.ActivityWriter;

/*
 * Test of the Activity Storage classes.
 */

public class ActivityStoreTest {
	private LinkedList<Activity> activities;
	private String fileName;
	private String invalidFileName;

	@Before
	public void setUp() throws Exception {
		activities = new LinkedList<Activity>();
		fileName = "test_file.xml";
		invalidFileName = "non/existent/path.xml";
		activities.add(new CardioActivity("Soccer", new Date(), 61));
	}

	@Test
	public void test() {
	}

	@Test
	public void testSave() {
		try {
			ActivityWriter.saveConfig(activities, fileName);
			ActivityParser.readConfig(fileName);

		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void testSaveInvalidfileName() {
		try {
			ActivityWriter.saveConfig(activities, invalidFileName);
			ActivityParser.readConfig(invalidFileName);
			fail("no exception thrown");
		} catch (Exception e) {
			// pass
		}
	}

	@Test
	public void testRead() {
		try {
			ActivityWriter.saveConfig(activities, fileName);
		} catch (Exception e) {
			fail("save failed");
		}
		LinkedList<Activity> readList = ActivityParser.readConfig(fileName);
		assertEquals(readList.size(), 1);
	}

	@Test
	public void testReadInvalidFileName() {
		LinkedList<Activity> readList = ActivityParser
				.readConfig(invalidFileName);
		assertTrue(readList.isEmpty());
	}
}
