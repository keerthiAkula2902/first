package org.mywrapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.driver.DriverHandle;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.io.Files;

public class FirstWrapper extends DriverHandle {
	public void sendinput(WebElement we, String ip) {
		we.sendKeys(ip);

	}

	public void clicking(WebElement we) {
		we.click();

	}

	public void takeScreenhot(WebDriver driver) throws IOException {
		LocalDateTime currentDate = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
		String timestamp = currentDate.format(formatter).toString().replaceAll(" ", "-").replaceAll(":", "_");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String fileName = "ak_" + timestamp + ".png";
		Files.copy(scrFile, new File("C:\\Users\\U1133463\\eclipse-workspace\\FrameWorkP\\Screenshots\\" + fileName));

	}

}
