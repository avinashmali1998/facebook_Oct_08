package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
	
	// Variable : WebElement : Login Or sign Up Page
	
		@FindBy (xpath = "//div[@class='_9nq2 marginBottom16px']")
		private WebElement forgotMessage;
		
		@FindBy (xpath = "//input[@type='text']")
		private WebElement emailOrMobile;
		
		@FindBy (xpath = "//button[@value='1']")
		private WebElement search;
		
		@FindBy (xpath = "(//a[@role='button'])[1]")
		private WebElement cancel;
		
		// Constructor : Initilization Of WebElement : Login Or Sign Up Page
		
		public ForgotPasswordPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		// Method : Action On WebElement Login or Sign Up page
		
		public void getForgotWindowMessage()
		{
			String Text = forgotMessage.getText();
			System.out.println(Text);
		}
		
		public void sendEmailOrMobile()
		{
			emailOrMobile.sendKeys("absvduj");
			// or Mouse action can perform
		}
		
		
		public void clickOnSearch()
		{
			search.click();
		}
		
		public void clickOnCancelButton()
		{
			cancel.click();
		}
		

}
