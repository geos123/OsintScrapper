package at.osintScrapper.osintScrapper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import at.osintScrapper.osintScrapper.Controller.LoginController;
import at.osintScrapper.osintScrapper.Controller.SearchController;
import at.osintScrapper.osintScrapper.Controller.Selector;
import at.osintScrapper.osintScrapper.model.ProfilePage;
import at.osintScrapper.osintScrapper.model.ScrappingMode;

/**
 * OsintScrapper Main
 *
 */
public class Main {
	public static void main(String[] args) {
		Selector selector = new Selector();

		System.out.println("OsintScrapper");

		
		// temp read properties:
		Properties prop = new Properties();
		InputStream input = null;
		String email = null;
		String password = null;
		String chromeDriverPath = null;
		
		try {
			input = new FileInputStream("D:\\settings.properties");
			// load a properties file
			prop.load(input);
			email = prop.getProperty("fbEmail");
			password = prop.getProperty("fbPassword");
			chromeDriverPath = prop.getProperty("chromeDriverPath");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("user-data-dir=D:\\FH\\2_IMS\\Drive\\3. Semester\\Projektarbeit\\workspace\\chromeProfile");
		//chromeOptions.addArguments("--headless");

		System.setProperty("webdriver.chrome.driver", chromeDriverPath);

		
		ScrappingMode mode = selector.selectMode();
		System.out.println(mode);

		
		WebDriver driver = new ChromeDriver(chromeOptions);
		
		LoginController loginController = new LoginController(driver);
		loginController.login(email, password);
		
	
		System.out.println("Searching for profiles...");
		SearchController searchController = new SearchController(driver);
		List<String> profiles = searchController.searchProfileList("https://www.facebook.com/search/str/wollsdorf%20leder/pages-named/employees/present/intersect");
		
		System.out.println(profiles.size() + " Profiles found");
		
		System.out.println("Fetching profiles...");
		
		
		
		for(String profileURLString : profiles) {
			System.out.println(profileURLString);
			ProfilePage p = new ProfilePage(driver, profileURLString);
			System.out.println(p.getName());
			System.out.println(p.getPartnerName());
			System.out.println(p.getEducation());
			System.out.println(p.getLivingPlace());
			System.out.println(p.getWorkplace());

		}
		
		
		driver.manage().deleteAllCookies();
		driver.close();
		
	}
}
