package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

	WebDriver driver;
	
	@FindBy(how=How.CLASS_NAME, using="menuExit")
	private WebElement exitButton;
	
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
	
	//Define Exit Button Click Method
	public void ExitLoginButton()
	{
		exitButton.click();
	}

}	
	
