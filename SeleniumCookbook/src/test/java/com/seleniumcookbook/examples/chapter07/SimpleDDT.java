package com.seleniumcookbook.examples.chapter07;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(Parameterized.class)
public class SimpleDDT {

	private static WebDriver driver;
	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;

	@Parameters
	public static List<String[]> testData() {
		return Arrays.asList(new String[][] { { "160", "45", "17.6", "Underweight" }, { "168", "70", "24.8", "Normal" },
				{ "181", "89", "27.2", "Overweight" }, { "178", "100", "31.6", "Obesity" } });
	}

	public SimpleDDT(String height, String weight, String bmi, String bmiCategory) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
	}

	@Test
	public void testBMICalculator() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");

		// Launch Chrome
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");

		// Get the Height element and set the value using height variable
		WebElement heightField = driver.findElement(By.name("heightCMS"));
		heightField.clear();
		heightField.sendKeys(height);

		// Get the Weight element and set the value using weight variable
		WebElement weightField = driver.findElement(By.name("weightKg"));
		weightField.clear();
		weightField.sendKeys(weight);

		// Click on Calculate Button
		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();

		// Get the Bmi element and verify its value using bmi variable
		WebElement bmiLabel = driver.findElement(By.name("bmi"));
		assertEquals(bmi, bmiLabel.getAttribute("value"));

		// Get the Bmi Category element and verify its value using
		// bmiCategory variable
		WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
		assertEquals(bmiCategory, bmiCategoryLabel.getAttribute("value"));
		
		driver.close();
	}
}