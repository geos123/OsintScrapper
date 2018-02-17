package at.osintScrapper.osintScrapper.Controller;

import java.util.Scanner;

public class PersonSelector implements SearchSelector {

	@Override
	public String getSearchString() {
		Scanner keyboardScanner = new Scanner(System.in);
		System.out.println("Person's Name: ");
		
		String nameInput = keyboardScanner.nextLine();
		
		keyboardScanner.close();
		
		return nameInput.replaceAll(" ", "%20");
	}

}
