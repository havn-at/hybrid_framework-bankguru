package com.liveguru;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.BasePage;
import common.BaseTest;
import pageObjects.liveguru.HomePageObject;
import pageObjects.liveguru.LoginPageObject;
import pageObjects.liveguru.MyDashboardPageObject;


public class Level_04_Register_Login_Multiple_Browser extends BaseTest {
	WebDriver driver;
	String emailAddress, password;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		
		driver = getBrowserDriver(browserName, appUrl);
						
	}

	@Test
	public void Login_01_Empty_Email_And_Password() {
		homePage = new HomePageObject(driver);
		//step 2: click My Account
		homePage.clickToMyAccountFooterLink();
		loginPage = new LoginPageObject(driver);
		
		// Enter data
		loginPage.loginToSystem("","");
		
		// verify notification
		Assert.assertEquals(loginPage.getEmptyEmailErrorMessage(), "This is a required field.");
		Assert.assertEquals(loginPage.getEmptyPasswordErrorMessage(), "This is a required field.");

	}
	
	//@Test
	public void Login_02_Invalid_Email() {
		loginPage.refreshCurrentPage(driver);
		// Enter data
		loginPage.loginToSystem("123@456.789","123456");
		Assert.assertEquals(loginPage.getInvalidEmailErrorMessage(), "Please enter a valid email address. For example johndoe@domain.com.");

		
	}
	//@Test(description = "Password less than 6 chars")
	public void Login_03_Invalid_Password() {
		loginPage.refreshCurrentPage(driver);
		// Enter data
		loginPage.loginToSystem("dam@gmail.com","123");
		Assert.assertEquals(loginPage.getInvalidPasswordErrorMessage(), "Please enter 6 or more characters without leading or trailing spaces.");

		
	}
	//@Test(description = "Email not exist in system")
	public void Login_04_Incorrect_Email() {
		loginPage.refreshCurrentPage(driver);
		// Enter data
		loginPage.loginToSystem(getRandomEmail(),"123456");
		
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");

		
	}
	//@Test(description = "Password is incorrect")
	public void Login_05_Incorrect_Password() {
		loginPage.refreshCurrentPage(driver);
		// Enter data
		loginPage.loginToSystem("dam@gmail.com","111111");
		Assert.assertEquals(loginPage.getInvalidEmailOrPasswordErrorMessage(), "Invalid login or password.");

		
	}
	@Test(description = "Login success in system")
	public void Login_06_Valid_Email_And_Password() {
		loginPage.refreshCurrentPage(driver);
		// Enter data
		loginPage.loginToSystem("havn1409@gmail.com","Ngocha123456@");

		// chuyen trang My dashboard
		myDashboardPage = new MyDashboardPageObject(driver);
		
		Assert.assertTrue(myDashboardPage.isMyDashboardDisplayed());
	}
	public String getRandomEmail() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		return "testing" + ran.nextInt(999999) + "@gmail.com";
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboardPage;
	
}
