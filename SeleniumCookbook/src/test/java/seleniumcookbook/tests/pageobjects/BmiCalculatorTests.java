package seleniumcookbook.tests.pageobjects;

import static org.junit.Assert.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BmiCalculatorTests {

	  private WebDriver driver;

	  @Before
	  public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	  }

	  @Test
	  public void testBmiCalculation() {
	    // Create an instance of Bmi Calculator Page class
	    // and provide the driver
	    BmiCalcPage bmiCalcPage = new BmiCalcPage(driver);

	    // Open the Bmi Calculator Page
	    bmiCalcPage.get();

	    // Calculate the Bmi by supplying Height and Weight values
	    bmiCalcPage.calculateBmi("181", "80");

	    // Verify Bmi & Bmi Category values
	    assertEquals("24.4", bmiCalcPage.getBmi());
	    assertEquals("Normal", bmiCalcPage.getBmiCategory());
	  }

	  @After
	  public void tearDown() {
	    driver.quit();
	  }
	}