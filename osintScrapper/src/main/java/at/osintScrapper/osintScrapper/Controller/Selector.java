package at.osintScrapper.osintScrapper.Controller;

import java.util.Scanner;

import at.osintScrapper.osintScrapper.model.ScrappingMode;

/**
 * Handler class for user selections 
 *  
 */

public class Selector {

	public ScrappingMode selectMode() {
		Scanner keyboardScanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("Select mode:");
			System.out.println("a: Search by company name");
			System.out.println("b: Search by persons name");
			System.out.println("c: quit");
			
			String modeString = keyboardScanner.nextLine();

			if (modeString.equals("a")) {
				System.out.println("a");
				return ScrappingMode.COMPANY;
			} else if (modeString.equals("b")) {
				System.out.println("b");
				return ScrappingMode.PERSON;
			} else if (modeString.equals("c")) {
				System.out.println("c");
				System.exit(0);
				break;
			} else {
				System.out.println("invalid input");
			}
		}
		return null;
	}
}
