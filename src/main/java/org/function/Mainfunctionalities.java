package org.function;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.driver.DriverHandle;
import org.mywrapper.FirstWrapper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import excel.utilities.data;

public class Mainfunctionalities extends DriverHandle {
	FirstWrapper fw = new FirstWrapper();
	data d = new data();

	public static String login_id = "";
	public static String pwd = "";
	public static WebElement we;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
	Actions act = new Actions(driver);
	String title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";

	public void getTitle() {
		Assert.assertEquals(driver.getTitle(), title, "verified title");

	}

	public void loginM() throws IOException {

		getTitle();
		WebElement login = driver.findElement(By.xpath("//span[contains(text(),'Hello, sign in')]"));
		fw.clicking(login);
		wait.until(ExpectedConditions.urlContains("signin?"));
		// act.moveToElement(driver.findElement(By.xpath("//input[@id='ap_email_login']"))).build().perform();
		we = driver.findElement(By.xpath("//form[@id='ap_login_form']//input[@id='ap_email_login']"));
		login_id = d.fetchingData("username");
		fw.sendinput(we, login_id);
		we = driver.findElement(By.id("continue"));
		fw.clicking(we);

		// verifyElementPresent();
		wait.until(ExpectedConditions.urlToBe("https://www.amazon.in/ap/signin"));
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.amazon.in/ap/signin");
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[contains(text(),'Sign')]"))));

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@id='ap_password']"))));
		we = driver.findElement(By.xpath("//input[@id='ap_password']"));

		pwd = d.fetchingData("password");
		fw.sendinput(we, pwd);
		we = driver.findElement(By.xpath("//input[@id='signInSubmit']"));
		fw.clicking(we);

		fw.takeScreenhot(driver);
	}

	public void addItems() throws IOException {
		String name = "";
		String item = "";
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(
				"//a[@data-csa-c-content-id='nav_youraccount_btn']//span[@class='nav-line-1 nav-progressive-content']"))));
		name = driver.findElement(By.xpath(
				"//a[@data-csa-c-content-id='nav_youraccount_btn']//span[@class='nav-line-1 nav-progressive-content']"))
				.getText();
		Assert.assertEquals(name, "Hello, Keerthi");
		we = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		act.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).build().perform();
		fw.clicking(we);
		item = d.fetchingData("items");
		System.out.println(item);
		fw.sendinput(we, item);
		List<WebElement> elements = driver
				.findElements(By.xpath("//div[@class='s-suggestion s-suggestion-ellipsis-direction']//span"));

		System.out.println(item);
		for (WebElement element : elements) {
			System.out.println("entering for loop");
			System.out.println(element.getText());
			if (element.getText().equalsIgnoreCase(item)) {
				System.out.println("if case");
				fw.clicking(element);
				break;
			}

		}

	}

}
