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

public class Level_01_Register_Login_Repeat {
	WebDriver driver;
	String UserId, Password, loginPageUrl;
	String projectLocation = System.getProperty("user.dir");
	
	@BeforeClass
	public void initBrowser() {
		System.setProperty("webdriver.gecko.driver",projectLocation + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://demo.guru99.com/v4/index.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		loginPageUrl = driver.getCurrentUrl();	
	}

	@Test
	public void Login_01_Register_To_System() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
		
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(getRandomEmail());
	
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		UserId = driver.findElement(By.xpath("//td[text()='User ID :']//following-sibling::td")).getText();
		Password = driver.findElement(By.xpath("//td[text()='Password :']//following-sibling::td")).getText();

	}

	@Test
	public void Login_02_Login_To_System() {
		driver.get(loginPageUrl);
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(UserId);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	
		Assert.assertEquals(driver.findElement(By.xpath("//marquee[@class='heading3']")).getText(), "Welcome To Manager's Page of Guru99 Bank");
	}

	public String getRandomEmail() {
		// TODO Auto-generated method stub
		Random ran = new Random();
		return "testing"+ ran.nextInt(999999)+ "@gmail.com";
	}
	@AfterClass
	public void cleanBrowser() {
		driver.quit();
	}

}
