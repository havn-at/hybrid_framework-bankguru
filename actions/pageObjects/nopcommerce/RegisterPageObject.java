package pageObjects.nopcommerce;

import org.openqa.selenium.WebDriver;

import common.BasePage;
import pageUIs.nopcommerce.RegisterPageUI;

public class RegisterPageObject extends BasePage {
	private WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, RegisterPageUI.GENDER_MALE_RADIO);
		clickToElement(driver, RegisterPageUI.GENDER_MALE_RADIO);
	}

	public void enterToFirstNameTextbox(String firstName) {
		waitForELementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void enterToLastNameTextbox(String lastName) {
		waitForELementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	
	}

	public void enterToEmailTextbox(String emailAddress) {
		waitForELementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	
	}

	public void enterToPasswordTextbox(String Password) {
		waitForELementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, Password);
	
	}

	public void enterToConfirmPasswordTextbox(String confirmPassword) {
		waitForELementVisible(driver, RegisterPageUI.CONFIRM_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_TEXTBOX, confirmPassword);
	
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	
	}

	public boolean isSuccessMessageDisplayed() {
		waitForELementVisible(driver, RegisterPageUI.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, RegisterPageUI.SUCCESS_MESSAGE);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		return PageGeneratorManager.getHomePage(driver);
	}


}
