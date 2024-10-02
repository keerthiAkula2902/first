package org.mytests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.driver.DriverHandle;
import org.function.Mainfunctionalities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTests extends DriverHandle {
	Mainfunctionalities mf = new Mainfunctionalities();
	private static final Logger logger = LogManager.getLogger(MyTests.class);

	@Test
	public void titleTest() {
		mf.getTitle();

	}

	@Test(dependsOnMethods = "titleTest")
	public void loginTest() throws IOException {
		// logger.info("*********logging the logs");
		mf.loginM();

	}

	@Test(dependsOnMethods = "loginTest")
	public void addingItems() throws IOException {
		mf.addItems();

	}

}
