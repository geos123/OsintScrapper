package at.osintScrapper.osintScrapper.Controller;

import java.util.Scanner;

public class CompanySelector implements SearchSelector {
	
	@Override
	public String getSearchString() {
		Scanner keyboardScanner = new Scanner(System.in);
		System.out.println("Company Name: ");
		
		String companyInput = keyboardScanner.nextLine();
		
		keyboardScanner.close();
		
		return companyInput.replaceAll(" ", "%20");
	}

}
