package com.nopcommerce.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import common.BasePage;
import pageObjects.nopcommerce.HomePageObject;
import pageObjects.nopcommerce.LoginPageObject;
import pageObjects.nopcommerce.RegisterPageObject;

public class Level_01_Register_Login_PageObject {
	WebDriver driver;
	String emailAddress, password;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver",
				projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		emailAddress = getRandomEmail();
		password = "123456";
	}

	@Test
	public void Login_01_Register_To_System() {
		//step 1: open url
		driver.get("https://demo.nopcommerce.com/");
		homePage = new HomePageObject(driver);
		//step 2: verify homepage logo displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());		
		
		//step 3: click to register link -> mo register page
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);
		//step 4: click to Gender radio
		registerPage.clickToGenderMaleRadioButton();
		//step 5: input firstname
		registerPage.enterToFirstNameTextbox("John");
		//step 6: input lastname
		registerPage.enterToLastNameTextbox("Terry");
		//step 7: input email
		registerPage.enterToEmailTextbox(emailAddress);
		//step 8: input password
		registerPage.enterToPasswordTextbox(password);
		
		//step 9: input confirmpassword
		registerPage.enterToConfirmPasswordTextbox(password);
		//step 10: click to register button
		registerPage.clickToRegisterButton();

		//step 11: verify success message displayed
		Assert.assertTrue(registerPage.isSuccessMessageDisplayed());
		//step 12: click logout link -> homepage
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);
		//step 13: verify homepage logo displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
	
	
	}
	
	@Test
	public void Login_02_Login_To_System() {
		//step 1: click to register Link
		homePage.clickToLoginButton();
		loginPage = new LoginPageObject(driver);
		
		//step 2: input email textbox
		loginPage.enterToEmailTextbox(emailAddress);
		//step 3: input password
		loginPage.enterToPasswordTextbox(password);
		//step 4: click login button
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);
		
		//step 5: verify homepage logo displayed
		Assert.assertTrue(homePage.isHomePageSliderDisplayed());
		
	}

	public String getRandomEmail() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		return "testing" + ran.nextInt(999999) + "@gmail.com";
	}
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
}
