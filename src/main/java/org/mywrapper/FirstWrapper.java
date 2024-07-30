package org.mywrapper;

import org.openqa.selenium.WebElement;

public class FirstWrapper {
	public void sendinput(WebElement we,String ip) {
		we.sendKeys(ip);
		

	}
	public void clicking(WebElement we) {
		we.click();
		
	}

}
