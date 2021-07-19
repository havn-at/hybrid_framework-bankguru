package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.HomePageUI;

public class HomePageObject extends BasePage{

	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isHomePageSliderDisplayed() {
		waitForELementVisible(driver, HomePageUI.HOME_PAGE_SLIDER);
		return isElementDisplayed(driver, HomePageUI.HOME_PAGE_SLIDER);
	}

	public void clickToRegisterLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		
	}

}
