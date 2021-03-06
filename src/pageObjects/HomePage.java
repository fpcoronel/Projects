package pageObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	
	@FindBy(how=How.ID, using="errorModal")
	private WebElement Error;	
	
	@FindBy(how=How.CSS, using="a[class='menuExit']")
	private WebElement exitButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-1\"]/div[1]/button/span")
	private WebElement NewObjOpButton;
	
	@FindBy(how=How.CSS, using="button[ng-click='homeCtrl.addStrategicObjective(homeCtrl.jurisdiccion.idJurisdiccion)']")
	 private WebElement NewStrategicOpButton;
		
	@FindBy(how=How.ID, using="name")
	private WebElement NameNewObjField;	

	@FindBy(how=How.CSS, using="#grupo-level-3-3 > div > form > button.btn.btn-success")  
	private WebElement SaveOpObjButton;
		
	@FindBy(how=How.CSS, using="#grupo-level-3-3 > div > form > button.btn.btn-success")  
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
	private WebElement NewIndicatorButton;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/div/div[2]/div[1]/input")
	private WebElement IndicatorNameField;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/div/div[2]/div[2]/input")
	private WebElement IndCalcMethNameField;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"grupo-level-3-3\"]/div/form/div/div[2]/div[3]/input")
	private WebElement IndRelWeightField;
	
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
	
	@FindBy(how=How.CSS, using="input[ng-model='formCtrl.currentProject.fechaInicio']")
	private WebElement StartDateField;
	
	@FindBy(how=How.CSS, using="input[ng-model='formCtrl.currentProject.fechaFin']")
	private WebElement EndDateField;
	
	@FindBy(how=How.ID, using="draftButton")
	private WebElement ProjectDraftButton;
	
	@FindBy(how=How.CSS, using="textarea[ng-model='formCtrl.currentProject.descripcion']")
	private WebElement ProjectDescField;
	
	@FindBy(how=How.ID, using="meta")
	private WebElement ProjectMeta;
	
	@FindBy(how=How.ID, using="unit")
	private WebElement ProjectUnit;	
	
	@FindBy(how=How.CSS, using="input[ng-model='p.presupuesto']")
	private WebElement ProjectFunds;
	
	@FindBy(how=How.CSS, using="input[ng-model='p.otrasFuentes']")
	private WebElement ProjectOtherFunds;	
	
	@FindBy(how=How.CSS, using="input[ng-model='formCtrl.currentProject.poblacionAfectada']")
	private WebElement projectAmountImpactedPopulation;	
	
	@FindBy(how=How.CSS, using="input[ng-model='newTag.text']")
	private WebElement projectImpactedPopulationField;	
	
	@FindBy(how=How.CSS, using="div[ng-if='suggestionList.visible']")
	private WebElement projectPopulationList;
	
	@FindBy(how=How.CSS, using="input[ng-model='formCtrl.currentProject.liderProyecto']")
	private WebElement projectResponsible;
	
	@FindBy(how=How.CSS, using="select[ng-model='formCtrl.areaNombre']")
	private WebElement projectArea;	
	
	@FindBy(how=How.CSS, using="input[ng-model='formCtrl.currentProject.organismosCorresponsables']")
	private WebElement projectCoResponsible;
	
	@FindBy(how=How.CSS, using="select[ng-model='formCtrl.currentProject.tipoUbicacionGeografica']")
	private WebElement projectLocation;
	
	@FindBy(how=How.CSS, using="input[checked ng-model='formCtrl.currentProject.tipoProyecto'] [value='Nuevo']")
	private WebElement projectTypeNuevo;
	
	@FindBy(how=How.CSS, using="input[ng-model='formCtrl.currentProject.tipoProyecto'] [value='Ampliaci�n']")
	private WebElement projectTypeAmpliacion;
	
	@FindBy(how=How.ID, using="eje-1")
	private WebElement projectEje1;	
	
	@FindBy(how=How.CSS, using="input[ng-model='formCtrl.currentProject.cambioLegislativo'] [value='false']")
	private WebElement projectNoLegalChange;
	
	@FindBy(how=How.CSS, using="input[ng-model='formCtrl.currentProject.prioridadJurisdiccional'] [value='1.Alta']")
	private WebElement projectPriority;	
	
	@FindBy(how=How.CSS, using="button[ng-click='formCtrl.presentProject()']")
	private WebElement saveButton;
	
	public String id = "";

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
	public void ClickNewIndButton()
	{
		NewIndicatorButton.click();
	}
	
	//Enter new Indicator name
	public void EnterNameNewInd(int ind, String newIndName)
	{
		switch(ind) {
        case 0:
        	IndicatorNameField.sendKeys(newIndName);
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
        	IndCalcMethNameField.sendKeys(newMethCalcName);
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
        	IndRelWeightField.sendKeys(RelWeight);
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
		
		//Get Element ID
		public String GetID(String ObjName){
			
			String id = "";
			List<WebElement> STObjElements = ListSTObj.findElements(By.className("nameObj"));
			
			 for(int i=0;i<STObjElements.size();i++){
				 String STObj =(STObjElements.get(i).getText());
				 if (STObj.equals(ObjName)){
					 
					 String att_href = (STObjElements.get(i).getAttribute("href"));
					 id = att_href.substring(att_href.length() - 3);
			     }
			 }
			 return id;
		}
		
		
		//Display Strategic Obj
		public void DisplayStrategicObj(String ObjName){
			
			 String id = GetID(ObjName);
			 WebElement editButton = driver.findElement(By.xpath("//*[@id=\"es-" + id + "\"]/div/div/div/p/span"));
			 
			// Create instance of Javascript executor					 
			 JavascriptExecutor je = (JavascriptExecutor) driver;
			 
			// now execute query which actually will scroll until that element is not appeared on page.					 
			 je.executeScript("arguments[0].scrollIntoView(true);",editButton);
			 
			 //click edit button
			 editButton.click(); 
		}
		
		//Click New Operative Obj button on specific Strategic Obj
		
		public void ClickNewOpObjButton(String ObjName){
			 
			 String id = GetID(ObjName);
			 String selector = ("#grupo-level-" + id + " > div.contentName > button");
			 
			 WebElement NewButton = driver.findElement(By.cssSelector(selector));					 
			 
			 // Create instance of Javascript executor					 
			 JavascriptExecutor je = (JavascriptExecutor) driver;
			 
			// now execute query which actually will scroll until that element is not appeared on page.					 
			 je.executeScript("arguments[0].scrollIntoView(true);",NewButton);
			
			 //click edit button
			 NewButton.click();					
		}
		
		public void ClickNewProjectButton(String ObjName){
			
			 String id = GetID(ObjName);
			 WebElement NewButton = driver.findElement(By.id("addProjectButton-" + id));					 
			 
			 // Create instance of Javascript executor					 
			 JavascriptExecutor je = (JavascriptExecutor) driver;
			 
			// now execute query which actually will scroll until that element is not appeared on page.					 
			 je.executeScript("arguments[0].scrollIntoView(true);",NewButton);
			
			 //click edit button
			 NewButton.click();		
		}
		
		//Display Operative Obj
		public void DisplayOperativeObj(String ObjName){
		
			 String id = GetID(ObjName);
			 WebElement Expand = driver.findElement(By.xpath("//*[@id=\"op-" + id + "\"]/div/div/div/div"));
			 
			// Create instance of Javascript executor					 
			 JavascriptExecutor je = (JavascriptExecutor) driver;
			 
			// now execute query which actually will scroll until that element is not appeared on page.					 
			 je.executeScript("arguments[0].scrollIntoView(true);",Expand);
			 
			 //click edit button
			 Expand.click();
		}
		
		public void GetPopulationOption(String option){
						
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("suggestion-list")));
			
			List<WebElement> PopListElements = projectPopulationList.findElements(By.className("suggestion-item"));			
			
			 for(int i=0;i<PopListElements.size();i++){
				 String item =(PopListElements.get(i).getText());
				 System.out.println(item);
				 if (item.equals(option)){
					 PopListElements.get(i).click();
					 SpinnerIsInvisible();
					 i = PopListElements.size();
					// wait.until(ExpectedConditions.stalenessOf(projectPopulationList));
					 //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[ng-if='suggestionList.visible']")));
			     }
			 }
			 
		}
		
		public void EnterResponsible(String responsible){
			projectResponsible.click();
			projectResponsible.sendKeys(responsible);
		}
		
		public void GetProjectArea(String area){
			//generar c�digo para seleccionar area de proyecto
			Select selectArea = new Select(projectArea);
			selectArea.selectByVisibleText(area);
		}
		
		public void GetLocation(String location){
			//generar c�digo para seleccionar Ubicaci�n de proyecto
			Select selectLocation = new Select(projectLocation);
			selectLocation.selectByVisibleText(location);
		}
		
		public void SetProjectType(){
			projectTypeAmpliacion.click();
		}
		
		public void SetGovAxis(){
			projectEje1.click();
		}
		
		public void NeedsLegalChange(){
			projectNoLegalChange.click();
		}
				
		public void ProjectPriority(){
			projectPriority.click();
		}
		
		//Enter Project start date
		public void EnterStartDate(String StartDate){
			StartDateField.sendKeys(StartDate);
		}
		
		//Enter Project end date
		public void EnterEndDate(String EndDate){
			EndDateField.sendKeys(EndDate);
		}
		
		public void EnterProjectDescription(String description){
			ProjectDescField.sendKeys(description);
		}
																																																												
		public void EnterProjectMeta(String meta){
			ProjectMeta.sendKeys(meta);
		}
		
		public void EnterProjectUnit(String unit){
			ProjectUnit.sendKeys(unit);
		}
		
		public void EnterProjectFunds(int funds){
			String sfunds = Integer.toString(funds);
			ProjectFunds.sendKeys(sfunds);
		}
		
		public void EnterProjectOtherFunds(int otherfunds){
			String sofunds = Integer.toString(otherfunds);
			ProjectOtherFunds.sendKeys(sofunds);
		}
		
		public void EnterProjectQtyImpactedPopulation(int qty){
			String amount = Integer.toString(qty);
			projectAmountImpactedPopulation.sendKeys(amount);
		}
		
		public void DisplayImpactedPopulationList(){
			projectImpactedPopulationField.click();
		}
		
		public void EnterProjectResponsible(String responsible){
			projectResponsible.sendKeys(responsible);			
		}
		
		public void EnterCoResponsible(String coResponsible){
			projectCoResponsible.sendKeys(coResponsible);
		}
		
		
		
		//Save Draft Project
		public void SaveDraftProject(){
			ProjectDraftButton.click();
		}
		
		//Save Project
		public void SaveProject(){
			saveButton.click();
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
	
