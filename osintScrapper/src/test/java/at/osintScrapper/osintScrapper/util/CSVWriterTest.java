package at.osintScrapper.osintScrapper.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import at.osintScrapper.osintScrapper.model.Person;
import junit.framework.TestCase;

public class CSVWriterTest extends TestCase {

	CSVWriter csvWriter;
	List<Person> personList;
	String searchString;
	String path;
	
	@Before
	public void setup() {
		System.out.println("before");
		personList = new ArrayList<>();
		
		Person p = new Person();
		p.setName("Julia Klampfl");
		p.setEducation("Maturaschule Dr. Rampitsch");
		p.setLivingPlace(null);
		p.setLivingPlace("Wollsdorf Leder");
		p.setPartner("Daniel Kaufmann");
		p.addMusicArtist("Sido");
		p.addMusicArtist("Deichkind");
		p.addFriend("Liv Marie");
		p.addFriend("Denise Passler");
		
		personList.add(p);
		
		Properties prop = new Properties();
		InputStream input = null;
		
		// load a properties file
		try {
			input = new FileInputStream("D:\\settings.properties");
			prop.load(input);
			path = prop.getProperty("outputPath");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchString = "wollsdorf%20leder";
	}	
	
	@Test
	public void testCSVWriter() {
		
		
		System.out.println("before");
		personList = new ArrayList<>();
		
		Person p = new Person();
		p.setName("Julia Klampfl");
		p.setEducation("Maturaschule Dr. Rampitsch");
		p.setLivingPlace(null);
		p.setLivingPlace("Wollsdorf Leder");
		p.setPartner("Daniel Kaufmann");
		p.addMusicArtist("Sido");
		p.addMusicArtist("Deichkind");
		p.addFriend("Liv Marie");
		p.addFriend("Denise Passler");
		
		personList.add(p);
		
		Properties prop = new Properties();
		InputStream input = null;
		
		// load a properties file
		try {
			input = new FileInputStream("D:\\settings.properties");
			prop.load(input);
			path = prop.getProperty("outputPath");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		searchString = "wollsdorf%20leder";
		
		
		
		
		
		
		csvWriter = new CSVWriter();
		System.out.println(path);
		System.out.println(searchString);
		System.out.println(personList.size());
		csvWriter.writeCsvFile(personList, path, searchString);
	}
	
}
