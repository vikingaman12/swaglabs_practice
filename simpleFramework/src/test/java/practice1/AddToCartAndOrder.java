package practice1;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.ExcelFile;
import genericUtility.PropertyFile;
import io.github.bonigarcia.wdm.WebDriverManager;
import pom.AddtoCart;
import pom.CheckoutPage;
import pom.LoginPage;

// final scripts are in test/java/scripts folder these are just for  self Understanding and practice

public class AddToCartAndOrder {

	//public static WebDriver driver;
	public static void main(String[] args) throws Throwable {
//		String key = "webdriver.chrome.driver";
//		String value = "./src/main/resources/chromedriver.exe";
//		System.setProperty(key, value);
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--remote-allow-origins=*");
//		WebDriver driver = new ChromeDriver(options);
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		/*
		 * To fetch common data from property file
		 */
		
		PropertyFile plib = new PropertyFile();
		ExcelFile ef = new ExcelFile();
		
		/*
		 * With this you can open any browser, you just need to change the
		 * browser name in commonData.properties
		 */
		String BROWSER = plib.getPropertyKeyValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			//WebDriver driver = new ChromeDriver(options);
			driver = new ChromeDriver(options);
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String URL = plib.getPropertyKeyValue("url");
		String UN = plib.getPropertyKeyValue("username");
		String PWD = plib.getPropertyKeyValue("password");
		driver.get(URL);
		LoginPage login = new LoginPage(driver);
		login.loginToApp(UN, PWD);
		
		driver.getTitle();
		Thread.sleep(1500);
//		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
//		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		AddtoCart ad = new AddtoCart(driver);
		ad.clickSauceLabBackpack();
		ad.addToCartSauceLabBackpack();
//		driver.findElement(By.xpath("//button[@data-test='back-to-products']")).click();
		ad.backToproductsPage();
//		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		ad.goToCartPage();
//		driver.findElement(By.id("checkout")).click();
		ad.goToCheckoutPage();
		Thread.sleep(1500);
//		driver.findElement(By.id("first-name")).sendKeys(ef.getExcelData("contactDetails", 1, 0));
		CheckoutPage cp = new CheckoutPage(driver);
//		String firstnamedata = ef.getExcelData("contactDetails", 1, 0);
//		cp.firstNameTextField(firstnamedata);
		cp.firstNameTextField(ef.getExcelData("contactDetails", 1, 0));
//		driver.findElement(By.id("last-name")).sendKeys(ef.getExcelData("contactDetails", 1, 1));
//		driver.findElement(By.id("postal-code")).sendKeys(ef.getExcelData("contactDetails", 1, 2));
		cp.lastNameTextField(ef.getExcelData("contactDetails", 1, 1));
		cp.postalCodeTextField(ef.getExcelData("contactDetails", 1, 2));
		Thread.sleep(1500);
		driver.findElement(By.name("continue")).click();
		driver.findElement(By.xpath("//button[text()='Finish']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("back-to-products")).click();
		driver.navigate().to("https://www.saucedemo.com/");
		Thread.sleep(1000);
		driver.close();

	}

}
