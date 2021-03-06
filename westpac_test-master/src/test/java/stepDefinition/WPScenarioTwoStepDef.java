package stepDefinition;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utility.BrowserInstance;
import utility.InputSupplier;
import utility.InputType;
import utility.PropertiesFileReader;

public class WPScenarioTwoStepDef extends BrowserInstance {

	@Given("^I have a fields with following details$")
	public void i_have_a_fields_with_following_details(DataTable dt) throws Throwable {

		Thread.sleep(3000);
		driver.get(PropertiesFileReader.getProperty("browser.baseURL"));
		Thread.sleep(3000);
		driver.findElement(By.linkText("KiwiSaver")).click();
		driver.findElement(By.xpath("//*[@id=\"ubermenu-item-cta-kiwisaver-calculators-ps\"]")).click();
		driver.findElement(By.linkText("Click here to get started.")).click();
		Thread.sleep(3000);

		List<Map<String, String>> inputData = dt.asMaps(String.class, String.class);
		WebElement frame = driver.findElement(By.cssSelector("div#calculator-embed iframe"));
		driver.switchTo().frame(frame);

		// find element by xpath for age field and pass age value from input data table

		if (inputData.get(0).get("age") != null) {

			JavascriptExecutor js = (JavascriptExecutor) driver;

			WebElement chart = driver.findElement(By.xpath("//label[text()='Current age']//following::input[1]"));

			js.executeScript("arguments[0].scrollIntoView();", chart);

			InputSupplier.supplyInput(driver, InputType.TEXT,
					By.xpath("//label[text()='Current age']//following::input[1]"), null, inputData.get(0).get("age"));
		}
		// find element by xpath for drop down for employement status field and pass
		// option value from input data table
		if (inputData.get(0).get("employment") != null) {

			InputSupplier.supplyInput(driver, InputType.DROP_DOWN, By.xpath(
					"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[2]/div/div/div/div[2]/div[1]/div[1]/div/div/div/div[2]"),
					By.xpath("//label[text()='Employment status']//following::i[1]"),
					inputData.get(0).get("employment"));

		}

		// // find element for salary and pass value from datatable
		if ("Employed".equalsIgnoreCase(inputData.get(0).get("employment"))) {
			if (!(inputData.get(0).get("salary")).isEmpty()) {

				InputSupplier.supplyInput(driver, InputType.TEXT, By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div/div/input"),
						null, inputData.get(0).get("salary"));

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
						inputData.get(0).get("PIR"));

			} else {
				InputSupplier.supplyInput(driver, InputType.DROP_DOWN, By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div/div[2]"),
						By.xpath(
								"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[3]/div/div/div/div[2]/div[1]/div[1]/div/div[1]/div/div"),
						inputData.get(0).get("PIR"));

			}

		}

		// find element for kiwiwsaver balance and pass value from datatable

		if (inputData.get(0).get("kiwibalance") != null) {
			InputSupplier.supplyInput(driver, InputType.TEXT,
					By.xpath("//label[text()='Current KiwiSaver balance']//following::input[1]"), null,
					inputData.get(0).get("kiwibalance"));

		}
		// find element for volunteer and pass value from datatable
		if (inputData.get(0).get("Voluntary") != null) {
			InputSupplier.supplyInput(driver, InputType.TEXT,
					By.xpath("//label[text()='Voluntary contributions']//following::input[1]"), null,
					inputData.get(0).get("Voluntary"));

		}
		// find dropdown for frequency and pass value from datatable

		if (!(inputData.get(0).get("Frequency")).isEmpty()) {

			if ((inputData.get(0).get("employment")).equalsIgnoreCase("Employed")) {

				InputSupplier.supplyInput(driver, InputType.DROP_DOWN, By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[8]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[2]"),
						By.xpath(
								"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[8]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[1]/div/span"),
						inputData.get(0).get("Frequency"));

			} else {
				InputSupplier.supplyInput(driver, InputType.DROP_DOWN, By.xpath(
						"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[2]"),
						By.xpath(
								"//*[@id=\"widget\"]/div/div[1]/div/div[1]/div/div[6]/div/div/div/div[2]/div[1]/div[1]/div/div/div[1]/div[2]/div/div[1]/div/span"),
						inputData.get(0).get("Frequency"));

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
					inputData.get(0).get("goal"));

		}
	}

	@When("^user clicks on view projection$")
	public void user_clicks_on_view_projection() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//button//span[text()='View your KiwiSaver retirement projections']")).click();
	}

	@Then("^user should be able to see his projected balances at retirement$")
	public void user_should_be_able_to_see_his_projected_balances_at_retirement() throws Throwable {
		// Write code here that turns the phrase above into concrete actions

		String result = driver.findElement(By.className("results-heading")).getText();
		assertTrue(result.contains("your KiwiSaver balance is estimated to be"));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement chart = driver.findElement(By.className("results-heading"));

		js.executeScript("arguments[0].scrollIntoView();", chart);
		// Take screenshot and store as a file format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the screenshot to desired location using copyFile //method

			String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());

			FileUtils.copyFile(src, new File("./resultscreens/" + "Screenshot" + timestamp + ".png"));
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}

		driver.navigate().refresh();
		Thread.sleep(3000);
	}

}
