package at.osintScrapper.osintScrapper.Controller;

import org.openqa.selenium.WebDriver;

public class ProfileController {
	
	private WebDriver driver;
	
	public ProfileController(WebDriver driver) {
		this.setDriver(driver);
	}
	
	

	public void setDriver(WebDriver driver) {
		if(driver == null) {
			throw new IllegalArgumentException();
		}
		this.driver = driver;
	}

}
