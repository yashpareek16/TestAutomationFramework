package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.IndexPage;
import pages.MyAccount;

public class TestCases extends BaseClass {

	@Test
	public void verifyRegisterAndLogIn() {

		IndexPage indexPage = new IndexPage(driver);
		MyAccount myAccount = new MyAccount(driver);

		indexPage.clickOnSignIn();
		logger.info("Successfully clicked on the signIn.");

		myAccount.enterCreateEmailId("nesag90406@agafx.com");
		logger.info("Successfully Entered the Email Id.");

		myAccount.clickSubmitButton();
		logger.info("Successfully Clicked On The Submit Button.");

		String pageTitle = "Login - My Shop";
		if (driver.getTitle().equalsIgnoreCase(pageTitle)) {
			logger.info("Successfully Verify The Page Title of login My shop page.");
		} else {
			logger.error("Failled to Verify The Page Title of login My shop page.");
		}
	}

}
