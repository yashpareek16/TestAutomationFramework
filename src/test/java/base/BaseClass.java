package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class BaseClass {

// ----------create objects of webdriver and read config class----------------
	public static WebDriver driver;
	// public static Logger logger;

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
			driver.get(url);

		} else if (browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(url);

		}

// -----------implicitly wait of 10 sec.----------------
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

//----------------initialize the logger object----------------
		// logger = LogManager.getLogger("com.webAutomation");
	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}

}