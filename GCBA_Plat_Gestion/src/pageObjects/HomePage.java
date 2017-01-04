package pageObjects;

import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver){
		this.driver=driver;
	}
	
	public String getHomePageTitle(){
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	public boolean verifyHomePageTitle() {
		String expectedPageTitle="Gobierno de la Ciudad de Buenos Aires";
		return getHomePageTitle().contains(expectedPageTitle);
	
	}

}	
	
