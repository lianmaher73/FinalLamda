package lamda.lian;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Setcapabilities {

	public WebDriver Set_capabilities(String browserName, String browserVersion, String platform, String testName)
			throws MalformedURLException, URISyntaxException {

		String username = "lianmaher1";
		String accessKey = "LT_yVKLJrAZ98pMNT92a9yBUoseyZTwPnOOYPUPaHjxCLdhGLh";
		WebDriver driver;

		Object browserOptions = null;

		if (browserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setPlatformName(platform);
			chromeOptions.setBrowserVersion(browserVersion);
			browserOptions = chromeOptions;
		} else if (browserName.equalsIgnoreCase("Firefox")) {
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setPlatformName(platform);
			firefoxOptions.setBrowserVersion(browserVersion);
			browserOptions = firefoxOptions;
		} else if (browserName.equalsIgnoreCase("Edge")) {
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setPlatformName(platform);
			edgeOptions.setBrowserVersion(browserVersion);
			browserOptions = edgeOptions;
		} else {
			throw new IllegalArgumentException("Unsupported browser: " + browserName);
		}

		HashMap<String, Object> ltOptions = new HashMap<>();
		ltOptions.put("username", username);
		ltOptions.put("accessKey", accessKey);
		ltOptions.put("build", "Lian-Build1");
		ltOptions.put("project", "Selenium101-Certification");
		ltOptions.put("name", testName);
		ltOptions.put("tags", new String[] { "testng", "selenium101", "assignment" });
		ltOptions.put("w3c", true);
		ltOptions.put("plugin", "java-testNG");

		ltOptions.put("network", true);
		ltOptions.put("visual", true);
		ltOptions.put("console", true);
		ltOptions.put("video", true);

		if (browserOptions instanceof ChromeOptions) {
			((ChromeOptions) browserOptions).setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(
					new URI("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub").toURL(),
					(ChromeOptions) browserOptions);
		} else if (browserOptions instanceof FirefoxOptions) {
			((FirefoxOptions) browserOptions).setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(
					new URI("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub").toURL(),
					(FirefoxOptions) browserOptions);
		} else if (browserOptions instanceof EdgeOptions) {
			((EdgeOptions) browserOptions).setCapability("LT:Options", ltOptions);
			driver = new RemoteWebDriver(
					new URI("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub").toURL(),
					(EdgeOptions) browserOptions);
		} else {
			throw new IllegalArgumentException("Unsupported browser options");
		}

		return driver;
	}
}
