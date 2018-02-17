package at.osintScrapper.osintScrapper.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import at.osintScrapper.osintScrapper.model.Person;

public class CSVWriter {
	
	private static final String COLUMN_DELIMITER = ";";
	private static final String MULTIPLE_ITEMS_DELIMITER = ",";
	private static final String NEW_LINE_SEPERATOR = "\n";
	private static final String FILE_HEADER = "name;education;living_place;work_place;partner;friends_names;music_artists";    
    
	FileWriter fileWriter;
	
	public void writeCsvFile(List<Person> personList, String path, String searchString) {
		
		String fileName = searchString + ".csv";
		
		File file = new File(path + "\\" + fileName);
		
		int counter = 0;
		
		while(file.exists()) {
			counter++;
			fileName = searchString + "_" + counter + ".csv";			
			file = new File(path + "\\" + fileName);			
		}
		
		
		try {
			fileWriter = new FileWriter(file);
			
			fileWriter.append(FILE_HEADER);
			fileWriter.append(NEW_LINE_SEPERATOR);
			
			for(Person p : personList) {
				int friendsCounter = 0;
				int musicCounter = 0;
				
				fileWriter.append(p.getName());
				fileWriter.append(COLUMN_DELIMITER);
				
				fileWriter.append(p.getEducation());
				fileWriter.append(COLUMN_DELIMITER);
				
				fileWriter.append(p.getLivingPlace());
				fileWriter.append(COLUMN_DELIMITER);
				
				fileWriter.append(p.getWorkPlace());
				fileWriter.append(COLUMN_DELIMITER);
				
				fileWriter.append(p.getPartner());
				fileWriter.append(COLUMN_DELIMITER);
				
				for(String s : p.getFriends()) {
					if(friendsCounter > 0) {
						fileWriter.append(MULTIPLE_ITEMS_DELIMITER);
					}
					fileWriter.append(s);
					friendsCounter++;					
				}
				fileWriter.append(COLUMN_DELIMITER);
				
				for(String s: p.getMusic()) {
					if(musicCounter > 0) {
						fileWriter.append(MULTIPLE_ITEMS_DELIMITER);
					}
					fileWriter.append(s);
					musicCounter++;
				}
				fileWriter.append(NEW_LINE_SEPERATOR);
				
				
			}
			
		} catch (IOException e) {
			System.out.println("Error writing to file; Check file permissions");
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error writing to file; Check file permissions");
			}
			
		}
		
	}

		 
}
