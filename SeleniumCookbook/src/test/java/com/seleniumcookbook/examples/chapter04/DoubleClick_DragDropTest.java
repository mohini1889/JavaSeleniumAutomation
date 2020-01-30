package com.seleniumcookbook.examples.chapter04;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClick_DragDropTest {
	@Test
	public void testDoubleClick() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");

		try {
			WebElement message = driver.findElement(By.id("message"));

			// Verify color is Blue
			assertEquals("rgba(0, 0, 255, 1)", message.getCssValue("background-color"));

			Actions builder = new Actions(driver);
			builder.doubleClick(message).perform();

			// Verify Color is Yellow
			assertEquals("rgba(255, 255, 0, 1)", message.getCssValue("background-color"));
		} finally {
			driver.quit();
		}
	}

	@Test
	public void testDragDrop() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/DoubleClickDemo.html");
		driver.get("http://cookbook.seleniumacademy.com/DragDropDemo.html");

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		Actions builder = new Actions(driver);
		builder.dragAndDrop(source, target).perform();
		assertEquals("Dropped!", target.getText());
	}
}
