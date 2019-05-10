package stepDefinition;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.BrowserInstance;
import utility.InputSupplier;
import utility.InputType;
import utility.Utilites;

public class WPScenarioTwoStepDef extends BrowserInstance {

	@Given("^I have a fields with following details$")
	public void i_have_a_fields_with_following_details(DataTable dt)  {

		List<Map<String, String>> inputData = dt.asMaps(String.class, String.class);
		WebElement frame = driver.findElement(By.cssSelector("div#calculator-embed iframe"));
		driver.switchTo().frame(frame);

		// find element by xpath for age field and pass age value from input data table

		if (inputData.get(0).get("age") != null) {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement chart = driver.findElement(By.xpath("//label[text()='Current age']//following::input[1]"));

			js.executeScript("arguments[0].scrollIntoView();", chart);

			InputSupplier.supplyInput(driver, InputType.TEXT,
					By.xpath("//label[text()='Current age']//following::input[1]"), null, inputData.get(0).get("age"),
					false);
		}
		// find element by xpath for drop down for employement status field and pass
		// option value from input data table
		if (inputData.get(0).get("employment") != null) {

			InputSupplier.supplyInput(driver, InputType.DROP_DOWN, By.xpath(
					"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]"),
					By.xpath("//label[text()='Employment status']//following::i[1]"),
					inputData.get(0).get("employment"), true);

		}

		// // find element for salary and pass value from datatable
		if ("Employed".equalsIgnoreCase(inputData.get(0).get("employment"))) {
			if (!(inputData.get(0).get("salary")).isEmpty()) {

				InputSupplier.supplyInput(driver, InputType.TEXT, By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"),
						null, inputData.get(0).get("salary"), false);

			}

			// find element for kiwiwsaver and and select radio button
			if (!(inputData.get(0).get("kiwisaver")).isEmpty()) {

				WebElement radioButton = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[4]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div"));

				radioButton.click();

				List<WebElement> spans = radioButton.findElements(By.tagName("span"));
				for (WebElement span : spans) {
					if ((span.getText()).equals((inputData.get(0).get("kiwisaver")))) {
						span.click();
					}
				}

			}
		}
		// Find pIR dropdown and pass values
		if (!(inputData.get(0).get("PIR")).isEmpty()) {
			if ((inputData.get(0).get("employment")).equalsIgnoreCase("Employed")) {

				InputSupplier.supplyInput(driver, InputType.DROP_DOWN, By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[5]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div[2]"),
						By.xpath(
								"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[5]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div"),
						inputData.get(0).get("PIR"), false);

			} else {
				InputSupplier.supplyInput(driver, InputType.DROP_DOWN, By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div[2]"),
						By.xpath(
								"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div"),
						inputData.get(0).get("PIR"), false);

			}

		}

		// find element for kiwiwsaver balance and pass value from datatable

		if (inputData.get(0).get("kiwibalance") != null) {
			InputSupplier.supplyInput(driver, InputType.TEXT,
					By.xpath("//label[text()='Current KiwiSaver balance']//following::input[1]"), null,
					inputData.get(0).get("kiwibalance"), false);

		}
		// find element for volunteer and pass value from datatable
		if (inputData.get(0).get("Voluntary") != null) {
			InputSupplier.supplyInput(driver, InputType.TEXT,
					By.xpath("//label[text()='Voluntary contributions']//following::input[1]"), null,
					inputData.get(0).get("Voluntary"), false);

		}
		// find dropdown for frequency and pass value from datatable

		if (!(inputData.get(0).get("Frequency")).isEmpty()) {

			if ((inputData.get(0).get("employment")).equalsIgnoreCase("Employed")) {

				InputSupplier.supplyInput(driver, InputType.DROP_DOWN, By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[8]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[2]"),
						By.xpath(
								"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[8]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[1]/div/span"),
						inputData.get(0).get("Frequency"), false);

			} else {
				InputSupplier.supplyInput(driver, InputType.DROP_DOWN, By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[2]"),
						By.xpath(
								"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[1]/div/span"),
						inputData.get(0).get("Frequency"), false);

			}
		}
		//
		// find element for risk radio button and pass value from data table
		if (!(inputData.get(0).get("profile")).isEmpty()) {
			WebElement radioButton;
			if ((inputData.get(0).get("employment")).equalsIgnoreCase("Employed")) {

				radioButton = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[9]/div/div/div/div[2]/div[1]/div[1]/div/div/div"));

				radioButton.click();
			}

			else {
				radioButton = driver.findElement(By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[7]/div/div/div/div[2]/div[1]/div[1]/div/div/div"));

				radioButton.click();
			}
			List<WebElement> spans = radioButton.findElements(By.tagName("span"));
			for (WebElement span : spans) {
				if ((span.getText()).equals((inputData.get(0).get("profile")))) {
					span.click();
				}
			}
		}

		// find element for goals and pass value from data table
		if (!(inputData.get(0).get("goal")).isEmpty()) {
			InputSupplier.supplyInput(driver, InputType.TEXT,
					By.xpath("//label[text()='Savings goal at retirement']//following::input[1]"), null,
					inputData.get(0).get("goal"), false);

		}
	}

	@When("^user clicks on view projection$")
	public void user_clicks_on_view_projection() {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button//span[text()='View your KiwiSaver retirement projections']")).click();
	}

	@Then("^user should be able to see his projected balances at retirement$")
	public void user_should_be_able_to_see_his_projected_balances_at_retirement() {
		// Write code here that turns the phrase above into concrete actions

		String result = driver.findElement(By.className("results-heading")).getText();
		try {
			assertTrue(result.contains("your KiwiSaver balance is estimated to be"));
		} catch (AssertionError error) {
			Utilites.captureScreenShot(driver, "StepTwo_Assertion_Falied_");
			throw error;

		}
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement chart = driver.findElement(By.className("results-heading"));

		js.executeScript("arguments[0].scrollIntoView();", chart);
		Utilites.captureScreenShot(driver, "StepTwo");

		driver.navigate().refresh();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterMethod
	public void close() {

		driver.close();

	}

}
