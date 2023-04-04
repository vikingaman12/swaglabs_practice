package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtoCart {
	public AddtoCart(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//div[text()='Sauce Labs Backpack']")
	private WebElement saucelabbackpack;
	
	@FindBy(id="add-to-cart-sauce-labs-backpack")
	private WebElement addtocartsaucelabbackpack;
	
	@FindBy(xpath="//button[@data-test='back-to-products']")
	private WebElement backtoproductspage;
	
	@FindBy(xpath="//a[@class='shopping_cart_link']")
	private WebElement cart;
	
	@FindBy(id="checkout")
	private WebElement checkoutpage;

	public WebElement getBacktoproductspage() {
		return backtoproductspage;
	}

	public WebElement getSaucelabbackpack() {
		return saucelabbackpack;
	}

	public WebElement getAddtocartsaucelabbackpack() {
		return addtocartsaucelabbackpack;
	}
	public WebElement getCart() {
		return cart;
	}

	public WebElement getCheckoutpage() {
		return checkoutpage;
	}

	public void clickSauceLabBackpack()	{
		saucelabbackpack.click();
	}
	public void addToCartSauceLabBackpack()	{
		addtocartsaucelabbackpack.click();
	}
	public void backToproductsPage()	{
		backtoproductspage.click();
	}
	public void goToCartPage() {
		cart.click();
	}
	public void goToCheckoutPage() {
		checkoutpage.click();
	}
	
}
