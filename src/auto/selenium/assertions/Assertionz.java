package auto.selenium.assertions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Assertionz {

	static String geckoPath = System.getProperty("user.dir") + "/lib/geckodriver.exe";
	static WebDriver driver;
	static String url = "http://the-internet.herokuapp.com/";

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", geckoPath);
		driver = new FirefoxDriver();
		driver.get(url);
		veriftPageTitle();
		success();
		unsuccesful();

	}

	private static void veriftPageTitle() {
		String pageTitle = driver.getTitle();
		System.out.println("The name of this title is " + pageTitle);
	}

	private static void success() {
		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "The Internet");
		System.out.println("successful");

	}

	private static void unsuccesful() {
		String pageTitle = driver.getTitle();
		Assert.assertNotSame(pageTitle, "TheInternet");
		System.out.println("unsuccessful");
		

	}

}
