package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends BasePage {

	// Initialize web driver instance in constructor
	public MyAccount(WebDriver rDriver) {
		super(rDriver);
	}

	// ***********Identify WebElements****************
	@FindBy(id = "email_create")
	WebElement createEmailId;

	@FindBy(id = "SubmitCreate")
	WebElement submitButton;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "SubmitLogin")
	WebElement logInButton;

	/**
	 * This Method will enter given email Id in the create email id cell
	 * 
	 * @param emailId you want to enter in create email id cell
	 */
	public void enterCreateEmailId(String emailId) {
		createEmailId.sendKeys(emailId);
	}

	/**
	 * This Method will enter given email Id in the login email id cell
	 * 
	 * @param emailId you want to enter in login email id cell
	 */
	public void enterLogInEmailId(String emailId) {
		email.sendKeys(emailId);
	}

	/**
	 * This Method will enter given email Id in the login email id cell
	 * 
	 * @param emailId you want to enter in login email id cell
	 */
	public void enterLogInPassword(String pass) {
		password.sendKeys(pass);
	}

	/**
	 * This Method will click submit button
	 */
	public void clickSubmitButton() {
		submitButton.click();
	}

	/**
	 * This Method will click login button
	 */
	public void clickLogInButton() {
		logInButton.click();
	}

}
