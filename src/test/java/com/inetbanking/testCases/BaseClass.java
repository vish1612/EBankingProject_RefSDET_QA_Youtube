package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	static ReadConfig readconfig = new ReadConfig();

	public static String baseURL = readconfig.getApplicationURL();
	public static String username = readconfig.getApplicationUsername();
	public static String password = readconfig.getApplicationPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("Log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
		}
		driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@AfterClass
	public static void tearDown() {
		driver.quit();
	}

	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}

	// public static WebDriver driver;
	// public static Properties prop;

	/*
	 * @BeforeTest public void setup() {
	 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
	 * + "//Drivers//geckodriver.exe"); driver = new FirefoxDriver(); }
	 */

	/*
	 * public BaseClass() { try { prop = new Properties(); FileInputStream ip = new
	 * FileInputStream( System.getProperty("user.dir") +
	 * "//src//main//java//com//inetbanking//config//config.properties");
	 * prop.load(ip); } catch (FileNotFoundException e) { e.printStackTrace(); }
	 * catch (IOException e) { e.printStackTrace(); } }
	 * 
	 * public static void initialization() { String browserName =
	 * prop.getProperty("browser");
	 * 
	 * if (browserName.equals("chrome")) {
	 * System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
	 * + "//Drivers//chromedriver.exe"); driver = new ChromeDriver(); } else if
	 * (browserName.equals("firefox")) {
	 * System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") +
	 * "//Drivers//geckodriver.exe"); driver = new FirefoxDriver(); }
	 * 
	 * driver.manage().window().maximize(); driver.manage().deleteAllCookies();
	 * driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 * 
	 * driver.get(prop.getProperty("Url")); }
	 * 
	 * public static void tearDown() { driver.quit(); }
	 */
}