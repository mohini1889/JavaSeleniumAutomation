package com.seleniumcookbook.examples.chapter07;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.junit.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

@RunWith(Parameterized.class)
public class CsvTestData {
	private static WebDriver driver;

	private String height;
	private String weight;
	private String bmi;
	private String bmiCategory;

	@Parameters
	public static List<String[]> testData() throws IOException, CsvException {
		return getTestData("./src/test/resources/testdata/data.csv");
	}

	public CsvTestData(String height, String weight, String bmi, String bmiCategory) {
		this.height = height;
		this.weight = weight;
		this.bmi = bmi;
		this.bmiCategory = bmiCategory;
	}

	public static List<String[]> getTestData(String fileName) throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader(fileName));
		List<String[]> myEntries = reader.readAll();
		reader.close();
		return myEntries;
	}

	@BeforeClass
	public static void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");

		// Launch Chrome
		driver = new ChromeDriver();
		driver.get("http://cookbook.seleniumacademy.com/bmicalculator.html");
	}

	@Test
	public void testBMICalculator() throws Exception {
		WebElement heightField = driver.findElement(By.name("heightCMS"));
		heightField.clear();
		heightField.sendKeys(height);

		WebElement weightField = driver.findElement(By.name("weightKg"));
		weightField.clear();
		weightField.sendKeys(weight);

		WebElement calculateButton = driver.findElement(By.id("Calculate"));
		calculateButton.click();

		WebElement bmiLabel = driver.findElement(By.name("bmi"));
		assertEquals(bmi, bmiLabel.getAttribute("value"));

		WebElement bmiCategoryLabel = driver.findElement(By.name("bmi_category"));
		assertEquals(bmiCategory, bmiCategoryLabel.getAttribute("value"));
	}

	@AfterClass
	public static void tearDown() throws Exception {
		// Close the browser
		driver.quit();
	}
}
