package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.IndexPage;
import pages.MyAccount;
import pages.RegisterUser;
import utilities.RandomStringGenerator.TYPE;

public class TestCases extends BaseClass {

	@Test(enabled = true)
	public void verifyRegisterAndLogIn() {
//---------------------create objects of page classes--------------------------
		IndexPage indexPage = new IndexPage(driver);
		MyAccount myAccount = new MyAccount(driver);
		RegisterUser registerUser = new RegisterUser(driver);

//-----------------input Data------------------
		String firstName = rsg.generateRandomString(4, TYPE.A);
		String lastName = rsg.generateRandomString(4, TYPE.A);
		String emailId = firstName + "@" + lastName + ".com";

		WebElement[] webElements = { registerUser.checkBoxMr, registerUser.firstName, registerUser.lastName,
				registerUser.password, registerUser.daysSelect, registerUser.monthsSelect, registerUser.yearsSelect };

		String[] userDetails = { "", firstName, lastName, "1234Y@sh", "2", "5", "1999" };

//------------------page title verification of index page and click on sign in-----------------
		assertEquals("My Shop", driver.getTitle());
		logger.info("Successfully Verify the index page title.");

		indexPage.clickOnSignIn();
		logger.info("Successfully clicked on the signIn.");

//-------------------verification of  login page and enter the email id and click on submit button------------------
		assertEquals("Login - My Shop", driver.getTitle());
		logger.info("Successfully Verify the login page title.");

		myAccount.enterCreateEmailId(emailId);
		logger.info("Successfully Entered the Email Id.");

		myAccount.clickSubmitButton();
		logger.info("Successfully Clicked On The Submit Button.");

//--------------------verification of register user page and enter the all user details and click on submit button-----------------
		String pageTitle = "Your personal information";
		registerUser.myAccountPageVerification(pageTitle);
		logger.info("Successfully Verify the Register user page title.");

		registerUser.enterDetailsInRegisterUserWindow(webElements, userDetails);
		logger.info("Successfully Entered the All user Details");

		registerUser.clickOnSubmitButton();
		logger.info("Successfully  click on the submit button.");

		String userVerification = firstName + " " + lastName;
		assertEquals(userVerification.toLowerCase(), registerUser.userName.getText().toLowerCase());
		logger.info("Successfully Verify the User Name");

	}

	@Test(enabled = true)
	public void loginUser() {
		IndexPage indexPage = new IndexPage(driver);
		MyAccount myAccount = new MyAccount(driver);
		RegisterUser registerUser = new RegisterUser(driver);

		String email = "Vymy@MGRb.com";
		String pass = "1234Y@sh";
		String firstName = "Vymy";
		String lastName = "MGRb";

		indexPage.clickOnSignIn();
		logger.info("Successfully clicked on the signIn.");

		myAccount.enterLogInEmailId(email);
		logger.info("Successfully entered email id.");

		myAccount.enterLogInPassword(pass);
		logger.info("Successfully entered password.");

		myAccount.clickLogInButton();
		logger.info("Successfully clicked on the login button.");

		String userVerification = firstName + " " + lastName;
		assertEquals(userVerification.toLowerCase(), registerUser.userName.getText().toLowerCase());
		logger.info("Successfully Verify the User Name");
	}

}
