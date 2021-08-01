package common;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;
	private String projectLocation = System.getProperty("user.dir");

	private enum BROWSER {
		CHROME, FIREFOX, IE, SAFARI, EDGE_LEGACY, EDGE_CHROMIUM, H_CHROME, H_FIREFOX;
	}
	
	protected WebDriver getBrowserDriver(String browserName) {
		
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		
		
		if(browser==BROWSER.FIREFOX)
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser==BROWSER.CHROME) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browser == BROWSER.EDGE_CHROMIUM){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Please enter correct browser name");
		}
		
		return driver;
	}
	protected WebDriver getBrowserDriver(String browserName, String Url) {
		BROWSER browser = BROWSER.valueOf(browserName.toUpperCase());
		
		if(browser==BROWSER.FIREFOX)
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browser==BROWSER.CHROME) {
			WebDriverManager.chromedriver().driverVersion("88.0.4324.96").setup();
			driver = new ChromeDriver();
		}else if(browser == BROWSER.EDGE_CHROMIUM){
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else {
			throw new RuntimeException("Please enter correct browser name");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Url);
		return driver;
	}
	
	public String getSlash(String folderName) {
		String separator = File.separator;
		return separator + folderName + separator;
	}

	
}
