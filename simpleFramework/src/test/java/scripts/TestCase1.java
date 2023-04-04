package scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import genericUtility.ExcelFile;
import genericUtility.PropertyFile;
import pom.AddtoCart;
import pom.CheckoutPage;
import pom.LoginPage;

public class TestCase1 {
	
	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		/*
		 * To fetch common data from property file
		 */
		PropertyFile plib = new PropertyFile();
		ExcelFile ef = new ExcelFile();
		LoginPage login = new LoginPage(driver);
		String URL = plib.getPropertyKeyValue("url");
		String UN = plib.getPropertyKeyValue("username");
		String PWD = plib.getPropertyKeyValue("password");
		driver.get(URL);
		login.loginToApp(UN, PWD);
		
		AddtoCart ad = new AddtoCart(driver);
		ad.clickSauceLabBackpack();
		ad.addToCartSauceLabBackpack();
		ad.backToproductsPage();
		ad.goToCartPage();
		ad.goToCheckoutPage();
		Thread.sleep(1500);
		CheckoutPage cp = new CheckoutPage(driver);
		cp.firstNameTextField(ef.getExcelData("contactDetails", 1, 0));
		cp.lastNameTextField(ef.getExcelData("contactDetails", 1, 1));
		cp.postalCodeTextField(ef.getExcelData("contactDetails", 1, 2));
		Thread.sleep(1500);
		driver.findElement(By.name("continue")).click();
		driver.findElement(By.xpath("//button[text()='Finish']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("back-to-products")).click();
		driver.navigate().to("https://www.saucedemo.com/");
		driver.close();
	}
}
