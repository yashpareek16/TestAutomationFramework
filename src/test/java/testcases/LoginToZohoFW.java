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
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='login']")).click();
		Thread.sleep(1000);
		assertEquals(driver.getTitle(), "Zoho Accounts");
		WebElement userName = driver.findElement(By.xpath("//input[@id='login_id']"));
		userName.click();
		Thread.sleep(1000);
		userName.sendKeys("yashpareek148@gmail.com");
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
		password.click();
		password.sendKeys("Y1234$hpareek");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='nextbtn']")).click();
		Thread.sleep(1000);
		assertEquals(driver.getTitle(), "Explore All Products | Zoho");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div/div/div[3]/div/div[4]/div/div/img")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/main/div/div/div[1]/div/div/div[3]/div/div[4]/div/div/div/ul/li[5]/a"))
				.click();
		Thread.sleep(1000);

	}

}
