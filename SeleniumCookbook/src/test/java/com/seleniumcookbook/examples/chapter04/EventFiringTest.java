package com.seleniumcookbook.examples.chapter04;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class EventFiringTest {
	private WebDriver driver;

	  @Before
	  public void setUp() throws Exception {
		  System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
			driver = new ChromeDriver();
	  }

	  @Test
	  public void testEventFiringWebDriver() throws Exception {

	    EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
	    MyListener myListener = new MyListener();
	    eventDriver.register(myListener);

	    eventDriver.get("http://www.google.com");
	    eventDriver.findElement(By.id("q"))
	      .sendKeys("Selenium Testing Tools Cookbook");
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	  }
}
