package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserInstance {


	private static String browserDriverPath = null;
	public static WebDriver driver = null;


	public static WebDriver getBrowser(String browserType, int browserVersion, String browserOS) {

		if (null != browserType) {
			if ("Chrome".equalsIgnoreCase(browserType)) {
				if (null == driver) {

					// browserDriverPath = "./src/main/BrowserDrivers/" + browserType + "/version/"
					// + browserVersion + "/"
					// + browserOS + "/chromedriver";
//					if ("windows".equalsIgnoreCase(browserType)) {
//						browserDriverPath = browserDriverPath + ".exe";
//					}
					browserDriverPath = "./BrowserDrivers/chromedriver_win32/chromedriver.exe";

					System.setProperty("webdriver.chrome.driver", browserDriverPath);
					driver = new ChromeDriver();
					driver.manage().window().maximize();
				}
				return driver;

			}

		}
		return null;

	}

}
