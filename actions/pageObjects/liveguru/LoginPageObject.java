package pageObjects.liveguru;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.liveguru.LoginPageUI;

public class LoginPageObject extends BasePage {

	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForELementVisible(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_ADDRESS_TEXTBOX, emailAddress);
	
	}

	public void enterToPasswordTextbox(String password) {
		waitForELementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	
	}

	public void clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	public void loginToSystem(String emailAddress, String password ) {
		enterToEmailTextbox(emailAddress);
		enterToPasswordTextbox(password);
		clickToLoginButton();
	}
	public String getEmptyEmailErrorMessage() {
		waitForELementVisible(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_EMAIL_ERROR_MESSAGE);
	
	}

	public String getEmptyPasswordErrorMessage() {
		waitForELementVisible(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.EMPTY_PASSWORD_ERROR_MESSAGE);
	
	}

	public String getInvalidEmailErrorMessage() {
		waitForELementVisible(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_ERROR_MESSAGE);
	
	}

	public String getInvalidPasswordErrorMessage() {
		waitForELementVisible(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_PASSWORD_ERROR_MESSAGE);
	
	}

	public String getInvalidEmailOrPasswordErrorMessage() {
		waitForELementVisible(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, LoginPageUI.INVALID_EMAIL_OR_PASSWORD_ERROR_MESSAGE);
	
	}
	
}
