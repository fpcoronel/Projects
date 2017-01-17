package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	@FindBy(how=How.ID, using="exampleInputEmail1")
	private WebElement usernameField;
	
	@FindBy(how=How.ID, using="InputPasword")
	private WebElement passwordField;
	
	@FindBy(how=How.CLASS_NAME, using="btn-lg")
	private WebElement loginButton;
	

	//Define User name Enter Method
	public void EnterUserName(String usernametext)
	{
		usernameField.sendKeys(usernametext);
	}
	
	//Define Password Enter Method
		public void EnterPassword(String passwordtext)
		{
			passwordField.sendKeys(passwordtext);
		}
		
	//Define Login Button Click Method
		public void ClickLoginButton()
		{
			loginButton.click();
		}


}
