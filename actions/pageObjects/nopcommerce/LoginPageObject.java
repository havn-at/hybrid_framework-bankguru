package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.LoginPageUI;

public class LoginPageObject extends BasePage {
	private WebDriver driver;
	PageGeneratorManager pageGenerator;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterToEmailTextbox(String emailAddress) {
		waitForELementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void enterToPasswordTextbox(String password) {
		waitForELementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	
	}

	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getHomePage(driver);
	}

}
