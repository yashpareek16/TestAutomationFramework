package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import basePage.BasePage;

public class RegisterUser extends BasePage {

	public enum GENDER {
		MALE, FEMALE;
	}

	// ***********Identify WebElements****************
	@FindBy(id = "id_gender1")
	WebElement checkBoxMr;

	@FindBy(id = "id_gender2")
	WebElement checkBoxMrs;

	@FindBy(id = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	WebElement lastName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(id = "days")
	WebElement days;

	@FindBy(id = "months")
	WebElement months;

	@FindBy(id = "years")
	WebElement years;

	@FindBy(id = "newsletter")
	WebElement newLetterCheckBox;

	@FindBy(id = "submitAccount")
	WebElement registerButton;

	/**
	 * 
	 * This Method will select the Mr. or Mrs. checkBox based on the Input
	 * 
	 * @param gender pass "male" if you want to select Mr. else "female" using
	 *               GENDER Enum
	 */
	public void selectGender(GENDER gender) {
		if (GENDER.MALE.equals(gender)) {
			checkBoxMr.click();
		} else {
			checkBoxMrs.click();
		}
	}

	/**
	 * This Method will enter the first and lastname based on the given input
	 * 
	 * @param fName
	 * @param lName
	 */
	public void enterFirstAndLastName(String fName, String lName) {
		if (!(fName.equalsIgnoreCase("") && lName.equalsIgnoreCase(""))) {
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
		} else {
			System.out.println("please give the firstname or lastname");
		}
	}

}
