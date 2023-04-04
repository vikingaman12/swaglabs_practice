package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {
	public CheckoutPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="first-name")
	private WebElement firstnameTF;
	
	@FindBy(id="last-name")
	private WebElement lastnameTF;
	
	@FindBy(id="postal-code")
	private WebElement postalcodeTF;

	public WebElement getFirstnameTF() {
		return firstnameTF;
	}
	
	public WebElement getLastnameTF() {
		return lastnameTF;
	}

	public WebElement getPostalcodeTF() {
		return postalcodeTF;
	}

	public void firstNameTextField(String firstnamedata)	{
		firstnameTF.sendKeys(firstnamedata);
	}
	
	public void lastNameTextField(String lastnamedata)	{
		lastnameTF.sendKeys(lastnamedata);
	}
	
	public void postalCodeTextField(String pindata)	{
		postalcodeTF.sendKeys(pindata);
	}

}
