package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[2]/a")
	private WebElement exitButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-1\"]/div[1]/button/span")
	private WebElement NewObjOpButton;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/main/main/div/div/div/div[4]/div/div[3]/div[1]/button")
	private WebElement NewStrategicOpButton;
		
	@FindBy(how=How.XPATH, using="//*[@id=\"name\"]")
	private WebElement NewOpObjField;	

	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/button[1]")  
	private WebElement SaveOpObjButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/button[1]")  
	private WebElement SaveStrategicObjButton;	
	
	@FindBy(how=How.CSS, using="#grupo-level-1 > ul")
	private WebElement ListOpObj;
	
	@FindBy(how=How.XPATH, using="/html/body/div[1]/main/main/div/div/div/div[4]/div/div[3]/div[2]")
	private WebElement ListSTObj;
	
	@FindBy(how=How.CSS, using="body > div.loadingoverlay")
	private WebElement Spinner;	
	
	@FindBy(how=How.ID, using="alert")
	private WebElement Alert;	
	
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
	
	public void waitForLoad(WebDriver driver) {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(pageLoadCondition);
}
	//Wait until Spinner is invisible
	public boolean SpinnerIsInvisible() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.cssSelector("body > div.loadingoverlay"))));
		boolean check = driver.findElements(By.cssSelector("body > div.loadingoverlay")).size() > 0;
		return check;
	}		
	
	//Wait until Alert is invisible
	public boolean AlertIsInvisible() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("alert"))));
		boolean check = driver.findElements(By.id("alert")).size() > 0;
		return check;
	}		

	//New Operative Objective is present? 
	public boolean ObjectiveisPresent(String newOpObj) {		
		boolean check = false;
		List<WebElement> OpObjElements = ListOpObj.findElements(By.tagName("li"));		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#grupo-level-1 > ul")));
			
		 for(int i=0;i<OpObjElements.size();i++){
			 String OpObj =(OpObjElements.get(i).getText());
			 if (OpObj.equals(newOpObj)){
				 check = true;				 
			 }
		 }
		 return check;
	}
	
	//Exit button is present?
	public boolean ExitIsPresent() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.ById.className("menuExit")));
		boolean check = driver.findElements(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[2]/a")).size() > 0;
		return check;
	}

	//Define Exit Button Click Method
	public void ClickExitButton()
	{
		exitButton.click();
	}
	
	//Click New Operative Objective Button
	public void ClickNewOpObjButton()
	{
		NewObjOpButton.click();
	}

	//Enter New Operative Objective Name 
	public void EnterNameNewOpOBJ(String newOpObj)
	{
	NewOpObjField.sendKeys(newOpObj);
	}
	
	//Click Save Button for New Operative Objective 
	public void ClickSaveOpObjButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"grupo-level-3-3\"]/div/form/button[1]")));
		SaveOpObjButton.click();
	}
	
	//Click New Strategic Obj Button
	public void ClickNewStrategicObjButton()
	{
		NewStrategicOpButton.click();
	}
	
	//Click Save Button for New Strategic Objective 
	public void ClickSaveStrategicObjButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"grupo-level-3-3\"]/div/form/button[1]")));
		SaveStrategicObjButton.click();
	}
	
	//New Strategic Objective is present? 
		public boolean STObjectiveisPresent(String newSTObj) {		
			boolean check = false;
			List<WebElement> STObjElements = ListSTObj.findElements(By.className("nameObj"));		
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/main/main/div/div/div/div[4]")));
				
			 for(int i=0;i<STObjElements.size();i++){
				 String STObj =(STObjElements.get(i).getText());
				 if (STObj.equals(newSTObj)){
					 check = true;				 
				 }
			 }
			 return check;
		}

}	
	
