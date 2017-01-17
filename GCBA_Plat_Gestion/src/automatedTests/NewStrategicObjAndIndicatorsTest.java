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


public class NewStrategicObjAndIndicatorsTest extends DriverSetUp {
	
	private WebDriver driver;
	
	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	
	public void setUp() {
		driver = getDriver();
	}
	
	@Test(description = "Crear nuevo Objetivo Estratégico")
	public void CreateNewStrategicObjandInd() throws InterruptedException{
		
		  Random rndNum= new Random();
		  int rndNum1, rndWeight = 0;
		  rndNum1 = rndNum.nextInt((500-0));
		  rndWeight = rndNum.nextInt((50-0));
		
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
		  
		  //homePage.ErrorIsPresent();
 
		  //Wait until Spinner disappears
		  homePage.SpinnerIsInvisible();
		  
		  homePage.CloseProyCarousel();
		  
		  //wait until Alert disappears
		  homePage.AlertIsInvisible();	  
		  
		  homePage.waitForLoad(driver);
	 
		  //Click New Strategic Objective Button
		  homePage.ClickNewStrategicObjButton();
		  
		  //Wait until Spinner disappears
		  homePage.SpinnerIsInvisible();
		  
		  //Enter Name New Strategic Objective
		  homePage.EnterNameNewOBJ("Automated Strategic Objective " + rndNum1);
		  
		  for (int i = 0; i < 2; i++){
			
			  //Create new Indicator
			  homePage.ClickNewIndButton(i);
			  
			  homePage.SpinnerIsInvisible();
			  
			  String IndNum = Integer.toString(i + 1);
			  //Enter New Indicator Name
			  homePage.EnterNameNewInd(i, "Indicator " + rndNum1 + "_" + IndNum);
			  
			  //Enter new Calculation Method
			  homePage.EnterNewMethCalc(i, "Method Indicator " + rndNum1 + "_"  + IndNum);
			  
			  //Enter New Relative Weight			  
			  homePage.EnterNewRelWeight(i, rndWeight);			  
		  }		  
		
		  //Save New Strategic Objective
		  homePage.ClickSaveStrategicObjButton();
		  		   
		  //Wait Spinner
		  homePage.SpinnerIsInvisible();
		  
		  //wait until Alert disappears
		  homePage.AlertIsInvisible();	
		  
		  homePage.waitForLoad(driver);
		  
		  //homePage.ErrorIsPresent();
		  
		  //Display Strategic Obj
		  homePage.DisplayStrategicObj("Automated Strategic Objective " + rndNum1);

		  Assert.assertTrue(homePage.STObjectiveisPresent("Automated Strategic Objective " + rndNum1), "Objetivo no encontrado");
		  
		  for (int i = 0; i < 2; i++){
			  String IndNum = Integer.toString(i + 1);
			  Assert.assertTrue(homePage.IndicatorIsCreated("Indicator " + rndNum1 + "_" + IndNum), "Indicador no encontrado");
		  }
	}
	
	  @AfterClass
	  public void afterClass() {
		  
		  HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		  
		  //Exit
		  //homePage.ClickExitButton(); 
		  
		  //Close the driver
		  //driver.quit();
	  }

}
