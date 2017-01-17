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
	
	@FindBy(how=How.ID, using="errorModal")
	private WebElement Error;	
	
	@FindBy(how=How.XPATH, using="//*[@id=\"bs-example-navbar-collapse-1\"]/ul[2]/li[2]/a")
	private WebElement exitButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-1\"]/div[1]/button/span")
	private WebElement NewObjOpButton;
	
	@FindBy(how=How.CSS, using="button[ng-click='homeCtrl.addStrategicObjective(homeCtrl.jurisdiccion.idJurisdiccion)']")
	 private WebElement NewStrategicOpButton;
		
	@FindBy(how=How.ID, using="name")
	private WebElement NameNewObjField;	

	@FindBy(how=How.CSS, using="#grupo-level-3-3 > div > form > button.btn.btn-success")  
	private WebElement SaveOpObjButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/button[1]")  
	private WebElement SaveStrategicObjButton;	
	
	@FindBy(how=How.CSS, using="#grupo-level-1 > ul") 
	private WebElement ListOpObj;
	
	@FindBy(how=How.CLASS_NAME, using="colorObjOperativo")
	private WebElement ListSTObj;

	@FindBy(how=How.CSS, using="body > div.loadingoverlay")
	private WebElement Spinner;	
	
	@FindBy(how=How.ID, using="alert")
	private WebElement Alert;	
	
	@FindBy(how=How.CSS, using="button[ng-click='formCtrl.addIndicador()']")
	private WebElement NewInd1Button;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/div/div[2]/div[1]/input") 
	private WebElement Ind1NameField;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/div/div[2]/div[2]/input")
	private WebElement I1CalcMethNameField;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/div/div[2]/div[3]/input")
	private WebElement I1RelWeightField;
	
	@FindBy(how=How.CSS, using="button[ng-click='formCtrl.addIndicador()']")
	private WebElement NewInd2Button;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/div/div[3]/div[1]/input") 
	private WebElement Ind2NameField;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/div/div[3]/div[2]/input")
	private WebElement I2CalcMethNameField;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/div/div[3]/div[3]/input")
	private WebElement I2RelWeightField;
	
	@FindBy(how=How.ID, using="grupo-level-3-3")
	private WebElement ListIndName;
	
	@FindBy(how=How.CSS, using="div[href='#carouselContent']")
	private WebElement ProyCarousel;
	
	@FindBy(how=How.CSS, using="button[ng-click='homeCtrl.collapseAll()']")
	private WebElement CollapseAllButton;
	

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
		//driver.findElement(By.xpath("//*[@id=\"alert\"]/a[1]")).click();	
		wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("alert"))));
		wait.until(ExpectedConditions.invisibilityOfElementLocated((By.id("alert"))));
		boolean check = driver.findElements(By.id("alert")).size() > 0;
		return check;
	}
	
	//Close Projects Carousel
	public void CloseProyCarousel(){
		ProyCarousel.click();		
	}
	
	//Check if an error after login
	public boolean ErrorIsPresent(){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		boolean check = false;
		wait.until(ExpectedConditions.visibilityOf(Error));
		check = driver.findElements(By.id("errorModal")).size() > 0;
		if (check == true) {
			driver.findElement(By.xpath("//*[@id=\"errorModal\"]/div/div/div[3]/button")).click();
		}
		return check;
	}

	//Assert Operative Objective
	public boolean ObjectiveisPresent(String newOpObj) {		
		boolean check = false;
		List<WebElement> OpObjElements = ListOpObj.findElements(By.tagName("li"));		
		//WebDriverWait wait = new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#grupo-level-1 > ul")));
			
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
	
	//Collapse ll
	public void CollapseAll(){
		CollapseAllButton.click();
	}
	
	//Click New Operative Objective Button
	public void ClickNewOpObjButton()
	{
		NewObjOpButton.click();
	}

	//Enter New Operative Objective Name 
	public void EnterNameNewOBJ(String newOpObj)
	{
	NameNewObjField.sendKeys(newOpObj);
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
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(NewStrategicOpButton));
		
		 NewStrategicOpButton.click();
	}
	
	//Click Save Button for New Strategic Objective 
	public void ClickSaveStrategicObjButton()
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"grupo-level-3-3\"]/div/form/button[1]")));
		SaveStrategicObjButton.click();
	}
	
	//Click New Indicator Button
	public void ClickNewIndButton(int Ind)
	{
		switch(Ind) {
        case 0:
        	NewInd1Button.click();
		break;
        case 1:
        	NewInd2Button.click();
		break;
        default:
        	break;
		}	
	}
	
	//Enter new Indicator name
	public void EnterNameNewInd(int ind, String newIndName)
	{
		switch(ind) {
        case 0:
        	Ind1NameField.sendKeys(newIndName);
		break;
        case 1:
        	Ind2NameField.sendKeys(newIndName);
		break;
        default:
        	break;
		}	
	}
	
	//Enter new Calculation Method
	public void EnterNewMethCalc(int ind, String newMethCalcName)
	{
		switch(ind) {
        case 0:
        	I1CalcMethNameField.sendKeys(newMethCalcName);
		break;
        case 1:
        	I2CalcMethNameField.sendKeys(newMethCalcName);
		break;
        default:
        	break;
		}	
	}	
	
	public void EnterNewRelWeight(int ind, int weight)
	{
		String RelWeight = Integer.toString(weight);
		
		switch(ind) {
        case 0:
        	I1RelWeightField.sendKeys(RelWeight);
		break;
        case 1:
        	I2RelWeightField.sendKeys(RelWeight);
		break;
        default:
        	break;
		}	
	}	
	
	    //Assert Strategic Objective
		public boolean STObjectiveisPresent(String newSTObj) {		
			boolean check = false;
			List<WebElement> STObjElements = ListSTObj.findElements(By.className("nameObj"));	
				
			 for(int i=0;i<STObjElements.size();i++){
				 String STObj =(STObjElements.get(i).getText());
				 if (STObj.equals(newSTObj)){
					 check = true;				 
				 }
			 }
			 return check;
		}
		
		//Display Strategic Obj
		public void DisplayStrategicObj(String pSTObj){
			
			List<WebElement> STObjElements = ListSTObj.findElements(By.className("nameObj"));
			
			 for(int i=0;i<STObjElements.size();i++){
				 String STObj =(STObjElements.get(i).getText());
				 if (STObj.equals(pSTObj)){
					 
					 //Create xpath to locate element
					 String att_href = (STObjElements.get(i).getAttribute("href"));
					 String id = att_href.substring(att_href.length() - 3);
					 
					 WebElement editButton = driver.findElement(By.xpath("//*[@id=\"es-" + id + "\"]/div/div/div/p/span"));
					 
					// Create instance of Javascript executor					 
					 JavascriptExecutor je = (JavascriptExecutor) driver;
					 
					// now execute query which actually will scroll until that element is not appeared on page.					 
					 je.executeScript("arguments[0].scrollIntoView(true);",editButton);
					 
					 //click edit button
					 editButton.click();
				 }				 
			 }	
		}
		
		//Click New Operative Obj button on specific Strategic Obj
		
		public void ClickSpecNewOpObjButton(String pSTObj){
			List<WebElement> STObjElements = ListSTObj.findElements(By.className("nameObj"));
			
			 for(int i=0;i<STObjElements.size();i++){
				 String STObj =(STObjElements.get(i).getText());
				 if (STObj.equals(pSTObj)){
					 
					 String att_href = (STObjElements.get(i).getAttribute("href"));
					 String id = att_href.substring(att_href.length() - 3);					 
								 
					 String Selector = ("#grupo-level-" + id + " > div.contentName > button");
					 
					 WebElement NewButton = driver.findElement(By.cssSelector(Selector));					 
					 
					 // Create instance of Javascript executor					 
					 JavascriptExecutor je = (JavascriptExecutor) driver;
					 
					// now execute query which actually will scroll until that element is not appeared on page.					 
					 je.executeScript("arguments[0].scrollIntoView(true);",NewButton);
					
					 //click edit button
					 NewButton.click();					 
				 }
			 }
		}
		
		//Assert Indicators
		public boolean IndicatorIsCreated(String pIndicatorName){
			boolean check = false;
			List<WebElement> IndicatorElements = ListIndName.findElements(By.cssSelector("input[ng-model='indicador.nombre']"));
			
			for(int i=0;i<IndicatorElements.size();i++){
				String IndicatorName = IndicatorElements.get(i).getAttribute("value");
				if(IndicatorName.equals(pIndicatorName)){
					check = true;
				}
			}
			
			return check;
		}

}	
	
