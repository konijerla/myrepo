package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Utilites {

	public static void captureScreenShot(WebDriver driver, String flowName) {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		String fileName = null != flowName ? "./resultscreens/" + flowName + timestamp + ".png" : "./resultscreens/" + "Screenshot" + timestamp + ".png";
		try {
			// now copy the screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File(fileName));
		}

		catch (IOException e) {
			System.out.println(e.getMessage());

		}
	}

}
