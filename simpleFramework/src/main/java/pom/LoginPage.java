package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver)	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="user-name")
	private WebElement UNTextField;
	
	@FindBy(id="password")
	private WebElement PWTextField;
	
	@FindBy(xpath="//input[@class='submit-button btn_action']")
	private WebElement SubmitButton;

	//getterMethods
	public WebElement getUNTextField() {
		return UNTextField;
	}

	public WebElement getPWTextField() {
		return PWTextField;
	}

	public WebElement getSubmitButton() {
		return SubmitButton;
	}
	
	public void loginToApp(String username,String password)	{
		UNTextField.sendKeys(username);
		PWTextField.sendKeys(password);
		SubmitButton.click();
	}
}