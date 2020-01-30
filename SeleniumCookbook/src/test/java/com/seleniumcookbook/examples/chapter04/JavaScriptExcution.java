package com.seleniumcookbook.examples.chapter04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExcution {

	@Test
	public void testJavaScriptCalls() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;

			String title = (String) js.executeScript("return document.title");
			assertEquals("Google", title);

			long links = (Long) js.executeScript("var links = document.getElementsByTagName('A'); return links.length");
			assertEquals(29, links);
		} finally {
			driver.quit();
		}
	}
}
