package Pom_Classes;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginOrSignUpPage {

	
	// Variable : WebElement : Login Or sign Up Page
	
		@FindBy (xpath = "//input[@id='email']") 
		private WebElement emailorPhoneNumber;
		
		@FindBy (xpath = "//input[@id='pass']")
		private WebElement password;
		
		@FindBy (xpath = "//button[@type='submit']") 
		private WebElement loginButton;
		
		@FindBy (xpath = "//a[text()='Forgotten password?']")
		private WebElement forgotPasswordLink;
		
		@FindBy (xpath = "(//a[@role='button'])[2]")
		private WebElement createNewAccountButton;
		
		@FindBy (xpath = "//a[text()='Privacy Policy']")
		private WebElement privacyPolicy;
		
		@FindBy (xpath = "//a[text()='Cookies']")
		private WebElement cookies;
		
		@FindBy (xpath = "//a[text()='Messenger']")
		private WebElement messenger;
		
		
		private WebDriver driver;
		private Actions action;
		private WebDriverWait wait;
		private JavascriptExecutor javaScriptExecutor ;
		
		
	// Constructor : Initilization Of WebElement : Login Or Sign Up Page
		
		public LoginOrSignUpPage(WebDriver driver)
		{
			PageFactory.initElements(driver , this);
			this.driver = driver;
			action = new Actions(this.driver);
			wait = new WebDriverWait(driver, 20);
			javaScriptExecutor = (JavascriptExecutor)driver;
		}
		
	// Method : Action On WebElement Login or Sign Up page
		
		public void sendemailorPhoneNumber()
		{
//			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor)driver; // we can used scroll method also like  here
//			javaScriptExecutor.executeScript("arguments[0].ScrollIntoView(true);", emailorPhoneNumber);
			emailorPhoneNumber.sendKeys("njfsjh");
		}
		
		public void sendpassword()
		{
			password.sendKeys("48784");
		}
		
		public void clickloginButton()
		{
			loginButton.click();
		}
		
		public void clickforgotPasswordLink()
		{
			forgotPasswordLink.click();
		}
		
		public void openSignUpForm()
		{
			createNewAccountButton.click();
		}
// i want add explicit wait here 
		public void clickOnPrivacyPolicy()
		{
		//	WebDriverWait wait = new WebDriverWait(driver, 20);  // 20 sec
			wait.until(ExpectedConditions.visibilityOf(privacyPolicy));
			privacyPolicy.click(); 
		} //Wait declared in global
		
		public void clickOnCookies()
		{
		//	WebDriverWait wait = new WebDriverWait(driver, 20);  // 20 sec
			wait.until(ExpectedConditions.visibilityOf(cookies));
			cookies.click();
		}	//Wait declared in global
		
		public void clickOnMessanger()
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);  // 30 sec
			wait.until(ExpectedConditions.visibilityOf(messenger));
			messenger.click();
		} // Wait declared as local for 30 secs
	
	
	
}
