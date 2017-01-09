package automatedTests;

//Selenium
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//TestNG
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
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
	
	@Test(description = "Crear nuevo Objetivo Operativo")
	public void CreateNewStrategicObj() throws InterruptedException{
		
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
		  
		  //wait until Alert disappears
		  homePage.AlertIsInvisible();
		  
		  homePage.ExitIsPresent();
		  
		  //Click New Strategic Objective Button
		  homePage.ClickNewStrategicObjButton();
		  
		  //Enter Name New Strategic Objective
		  homePage.EnterNameNewOpOBJ("Automated New Strategic Objective");
		  
		  homePage.waitForLoad(driver);
		  
		  //wait until Alert disappears
		  homePage.AlertIsInvisible();
		
		  //Save New Strategic Objective
		  homePage.ClickSaveStrategicObjButton();
		  
		  //homePage.AlertIsInvisible();
		  
		  homePage.SpinnerIsInvisible();			  
	
		  Assert.assertTrue(homePage.STObjectiveisPresent("Automated New Strategic Objective"), "Objetivo no encontrado");
		  
		  //Exit
		  homePage.ClickExitButton();
	}

}
