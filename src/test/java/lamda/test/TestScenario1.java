package lamda.test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import lamda.lian.Setcapabilities;

public class TestScenario1 {

	WebDriver driver;
	Setcapabilities capabilities;

	@BeforeClass
	@Parameters({ "browserName", "browserVersion", "platform" })
	public void setUp(String browserName, String browserVersion, String platform)
			throws MalformedURLException, URISyntaxException {

		capabilities = new Setcapabilities();
		driver = capabilities.Set_capabilities(browserName, browserVersion, platform, "simpleFormDemoTest");
	}

	@Test
	public void simpleFormDemoTest() throws Exception {

		SoftAssert myAssert = new SoftAssert();

		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Simple Form Demo")).click();
		String url = driver.getCurrentUrl();
		myAssert.assertTrue(url.contains("simple-form-demo"), "The Url doesn't contain this text \"simple-form-demo\"");
		String expectedMessage = "Welcome to LambdaTest";
		driver.findElement(By.id("user-message")).sendKeys(expectedMessage);
		driver.findElement(By.id("showInput")).click();
		String actualMessage = driver.findElement(By.id("message")).getText();
		System.out.println("The Actual message is ->" + actualMessage);
		myAssert.assertEquals(actualMessage, expectedMessage,
				"Mismatch between expected and actual displayed messages.");
		myAssert.assertAll();
		System.out.println("Test ID: " + ((RemoteWebDriver) driver).getSessionId());

		driver.quit();
	}
}
