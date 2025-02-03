package testcases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginToZoho {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.zoho.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();

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
		driver.quit();
	}

}
