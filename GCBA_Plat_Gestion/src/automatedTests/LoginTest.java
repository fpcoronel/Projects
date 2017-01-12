package automatedTests;

//TestNG
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

//Selenium
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Driver
import driverSetUp.DriverSetUp;

//Pages
import pageObjects.LoginPage;
import pageObjects.HomePage;

public class LoginTest extends DriverSetUp{
	
	SoftAssert s_assert = new SoftAssert();
	private WebDriver driver;

	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	
	public void setUp() {
		driver = getDriver();
	}
	
  @Test(description = "Login Test")
  
  public void Login(){

	  //Initialize Pages
	  LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
	  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	  
	
	  //Enter user name
	  loginPage.EnterUserName("abouperez@buenosaires.gob.ar");
	  
	  //Enter Password
	  loginPage.EnterPassword("Test123");
	  
	  //Click Login Button
	  loginPage.ClickLoginButton();
	  
	  homePage.waitForLoad(driver);
	  
	   //Verify user is logged in
	  Assert.assertTrue(homePage.ExitIsPresent(),"Login failed");
 

  }
  
  @AfterClass
  public void afterClass() {
	  
	  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
	  
	  //Exit
	  if (homePage.ExitIsPresent())
	  homePage.ClickExitButton(); 
	  
	// Close the driver
	driver.quit();
  }

}
