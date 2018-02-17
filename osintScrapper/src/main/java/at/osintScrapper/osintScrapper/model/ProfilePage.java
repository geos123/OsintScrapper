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

	public ProfilePage(WebDriver driver, String address) {
		this.setDriver(driver);
		this.setAddress(address);
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
		try {
			WebElement partnerWebElement = driver.findElement(By.xpath("//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[4]/div/div/div/div/div/a"));
			return partnerWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No partner found at " + this.address);
		}
		return null;
	}
	
	
	public String getEducation() {
		try {
			WebElement educationWebElement = driver.findElement(By.xpath("//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[2]/div/div/div/div/a"));
			return educationWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No education found at " + this.address);
		}
		
		return null;
		
	}
	
	
	public String getLivingPlace() {		
		try {
			WebElement livingPlaceWebElement = driver.findElement(By.xpath("//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[3]/div/div/div/div/a"));
			return livingPlaceWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No living place found at " + this.address);
		}
		
		return null;
	}
	

	public String getWorkplace() {		
		try {
			WebElement workplaceWebElement = driver.findElement(By.xpath("//*[@id='contentArea']/div/div[2]/div/div/div/div[2]/div/ul/li[2]/div/div[2]/div/div/div/ul/li[1]/div/div/div/div/a"));
			return workplaceWebElement.getText();
		} catch (NoSuchElementException e) {
			System.out.println("No living place found at " + this.address);
		}
		
		return null;
	}
	
	
	public List<String> getMusic() {
		System.out.println("getMusic");
		List<String> musicArtists = new ArrayList<>();
		
		driver.get(this.getMusicAddress());
		try {
			List<WebElement> musicElements = driver.findElements(By.className("_5rz"));
			System.out.println(musicElements.size());
			
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
		driver.get(this.getFriendsAddress());
		
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
	
	
	
	private String getMusicAddress() {		
		if(this.address.indexOf("?") != -1) {
			String tempAddress = this.address.substring(0, this.address.indexOf("?"));
			return tempAddress + "/music";
		}
		
		String musicAddress = this.address + "/music";
		return musicAddress;
	}
	
	
	private String getAboutAddress() {
		String aboutAddress = this.address + "&sk=about";
		return aboutAddress;
	}
	
	private String getFriendsAddress() {
		if(this.address.indexOf("?") != -1) {
			String tempAddress = this.address.substring(0, this.address.indexOf("?"));
			return tempAddress + "/friends";
		}
		
		String friendsAddress = this.address + "/friends";
		return friendsAddress;
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
