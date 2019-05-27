package ilab.assesment.testcase;

import java.io.FileInputStream;
import java.util.Properties;

import javax.xml.crypto.Data;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import ilab.assesment.utility.BaseDriver;
import ilab.assesment.utility.PhoneNumber;

public class ILabAssesment extends BaseDriver{

	ExtentReports extent;
	ExtentTest test;
	String reporter;
	Properties DataFile;
	private Logger log;

	
	public ILabAssesment() {

	}

	@BeforeTest
	public void reporting() throws Throwable {
		initializeObjects();
		generateReport();
		String os = System.getProperty("os.name").toLowerCase();
		DataFile = new Properties();
		String macFilePath = "/data/DataFile.properties";
		String winFilePath = "\\data\\DataFile.properties";
		
		if (os.contains("mac")) {
			FileInputStream fip = new FileInputStream(System.getProperty("user.dir")+macFilePath);
			DataFile.load(fip);
		}
		
		if (os.contains("windows")) {
			FileInputStream fip = new FileInputStream((System.getProperty("user.dir")+winFilePath));
			DataFile.load(fip);
		}
		
		
	}
	
	//test case steps below
	@Test(priority = 1)
	public void succesfulLogin() throws Throwable {
		//this.log = Logger.getLogger(ILabAssesment.class);
		loadWebBrowser();
		navigateToSite();
		getElemByLinkText(DataFile.getProperty("btnCareers")).click(); //careers
		getElemByLinkText(DataFile.getProperty("country")).click(); //south africa
		getElemByLinkText(DataFile.getProperty("role")).click(); //post
		scrollToView(DataFile.getProperty("applyForm"));
		getElemByCSS(DataFile.getProperty("applyOnline")).click(); //applyonline
		getElemById("applicant_name").sendKeys(DataFile.getProperty("name"));
		getElemById("email").sendKeys(DataFile.getProperty("email"));
		getElemById("phone").sendKeys(new PhoneNumber().mobileNumber());
		scrollToView("wpjb_submit");
		getElemById("wpjb_submit").click(); //submit
		WebElement errorValidation = getElemByCSS("ul.wpjb-errors"); //expectedError
		String errorMessage = errorValidation.getText();
		Assert.assertEquals(errorMessage, "You need to upload at least one file.");
		//log.info(this.getClass().getSimpleName()+" test completed");

	}

	@AfterMethod
	public void getTestResults(ITestResult result) {
		try {
			getResult(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@AfterTest
	public void closeBrowser() {
		killWebBrowser();
	}




}
