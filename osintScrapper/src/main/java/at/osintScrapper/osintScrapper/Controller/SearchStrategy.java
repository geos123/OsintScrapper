package at.osintScrapper.osintScrapper.Controller;

import java.util.List;

public interface SearchStrategy {
	
	List<String> getProfilesList(String searchString);

}
