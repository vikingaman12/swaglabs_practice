package scripts;

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

public class TestCase1 {
	
	public static void main(String[] args) throws Throwable {
		
		/*
		 * To fetch common data from property file,Excel File
		 */
		PropertyFile plib = new PropertyFile();
		ExcelFile ef = new ExcelFile();
		
		/*
		 *(33-55) With this you can open any browser, you just need to change the
		 * browser name in commonData.properties
		 */
		String BROWSER = plib.getPropertyKeyValue("browser");
		WebDriver driver;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
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
