package com.bankguru.login;

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

public class Level_02_Register_Login_BasePage_1 extends BasePage{
	WebDriver driver;
	String UserId, Password, loginPageUrl;
	String projectLocation = System.getProperty("user.dir");

	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver",
				projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		 
		getBasePage();
	}

	@Test
	public void Login_01_Register_To_System() {
		loginPageUrl = getPageUrl(driver);

		clickToElement(driver, "//a[text()='here']");
		
		sendkeyToElement(driver, "//input[@name='emailid']", getRandomEmail());

		clickToElement(driver, "//input[@type='submit']");


		UserId = getElementText(driver, "//td[text()='User ID :']//following-sibling::td");
		Password = getElementText(driver,"//td[text()='Password :']//following-sibling::td");

	}
	
	@Test
	public void Login_02_Login_To_System() {

		openPageUrl(driver, loginPageUrl);
		sendkeyToElement(driver, "//input[@name='uid']", UserId);
		sendkeyToElement(driver, "//input[@name='password']", Password);
		clickToElement(driver,"//input[@name='btnLogin']");
		Assert.assertEquals(getElementText(driver, "//marquee[@class='heading3']"),"Welcome To Manager's Page of Guru99 Bank");

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

}
