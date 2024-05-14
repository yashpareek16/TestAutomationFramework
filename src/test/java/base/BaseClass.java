package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.compress.archivers.sevenz.SevenZOutputFile;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.RandomStringGenerator;
import utilities.ReadConfig;

public class BaseClass {

// ----------create objects of webdriver and read config class----------------
	public static WebDriver driver;
	public static Logger logger;
	public RandomStringGenerator rsg = new RandomStringGenerator();

	ReadConfig readConfig = new ReadConfig();

// -----------------read the value of url and browserName from properties file----------------
	String url = readConfig.getURL();
	String browserName = readConfig.getBrowser();

//------------------setUp the browser and open the site------------------
	@BeforeClass
	public void setUp() {

		// ---------------compare browserName and open the browser
		// accordingly---------------
		if (browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(url);

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(url);

		}

// -----------implicitly wait of 10 sec.----------------
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//----------------initialize the logger object----------------
		logger = LogManager.getLogger("TestAutomationFrameWork");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

	/**
	 * This Method will captureSereenshot
	 * 
	 * @param driver   object of driver
	 * @param testName
	 */
	public void captureScreenshot(WebDriver driver, String testName) {

		TakesScreenshot screenshot = (TakesScreenshot) driver;

		File src = screenshot.getScreenshotAs(OutputType.FILE);

		File dest = new File(System.getProperty("user.dir" + "//Screenshots//" + testName + ".png"));

		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}