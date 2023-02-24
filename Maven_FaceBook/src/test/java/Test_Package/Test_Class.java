package Test_Package;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import Pom_Classes.CreateNewAccountPage;
import Pom_Classes.ForgotPasswordPage;
import Pom_Classes.LoginOrSignUpPage;

public class Test_Class {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Avinash\\OneDrive\\Documents\\Automation\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driverTest = new ChromeDriver();
		driverTest.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driverTest.get("https://www.facebook.com/");
		
		LoginOrSignUpPage loginOrSignUpPage = new LoginOrSignUpPage(driverTest);
		
		loginOrSignUpPage.sendemailorPhoneNumber();
		loginOrSignUpPage.sendpassword();
//		loginOrSignUpPage.clickloginButton();
//		loginOrSignUpPage.clickforgotPasswordLink();
		loginOrSignUpPage.openSignUpForm();
//		
//		ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driverTest);
//		forgotPasswordPage.getForgotWindowMessage();
//		forgotPasswordPage.sendEmailOrMobile();
//		forgotPasswordPage.clickOnSearch();
//		forgotPasswordPage.clickOnCancelButton();
//		
		CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(driverTest);
		
		createNewAccountPage.sendFirstName();
		createNewAccountPage.sendSurName();
		createNewAccountPage.sendMobOrEmailAddress();
		createNewAccountPage.sendNewPassword();
		createNewAccountPage.selectDay();
		createNewAccountPage.selectMonth();
		createNewAccountPage.selectYear();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
