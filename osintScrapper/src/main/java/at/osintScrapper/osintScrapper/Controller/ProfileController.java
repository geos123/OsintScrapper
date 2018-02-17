package at.osintScrapper.osintScrapper.Controller;

import java.util.List;

import org.openqa.selenium.WebDriver;

import at.osintScrapper.osintScrapper.model.Person;
import at.osintScrapper.osintScrapper.model.ProfilePage;

public class ProfileController {
	
	private WebDriver driver;
	private String address;
	
	public ProfileController(WebDriver driver, String address) {
		this.setDriver(driver);
		this.setAddress(address);
	}	

	public Person createPerson() {
		Person person = new Person();
		
		ProfilePage profilePage = new ProfilePage(this.driver, this.address);
		driver.get(address);
		person.setName(profilePage.getName());
		
		driver.get(this.getAboutAddress());
		person.setPartner(profilePage.getPartnerName());
		person.setEducation(profilePage.getEducation());
		person.setWorkPlace(profilePage.getWorkplace());
		person.setLivingPlace(profilePage.getLivingPlace());
		
		driver.get(this.getMusicAddress());
		List<String> musicArtists = profilePage.getMusic();
		if(musicArtists != null) {
			for(String artist : musicArtists) {
				person.addMusicArtist(artist);
			}
		}
		
		driver.get(this.getFriendsAddress());		
		List<String> friends = profilePage.getFriends();
		if(friends != null) {
			for(String friend : friends) {
				person.addFriend(friend);
			}
		}		
		return person;
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
	
	
	private String getMusicAddress() {		
		if(this.address.indexOf("?") != -1) {
			String tempAddress = this.address.substring(0, this.address.indexOf("?"));
			return tempAddress + "/music";
		}
		
		String musicAddress = this.address + "/music";
		return musicAddress;
	}
	
	
	public void setDriver(WebDriver driver) {
		if(driver == null) {
			throw new IllegalArgumentException();
		}
		this.driver = driver;
	}

	public void setAddress(String address) {
		if(address == null) {
			throw new IllegalArgumentException();
		}
		this.address = address;
	}
}
