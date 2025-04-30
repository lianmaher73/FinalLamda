package lamda.test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import lamda.lian.Setcapabilities;

public class TestScenario3 {
	WebDriver driver;
	Setcapabilities capabilities;

	@BeforeClass
	@Parameters({ "browserName", "browserVersion", "platform" })
	public void setUp(String browserName, String browserVersion, String platform)
			throws MalformedURLException, URISyntaxException {

		capabilities = new Setcapabilities();
		driver = capabilities.Set_capabilities(browserName, browserVersion, platform, "inputFormTest");
	}

	@Test
	public void inputFormTest() throws MalformedURLException, URISyntaxException {
		SoftAssert myAssert = new SoftAssert();
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Input Form Submit")).click();
		driver.findElement(By.xpath("//button[text()='Submit']")).click();

		String validationMessage = (String) ((org.openqa.selenium.JavascriptExecutor) driver)
				.executeScript("return document.querySelector('input').validationMessage;");
		myAssert.assertEquals(validationMessage, "Please fill out this field.",
				"The system could't chatch the error message");

		driver.findElement(By.name("name")).sendKeys("Lian");
		driver.findElement(By.id("inputEmail4")).sendKeys("Lianmaher1@gmail.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("123");
		driver.findElement(By.id("company")).sendKeys("Altibbi");
		driver.findElement(By.name("website")).sendKeys("null");
		WebElement option = driver.findElement(By.name("country"));
		Select select = new Select(option);
		select.selectByVisibleText("United States");
		driver.findElement(By.name("city")).sendKeys("amman");
		driver.findElement(By.id("inputAddress1")).sendKeys("Jo_amman");
		driver.findElement(By.id("inputAddress2")).sendKeys("Jo_amman");
		driver.findElement(By.id("inputState")).sendKeys("state");
		driver.findElement(By.id("inputZip")).sendKeys("111");
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		System.out.println("The success message ->" + driver.findElement(By.cssSelector("p.success-msg")).getText());

		myAssert.assertTrue(driver.findElement(By.cssSelector("p.success-msg")).isDisplayed());

		myAssert.assertAll();
		System.out.println("Test ID: " + ((RemoteWebDriver) driver).getSessionId());

		driver.quit();

	}

}
