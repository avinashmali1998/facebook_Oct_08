package Package_TestNg;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Pom_Classes.CreateNewAccountPage;
import Pom_Classes.LoginOrSignUpPage;
import browser.Browser_Set_Up;
import utils.Utility;

public class TestNg_ExecutionClass {
	
	WebDriver driver;
	CreateNewAccountPage createNewAccountPage ;
	SoftAssert soft ;
	private String testID;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName)
	{
		System.out.println("browserName");
		if(browserName.equals("Chrome"))
		{
//			System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\OneDrive\\Documents\\Automation\\chromedriver_win32\\chromedriver.exe");
//			driver = new ChromeDriver();
			driver = Browser_Set_Up.openChromeBrowser();
		}
		if(browserName.equals("Firefox"))
		{
//			System.setProperty("webdriver.gecko.driver","C:\\Users\\Avinash\\OneDrive\\Documents\\Automation\\Selenium\\geckodriver-v0.32.1-win32\\geckodriver.exe");
//			driver = new FirefoxDriver();
			driver = Browser_Set_Up.openFirefoxBrowser();
		}
		if(browserName.equals("Edge"))
		{
//			System.setProperty("webdriver.edge.driver","C:\\Users\\Avinash\\OneDrive\\Documents\\Automation\\Selenium\\edgedriver_win64\\msedgedriver.exe");
//			driver = new EdgeDriver();
			driver = Browser_Set_Up.openEdgeBrowser();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeClass
	public void launchBrowser()
	{
//		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.manage().window().maximize();
		System.out.println("Before Class");
	}
	
	@BeforeMethod
	public void goOnLoginOrSignUpPage() throws EncryptedDocumentException, IOException
	{
		driver.get("https://www.facebook.com/");
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driver);
		loginOrSignUpPage.openSignUpForm();
		String title = driver.getTitle();
		System.out.println("Title = " + title);
		System.out.println("Before Method");
	}
	
	@Test (priority = 0)
	public void verifyTermsLink()
	{
		testID = "TC_001";
		
		
		System.out.println("Test");
		createNewAccountPage = new CreateNewAccountPage(driver);
		createNewAccountPage.clickOnTerms();
		ArrayList<String> addr = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(1));
		String title = driver.getTitle();
		System.out.println("Title = " + title);
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
		
		String ActualUrl = "https://www.facebook.com/legal/terms/update";
		String ExpectedUrl = "https://www.facebook.com/legal/terms/update";
		soft = new SoftAssert();
		soft.assertEquals(ActualUrl, ExpectedUrl ,"Terms Link Not found");
		
		soft.assertAll();
		
//		if(Url.equals("https://www.facebook.com/legal/terms/update"))
//		{
//			System.out.println("Url Pass");
//		}
//		else
//		{
//			System.out.println("Url Fail");
//		}
		
		
	}
	
	@Test (priority = 1)
	public void verifyPrivacyPolicyLink()
	{
		testID = "TC_002";
		
		System.out.println("Test 1");
		createNewAccountPage = new CreateNewAccountPage(driver);
		createNewAccountPage.clickOnPrivacyPolicy();
		ArrayList<String> addr = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(2));
		String title = driver.getTitle();
		System.out.println("Title = " + title);
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
		if(Url.equals("https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0"))
		{
			System.out.println("Url Pass");
		}
		else
		{
			System.out.println("Url Fail");
		}

	}

	@Test (priority = 2)
	public void verifyCookiesPolicyLink()
	{
		
		testID = "TC_003";
		
		System.out.println("Test 2");
		createNewAccountPage = new CreateNewAccountPage(driver);
		createNewAccountPage.clickOnCookiesPolicy();
		ArrayList<String> addr = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(3));
		String title = driver.getTitle();
		System.out.println("Title = " + title);
		String Url = driver.getCurrentUrl();
		System.out.println(Url);
		if(Url.equals("https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0"))
		{
			System.out.println("Url Pass");
		}
		else
		{
			System.out.println("Url Fail");
		}
		
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			Utility.captureScreenShot(driver, testID);
		}
		
		ArrayList<String> addr = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(addr.get(0));
		String title = driver.getTitle();
		System.out.println("Title = " + title);
		System.out.println("After Method");
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
		System.out.println("After Class");
	}
	
	@AfterTest
	public void afterTest()
	{
		System.out.println("@AfterTest");
	}
	
	
	
	
}
