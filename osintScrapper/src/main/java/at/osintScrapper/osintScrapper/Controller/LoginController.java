package at.osintScrapper.osintScrapper.Controller;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Controlling the login
 *  
 */

public class LoginController {
	
	private WebDriver driver;
	private String FACEBOOK_URL = "https://www.facebook.com";
	private String EMAIL_ID = "email";
	private String PASSWORD_ID = "pass";
	
	public LoginController(WebDriver driver) {
		this.setDriver(driver);		
	}
	
	public void login(String email, String password) {		
		driver.get(FACEBOOK_URL);
		driver.manage().window().maximize();
		WebElement emailElement = driver.findElement(By.id(EMAIL_ID));
		WebElement passwordElement = driver.findElement(By.id(PASSWORD_ID));

		emailElement.clear();
		emailElement.sendKeys(email);
		passwordElement.sendKeys(password);
		passwordElement.sendKeys(Keys.RETURN);		
	}

	public void setDriver(WebDriver driver) {
		if(driver == null) {
			throw new IllegalArgumentException();
		}
		
		this.driver = driver;
	}
}
