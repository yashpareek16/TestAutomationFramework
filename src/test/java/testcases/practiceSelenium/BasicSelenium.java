package testcases.practiceSelenium;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import base.BaseClass;

public class BasicSelenium extends BaseClass {

	@Test
	public void method1() {

		String url = driver.getCurrentUrl();
		assertEquals(url, "http://www.automationpractice.pl/index.php");

		Class<? extends WebDriver> Object = driver.getClass();
		assertEquals(Object.toString(), "class org.openqa.selenium.chrome.ChromeDriver");

		String pageSourse = driver.getPageSource();
		// assertEquals(url, "http://www.automationpractice.pl/index.php");

		String pageTitle = driver.getTitle();
		assertEquals(pageTitle, "My Shop");

		String window = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();
	}

}
