package at.osintScrapper.osintScrapper.model;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {

	private String address;
	private WebDriver driver;

	public ProfilePage(WebDriver driver, String address) {
		this.setDriver(driver);
		this.setAddress(address);

		this.openProfilePage();
	}

	private void openProfilePage() {
		driver.get(this.address);
	}

	public String getName() {
		WebElement nameElement = driver.findElement(By.xpath("//*[@id='fb-timeline-cover-name']/a"));
		String name = nameElement.getText();

		return name;
	}

	public String getPartnerName() {
		driver.get(this.getAboutAddress());

		try {
			WebElement partnerWebElement = driver.findElement(By.xpath("//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[4]/div/div/div/div/div/a"));
			return partnerWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No partner found at " + this.address);
		}
		return null;

	}
	
	
	public String getEducation() {
		
		//toDo
		driver.get(this.getAboutAddress());
		try {
			WebElement educationWebElement = driver.findElement(By.xpath("//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[2]/div/div/div/div/a"));
			return educationWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No education found at " + this.address);
		}
		
		return null;
		
	}
	
	
	public String getLivingPlace() {		
		//toDo
		driver.get(this.getAboutAddress());
		try {
			WebElement livingPlaceWebElement = driver.findElement(By.xpath("//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[3]/div/div/div/div/a"));
			return livingPlaceWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No living place found at " + this.address);
		}
		
		return null;
	}
	

	public String getWorkplace() {		
		//toDo
		driver.get(this.getAboutAddress());
		try {
			WebElement workplaceWebElement = driver.findElement(By.xpath("//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[1]/div/div/div/div/a"));
			return workplaceWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No living place found at " + this.address);
		}
		
		return null;
	}
	
	
	private String getAboutAddress() {
		String aboutAddress = this.address + "&sk=about";
		return aboutAddress;
	}
	
	private String getEducationAddress() {
		String educationAddress = this.getAboutAddress() + "&section=education";
		return educationAddress;
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
