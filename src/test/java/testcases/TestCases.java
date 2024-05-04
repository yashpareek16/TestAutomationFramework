package testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.*;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.IndexPage;
import pages.MyAccount;

public class TestCases extends BaseClass {

	Logger logger = LogManager.getLogger("TestCases");

//	IndexPage indexPage;
//	MyAccount myAccount;
//
//	@Initialized
//	public TestCases() {
//		indexPage = new IndexPage(driver);
//		myAccount = new MyAccount(driver);
//	}

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

	}

}
