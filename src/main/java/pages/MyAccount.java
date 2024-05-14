package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePage.BasePage;

public class MyAccount extends BasePage {

	// Initialize web driver instance in constructor
	public MyAccount(WebDriver rDriver) {
		lDriver = rDriver;

		PageFactory.initElements(lDriver, this);
	}

	// ***********Identify WebElements****************
	@FindBy(id = "email_create")
	WebElement createEmailId;

	@FindBy(id = "SubmitCreate")
	WebElement submitButton;

	/**
	 * This Method will enter given email Id in the create email id cell
	 * 
	 * @param emailId you want to enter in create email id cell
	 */
	public void enterCreateEmailId(String emailId) {
		createEmailId.sendKeys(emailId);
	}

	/**
	 * This Method will click submit button
	 */
	public void clickSubmitButton() {
		submitButton.click();
	}

}
