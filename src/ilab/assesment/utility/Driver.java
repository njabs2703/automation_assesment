package ilab.assesment.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
	WebDriver driver;
	
	public Driver() {
		//driver = new FirefoxDriver();
	}


	public WebElement getElemById(String id) {

		WebElement elem = driver.findElement(By.id(id));

		return elem;
	}

	public WebElement getElemByLink(String linkText) {

		WebElement elem = driver.findElement(By.linkText(linkText));

		return elem;
	}
	
	

}
