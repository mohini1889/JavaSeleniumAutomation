package seleniumcookbook.tests.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.Assert.*;

public class BmiCalcPage extends LoadableComponent<BmiCalcPage> {

	@FindBy(name = "heightCMS")
	private WebElement heightCMS;

	@FindBy(name = "weightKg")
	private WebElement weightKg;

	@FindBy(id = "Calculate")
	private WebElement calculate;

	@FindBy(name = "bmi")
	private WebElement bmi;

	@FindBy(id = "bmi_category")
	private WebElement bmiCategory;

	private WebDriver driver;

	private String url = "http://cookbook.seleniumacademy.com/bmicalculator.html";
	private String title = "BMI Calculator";

	public BmiCalcPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@Override
	protected void load() {
		this.driver.get(url);
	}

	@Override
	protected void isLoaded() throws Error {
		assertTrue("Bmi Calculator page not loaded", driver.getTitle().equals(title));
	}

	public void calculateBmi(String height, String weight) {
		heightCMS.sendKeys(height);
		weightKg.sendKeys(weight);
		calculate.click();
	}

	public String getBmi() {
		return bmi.getAttribute("value");
	}

	public String getBmiCategory() {
		return bmiCategory.getAttribute("value");
	}
}