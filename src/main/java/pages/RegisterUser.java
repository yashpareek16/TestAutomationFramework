package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basePage.BasePage;

public class RegisterUser extends BasePage {

	// Initialize web driver instance in constructor
	public RegisterUser(WebDriver rDriver) {
		lDriver = rDriver;

		PageFactory.initElements(lDriver, this);
	}

	public enum GENDER {
		MALE, FEMALE;
	}

	// ***********Identify WebElements****************
	@FindBy(id = "id_gender1")
	public WebElement checkBoxMr;

	@FindBy(id = "id_gender2")
	public WebElement checkBoxMrs;

	@FindBy(id = "customer_firstname")
	public WebElement firstName;

	@FindBy(id = "customer_lastname")
	public WebElement lastName;

	@FindBy(id = "passwd")
	public WebElement password;

	@FindBy(id = "days")
	public WebElement daysSelect;

	@FindBy(id = "months")
	public WebElement monthsSelect;

	@FindBy(id = "years")
	public WebElement yearsSelect;

	@FindBy(id = "newsletter")
	public WebElement newLetterCheckBox;

	@FindBy(id = "submitAccount")
	public WebElement registerButton;

	@FindBy(className = "page-subheading")
	public WebElement accountCreationHeading;

	@FindBy(className = "account")
	public WebElement userName;

	/**
	 * This Method Will Verify The Account Creation Page Heading.
	 * 
	 * @param verifyHeading Expected Heading
	 */
	public void myAccountPageVerification(String verifyHeading) {
		String pageHeading = accountCreationHeading.getText();
		if (pageHeading.equalsIgnoreCase(verifyHeading)) {
			System.out.println("Successfully Verify The Account Creation Page Title. which is " + verifyHeading);
		} else {
			System.err.println("Failled To Verify The  Account Creation Page Title. Expected Heading title is "
					+ verifyHeading + " But Found " + pageHeading);
		}
	}

//	/**
//	 * 
//	 * This Method will select the Mr. or Mrs. checkBox based on the Input
//	 * 
//	 * @param gender pass "male" if you want to select Mr. else "female" using
//	 *               GENDER Enum
//	 */
//	public void selectGender(GENDER gender) {
//		if (GENDER.MALE.equals(gender)) {
//			checkBoxMr.click();
//		} else {
//			checkBoxMrs.click();
//		}
//	}
//
//	/**
//	 * This Method will enter the first and lastname based on the given input
//	 * 
//	 * @param fName
//	 * @param lName
//	 */
//	public void enterFirstAndLastName(String fName, String lName) {
//		if (!(fName.equalsIgnoreCase("") && lName.equalsIgnoreCase(""))) {
//			firstName.sendKeys(fName);
//			lastName.sendKeys(lName);
//		} else {
//			System.out.println("please give the firstname or lastname");
//		}
//	}
//
//	/**
//	 * This Method will enter the given password
//	 * 
//	 * @param pwd password you want to enter
//	 */
//	public void enterPassword(String pwd) {
//		if (pwd == "") {
//			System.err.println("Please give the password.");
//		} else {
//			password.sendKeys(pwd);
//		}
//	}

	/**
	 * This method will enter all the given details in RegisterUser Window
	 * 
	 * @param listOfWebElement array of all the webelements of Register User Window
	 *                         where you want to enter the user details
	 * @param userDetails      array of all the user Details you want to enter in
	 *                         the Register User Window
	 */
	public void enterDetailsInRegisterUserWindow(WebElement[] listOfWebElement, String[] userDetails) {
//----------------verify the length of the both arguments if it is same then enter the details else error
		if (listOfWebElement.length != userDetails.length) {
			System.err.println("given parameters webelements and userdetails in not same in the length.");
		} else {
			for (int iterator = 0; iterator < userDetails.length; iterator++) {
//---------------------store the details in variables----------------------------------
				WebElement element = listOfWebElement[iterator];
				String elementType = element.getAttribute("type");
				String detail = userDetails[iterator];

//----------------------------------enter the details bases on the element type--------------------
				if (elementType.contains("select")) {
					Select selObj = new Select(element);
					selObj.selectByValue(detail);
				} else if (elementType.contains("radio")) {
					element.click();
				} else {
					element.sendKeys(detail);
				}
			}
		}

		return;

	}

	/**
	 * This Method Will Click On Submit Button
	 */
	public void clickOnSubmitButton() {
		registerButton.click();
	}

}
