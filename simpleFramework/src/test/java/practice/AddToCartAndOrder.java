package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.*;

//changes
// final scripts are in test/java/scripts folder these are just for  self Understanding and practice 

public class AddToCartAndOrder {

	public static void main(String[] args) throws Throwable {
		String key = "webdriver.chrome.driver";
		String value = "./src/main/resources/chromedriver.exe";
		System.setProperty(key, value);
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.saucedemo.com/");
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		
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

	}

}
