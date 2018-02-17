package at.osintScrapper.osintScrapper.model;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

	private String address;
	private WebDriver driver;
	
	private String PERSON_NAME_XPATH = "//*[@id='fb-timeline-cover-name']/a";
	private String PARTNER_NAME_XPATH = "//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[4]/div/div/div/div/div/a";
	private String EDUCATION_XPATH = "//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[2]/div/div/div/div/a";
	private String LIVING_PLACE_XPATH = "//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[3]/div/div/div/div/a";
	private String WORKPLACE_XPATH = "//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[1]/div/div/div/div/a";

	public ProfilePage(WebDriver driver, String address) {
		this.setDriver(driver);
		this.setAddress(address);
	}

	public String getName() {
		WebElement nameElement = driver.findElement(By.xpath(PERSON_NAME_XPATH));
		String name = nameElement.getText();

		return name;
	}

	public String getPartnerName() {
		try {
			WebElement partnerWebElement = driver.findElement(By.xpath(PARTNER_NAME_XPATH));
			return partnerWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No partner found at " + this.address);
		}
		return null;
	}	
	
	public String getEducation() {
		try {
			WebElement educationWebElement = driver.findElement(By.xpath(EDUCATION_XPATH));
			return educationWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No education found at " + this.address);
		}
		
		return null;
		
	}	
	
	public String getLivingPlace() {		
		try {
			WebElement livingPlaceWebElement = driver.findElement(By.xpath(LIVING_PLACE_XPATH));
			return livingPlaceWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No living place found at " + this.address);
		}
		
		return null;
	}	

	public String getWorkplace() {		
		try {
			WebElement workplaceWebElement = driver.findElement(By.xpath(WORKPLACE_XPATH));
			return workplaceWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No living place found at " + this.address);
		}
		
		return null;
	}	
	
	public List<String> getMusic() {
		List<String> musicArtists = new ArrayList<>();
		
		try {
			List<WebElement> musicElements = driver.findElements(By.className("_5rz"));			
			for(WebElement element : musicElements) {
				WebElement linkElement = element.findElement(By.className("_gx7"));
				System.out.println(linkElement.getAttribute("title"));
				musicArtists.add(linkElement.getAttribute("title"));
			}
			return musicArtists;
			
		} catch (NoSuchElementException e) {
			System.out.println("no music found at " + this.address);
		}
		
		return null;
	}	
	
	public List<String> getFriends() {
		List<String>friends = new ArrayList<>();		
		try {
			List<WebElement> friendsElements = driver.findElements(By.className("_698"));
			
			for(WebElement element : friendsElements) {				
				List<WebElement> friendDivElements = element.findElements(By.className("fsl"));
			
				WebElement linkDivElement = friendDivElements.get(0);
				WebElement link = linkDivElement.findElement(By.tagName("a"));
				friends.add(link.getText());
			}
			return friends;
			
		} catch (NoSuchElementException e) {
			System.out.println("no friends found at " + this.address);
		}
		
		return null;		
	}	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException();
		}
		this.address = address;
	}

	public void setDriver(WebDriver driver) {
		if (driver == null) {
			throw new IllegalArgumentException();
		}
		this.driver = driver;
	}
}
