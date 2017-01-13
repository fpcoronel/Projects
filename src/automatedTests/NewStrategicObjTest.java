package automatedTests;

import java.util.Random;

//Selenium
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//TestNG
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

//Driver
import driverSetUp.DriverSetUp;

//Pages
import pageObjects.LoginPage;
import pageObjects.HomePage;


public class NewStrategicObjTest extends DriverSetUp {
	
	private WebDriver driver;
	
	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	
	public void setUp() {
		driver = getDriver();
	}
	
	@Test(description = "Crear nuevo Objetivo Estratégico")
	public void CreateNewStrategicObj() throws InterruptedException{
		
		  Random rndNum= new Random();
		  int rndNum1 = 0;
		  rndNum1 = rndNum.nextInt((500-0));
		
		//Initialize Pages
		  LoginPage loginPage= PageFactory.initElements(driver, LoginPage.class);
		  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		  
		  homePage.waitForLoad(driver);
		  
		  //Enter user name
		  loginPage.EnterUserName("abouperez@buenosaires.gob.ar");
		  
		  //Enter Password
		  loginPage.EnterPassword("Test123");
		  
		  //Click Login Button
		  loginPage.ClickLoginButton();
 
		  //Wait until Spinner disappears
		  homePage.SpinnerIsInvisible();
		  
		  homePage.CloseProyCarousel();
		  
		  //wait until Alert disappears
		  homePage.AlertIsInvisible();	  
		  
		  //Click New Strategic Objective Button
		  homePage.ClickNewStrategicObjButton();
		  
		  //Enter Name New Strategic Objective
		  homePage.EnterNameNewOBJ("Automated New Strategic Objective " + rndNum1);
		  
		  homePage.SpinnerIsInvisible();
		  
		  //Save New Strategic Objective
		  homePage.ClickSaveStrategicObjButton();
		  
		  homePage.SpinnerIsInvisible();		  
	
		  Assert.assertTrue(homePage.STObjectiveisPresent("Automated New Strategic Objective " + rndNum1), "Objetivo no encontrado");
	}
	
	  @AfterClass
	  public void afterClass() {
		  
		  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		  
		  //Exit
		  homePage.ClickExitButton(); 
		  
		  // Close the driver
		  driver.quit();
	  }

}
