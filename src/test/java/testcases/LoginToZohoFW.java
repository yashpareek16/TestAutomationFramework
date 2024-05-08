package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class LoginToZohoFW extends BaseClass {

	@Test
	public static void loginToZoho() throws InterruptedException {

		assertEquals(driver.getTitle(), "Zoho | Cloud Software Suite for Businesses");
		driver.findElement(By.xpath("//a[@class='login']")).click();
		assertEquals(driver.getTitle(), "Zoho Accounts");
		WebElement userName = driver.findElement(By.xpath("//input[@id='login_id']"));
		userName.click();
		userName.sendKeys("yashpareek148@gmail.com");
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.click();
		password.sendKeys("Y1234$hpareek");
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		assertEquals(driver.getTitle(), "Explore All Products | Zoho");
		driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div/div/div[3]/div/div[4]/div/div/img")).click();
		driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div/div/div[3]/div/div[4]/div/div/div/ul/li[5]/a"))
				.click();

	}

}
