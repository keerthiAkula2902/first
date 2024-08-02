package org.function;

import java.io.IOException;
import java.time.Duration;

import org.driver.DriverHandle;
import org.mywrapper.FirstWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Mainfunctionalities extends DriverHandle {
	FirstWrapper fw = new FirstWrapper();
	public static String login_id = "8125255779";
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

	String title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

	public void getTitle() {
		// wait.until(ExpectedConditions.titleIs("Amazon Sign In"));
		Assert.assertEquals(driver.getTitle(), title, "verified title");

	}

	public void loginM() throws IOException {

		final String pwd = "Su*ananda@123";
		getTitle();
		WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Hello, sign in')]"));
		fw.clicking(login);
		wait.until(ExpectedConditions.urlContains("signin?"));
		WebElement we = driver.findElement(By.xpath("//input[@id='ap_email_login']"));
		fw.sendinput(we, login_id);
		we = driver.findElement(By.id("continue"));
		fw.clicking(we);

	//	verifyElementPresent();
		wait.until(ExpectedConditions.urlToBe("https://www.amazon.in/ap/signin"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.in/ap/signin");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='ap_password']"))));
		we = driver.findElement(By.xpath("//input[@id='ap_password']"));
		fw.sendinput(we, pwd);
		we = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		fw.takeScreenhot(driver);

	}

}
