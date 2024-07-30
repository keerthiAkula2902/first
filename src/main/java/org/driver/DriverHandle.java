package org.driver;

import java.time.Duration;

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

	public static WebDriver driver=new ChromeDriver();
	//driver.
	
	@BeforeSuite
	public void launch() {
		driver.manage().window().maximize();
		
		
		driver.get("https://www.amazon.in/");
		
	}
	@AfterSuite
	public void closing() throws InterruptedException {
	//	Thread.sleep(3000);
		driver.quit();
		
	}

}
