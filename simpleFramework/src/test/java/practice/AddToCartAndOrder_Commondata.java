package practice;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//addTocart and order using commonData for login

public class AddToCartAndOrder_Commondata {
	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		FileInputStream fis = new FileInputStream("./src/test/resources/commondata.properties");
		Properties pro = new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		driver.get(URL);
		String UN = pro.getProperty("username");
		driver.findElement(By.id("user-name")).sendKeys(UN);
		String PWD = pro.getProperty("password");
		driver.findElement(By.id("password")).sendKeys(PWD);
		
		driver.findElement(By.xpath("//input[@class='submit-button btn_action']")).click();
		driver.getTitle();
		driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		driver.findElement(By.xpath("//button[@data-test='back-to-products']")).click();
		driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
		driver.findElement(By.id("checkout")).click();
		Thread.sleep(1500);
		driver.findElement(By.id("first-name")).sendKeys("Aman");
		driver.findElement(By.id("last-name")).sendKeys("Ashutosh");
		driver.findElement(By.id("postal-code")).sendKeys("110084");
		Thread.sleep(1500);
		driver.findElement(By.name("continue")).click();
		driver.findElement(By.xpath("//button[text()='Finish']")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("back-to-products")).click();
		driver.navigate().to("https://www.saucedemo.com/");
		Thread.sleep(1000);
		driver.close();
		System.out.println();


	}

}
