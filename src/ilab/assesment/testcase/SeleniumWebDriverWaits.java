package ilab.assesment.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWebDriverWaits {
	

	static String geckoPath = System.getProperty("user.dir") + "/lib/geckodriver.exe";
	static WebDriver driver;
	static String url = "http://the-internet.herokuapp.com/";
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", geckoPath);

		driver = new FirefoxDriver();
		driver.get(url);
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("username"))).sendKeys("tomsmith");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))).sendKeys("SuperSecretPassword!");
		wait.until(ExpectedConditions.elementToBeClickable(By.className("radius"))).click();
		
		
		//driver.quit();
	}
	
	

}
