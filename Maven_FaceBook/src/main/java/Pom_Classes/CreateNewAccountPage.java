package Pom_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewAccountPage {
	
	// Variable : WebElement : CreateNewAccountPage
	
	@FindBy (xpath = "//input[@name='firstname']")
	private WebElement firstName;
			
	@FindBy (xpath = "//input[@name='lastname']")
	private WebElement surName;
			
	@FindBy (xpath = "//input[@name='reg_email__']")
	private WebElement mobOrEmailAddress;
			
	@FindBy (xpath = "(//input[@type='password'])[2]")
	private WebElement newPassword;
	
	@FindBy (xpath = "//select[@id='day']")
	private WebElement selectDay;
	
	@FindBy (xpath = "//select[@id='month']")
	private WebElement selectMonth;
	
	@FindBy (xpath = "//select[@id='year']")
	private WebElement selectYear;
	
	@FindBy (xpath = "//a[@id='terms-link']")
	private WebElement terms;
	
	@FindBy (xpath = "//a[@id='privacy-link']")
	private WebElement privacyPolicy;
	
	@FindBy (xpath = "//a[@id='cookie-use-link']")
	private WebElement cookiesPolicy;
	
	
	
// Constructor : Initilization Of WebElement : CreateNewAccountPage
	
	public CreateNewAccountPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
// Method : Action On WebElement CreateNewAccountPage
// for select method we can't create one select method because we need pass give argument			
	
	public void sendFirstName()
	{
		firstName.sendKeys("Avinash");
	}
	
	public void sendSurName()
	{
		surName.sendKeys("Mali");
	}
	
	public void sendMobOrEmailAddress()
	{
		mobOrEmailAddress.sendKeys("demo@gmail.com");
	}
	
	public void sendNewPassword()
	{
		newPassword.sendKeys("1245");
	}
	
	
	public void selectDay()
	{
		Select s = new Select(selectDay);
		s.selectByValue("29");
	}	
	
			
	public void selectMonth()
	{
		Select s = new Select(selectMonth);
		s.selectByVisibleText("Oct");
	}
	
	
	public void selectYear()
	{
		Select s = new Select(selectYear);
		s.selectByValue("1998");
	}	
	
	public void clickOnTerms()
	{
		terms.click();
	}
	
	public void clickOnPrivacyPolicy()
	{
		privacyPolicy.click();
	}
	
	public void clickOnCookiesPolicy()
	{
		cookiesPolicy.click();
	}
			
			
			
			
}
