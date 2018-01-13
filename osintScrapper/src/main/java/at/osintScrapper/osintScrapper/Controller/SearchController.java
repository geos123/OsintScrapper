package at.osintScrapper.osintScrapper.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchController {
	
	private WebDriver driver;
	private List<String> profileList;
	
	public SearchController(WebDriver driver) {
		this.setDriver(driver);
	}

	
	public List<String> searchProfileList(String searchString) {
		driver.get(searchString);

		profileList = new ArrayList<>();

		List<WebElement> list = driver.findElements(By.className("_32mo"));
		int currentElementCounter = -1;

		while (currentElementCounter < list.size()) {
			System.out.println("loop");
			currentElementCounter = list.size();

			driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
			JavascriptExecutor jse = (JavascriptExecutor) driver;

			jse.executeScript("window.scrollBy(0,1400)", "");

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			list = driver.findElements(By.className("_32mo"));

		}

		System.out.println(list.size());

		for (int i = 0; i < list.size(); i++) {
			WebElement element = list.get(i);
			profileList.add(element.getAttribute("href"));
		}

		for (String s : profileList) {
			System.out.println(s);
		}
		
		return profileList;
		
	}
	
	public void setDriver(WebDriver driver) {
		if(driver == null) {
			throw new IllegalArgumentException();
		}
		this.driver = driver;
	}

}
