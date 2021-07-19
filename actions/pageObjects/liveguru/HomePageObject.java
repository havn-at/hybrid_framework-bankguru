package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveguru.HomePageUI;

public class HomePageObject extends BasePage {

	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountFooterLink() {
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
	}
	
}
