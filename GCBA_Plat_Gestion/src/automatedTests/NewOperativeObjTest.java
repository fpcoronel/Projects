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

public class NewOperativeObjTest extends DriverSetUp{
		
		SoftAssert s_assert = new SoftAssert();
		private WebDriver driver;
		
		@Parameters({ "browserType", "appURL" })
		@BeforeClass
		
		public void setUp() {
			driver = getDriver();
		}
		
		@Test(description = "Crear nuevo Objetivo Operativo")
		public void CreateNewObjOp() throws InterruptedException{
			
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
			  
			  homePage.ExitIsPresent();
			  
			  //Click New Operative Objective Button
			  homePage.ClickNewOpObjButton();
			  
			  //Enter Name New Operative Objective
			  homePage.EnterNameNewOpOBJ("Automated New Operative Objective");
			  
			  homePage.waitForLoad(driver);
			
			  //Save New Operative Objective
			  homePage.ClickSaveOpObjButton();
			  
			  homePage.SpinnerIsInvisible();			  

			  Assert.assertTrue(homePage.ObjectiveisPresent("Automated New Operative Objective"), "Objetivo no encontrado");
			  
			  //Exit
			  homePage.ClickExitButton();
		}
}

		