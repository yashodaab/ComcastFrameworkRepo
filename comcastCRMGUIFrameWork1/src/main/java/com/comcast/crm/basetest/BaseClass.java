package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	
	public DataBaseUtility dblib = new DataBaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver;
	public static WebDriver sdriver;

	@BeforeSuite // (groups = { "smokeTest", "regressionTest" })
	public void configBS() {
		System.out.println("Coonect to db and report config");
//		dblib.getDBConnection();

	}

	// @Parameters("BROWSER")
	@BeforeClass(groups = { "smokeTest", "regressionTest" })
	public void configBC(/* String browser */) throws Throwable {
	
		System.out.println("launch browser");
		// String BROWSER = browser;
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		if (BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			}
		else if (BROWSER.equalsIgnoreCase("firefoxe")) 
		{
			driver = new FirefoxDriver();
		} 
		else if (BROWSER.equalsIgnoreCase("edge")) 
		{
			driver = new EdgeDriver();
		} 
		else {
			driver = new ChromeDriver();
		}
		sdriver = driver;
		UtilityClassObject.setDriver(driver);

	}

	@BeforeMethod // (groups = { "smokeTest", "regressionTest" })
	public void configBM() throws Throwable {
		System.out.println("login script");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod // (groups = { "smokeTest", "regressionTest" })
	public void configAM() throws InterruptedException {
		System.out.println("logout script");
		HomePage hp = new HomePage(driver);
		hp.LogOutFromApp(driver);
	}

	@AfterClass // (groups = { "smokeTest", "regressionTest" })
	public void configAC() {
		System.out.println("close browser");
		driver.quit();
	}

	@AfterSuite // (groups = { "smokeTest", "regressionTest" })
	public void configAS() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("close db and report backup");
//		dblib.closeDBConnection();

	}
}