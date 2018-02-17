package at.osintScrapper.osintScrapper.model;

import java.util.ArrayList;
import java.util.List;

public class Person {
	
	private String name;
	private String education;
	private String livingPlace;
	private String workPlace;
	private String partner;
	private List<String> friends;
	private List<String> musicArtists;
	
	
	public Person() {
		this.friends = new ArrayList<>();
		this.musicArtists = new ArrayList<>();
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
			
		String personString = "Name: " + this.name + ", Education: " + this.education + ", Living in: " + this.livingPlace +
				", Working in:" + this.workPlace + ", Partner: " + this.partner;
		
		sb.append(personString);
		
		sb.append(", Music: ");
		
		for(String artist : this.musicArtists) {
			sb.append(artist);
			sb.append(", ");
		}
		
		
		sb.append(", Friends: ");
		
		for(String friend : this.friends) {
			sb.append(friend);
			sb.append(", ");
		}
		return sb.toString();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getLivingPlace() {
		return livingPlace;
	}
	public void setLivingPlace(String livingPlace) {
		this.livingPlace = livingPlace;
	}
	public String getWorkPlace() {
		return workPlace;
	}
	public void setWorkPlace(String workPlace) {
		this.workPlace = workPlace;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public List<String> getFriends() {
		return friends;
	}
	public void addFriend(String friend) {
		this.friends.add(friend);
	}
	public List<String> getMusic() {
		return musicArtists;
	}
	public void addMusicArtist(String artist) {
		this.musicArtists.add(artist);
	}

}
