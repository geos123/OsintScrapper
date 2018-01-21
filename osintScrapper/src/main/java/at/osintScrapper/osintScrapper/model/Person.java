package at.osintScrapper.osintScrapper.model;

public class Person {
	
	private String name;
	private String education;
	private String livingPlace;
	private String workPlace;
	private String partner;
	
	
	
	
	
	@Override
	public String toString() {
		
		String personString = "Name: " + this.name + ", Education: " + this.education + ", Living in: " + this.livingPlace +
				", Working in:" + this.workPlace + ", Partner: " + this.partner;
		
		return personString;
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

}
