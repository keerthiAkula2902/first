package org.mytests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.driver.DriverHandle;
import org.function.Mainfunctionalities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTests extends DriverHandle{
	Mainfunctionalities mf=new Mainfunctionalities();
	private static final Logger logger = LogManager.getLogger(MyTests.class);
	
	
	@Test
	public void loginTest() {
	//	logger.info("*********logging the logs");
		mf.loginM();
	}

}
