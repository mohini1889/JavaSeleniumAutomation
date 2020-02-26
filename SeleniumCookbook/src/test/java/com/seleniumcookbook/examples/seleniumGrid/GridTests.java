package com.seleniumcookbook.examples.seleniumGrid;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTests {
	
	WebDriver driver;
	@Before
	public void setUp() throws MalformedURLException {
		 //System.setProperty("webdriver.gecko.driver", "./src/test/resources/drivers/geckodriver.exe");
		
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setBrowserName("chrome");
		// Launch a new Firefox instance
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/static/resource/hub.html"), caps);
		// Maximize the browser window
		driver.manage().window().maximize();
		// Navigate to Google
		driver.get("http://www.google.com");
	}

	@Test
	public void testGoogleSearch() {
		// Find the text input element by its name
		WebElement element = driver.findElement(By.name("q"));
		// Clear the existing text value
		element.clear();

		// Enter something to search for
		element.sendKeys("Selenium testing tools cookbook");

		
	}

	@After
	public void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
}
