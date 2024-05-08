package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePage.BasePage;

public class IndexPage extends BasePage {

	// Initialize web driver instance in constructor
	public IndexPage(WebDriver rDriver) {
		lDriver = rDriver;

		PageFactory.initElements(lDriver, this);
	}

	// Identify WebElements
	@FindBy(linkText = "Sign in")
	WebElement signIn;

	// Identify Action On WebElement
	public void clickOnSignIn() {
		signIn.click();
	}

}
