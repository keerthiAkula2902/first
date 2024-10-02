package org.driver;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DriverHandle {

	Logger log = LogManager.getLogger(DriverHandle.class);
	public static WebDriver driver = new ChromeDriver();
	// driver. handle

	@BeforeSuite
	public void launch() {

		driver.manage().window().maximize();
		log.info("Launching application");
		driver.get("https://www.amazon.in/");

	}

	@AfterSuite
	public void closing() throws InterruptedException {
		log.info("closing the application");
		Thread.sleep(3000);
	//	driver.quit();

	}

}
