package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InputSupplier {

	public static void supplyInput(WebDriver driver, InputType elementType, By byLocation, By dropDownLocation,
			String value) {

		if (InputType.TEXT == elementType) {
			driver.findElement(byLocation).sendKeys(value);
		} else if (InputType.DROP_DOWN == elementType) {
			WebElement dropdown = driver.findElement(dropDownLocation);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click()", dropdown);
			WebElement empStatusDropDown = driver.findElement(byLocation);

			List<WebElement> empStatusList = empStatusDropDown.findElements(By.tagName("li"));
			for (WebElement empStatus : empStatusList) {
				if ((empStatus.findElement(By.tagName("span")).getText()).equalsIgnoreCase(value)) {
					empStatus.findElement(By.tagName("span")).click();
					break;
				}
			}

		} else {
			System.err.println("Please add more conditions to capture your inout type");
		}

	}

}
