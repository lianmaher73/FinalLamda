package lamda.test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import lamda.lian.Setcapabilities;

public class TestScenario2 {

	WebDriver driver;
	Setcapabilities capabilities;

	@BeforeClass
	@Parameters({ "browserName", "browserVersion", "platform" })
	public void setUp(String browserName, String browserVersion, String platform)
			throws MalformedURLException, URISyntaxException {

		capabilities = new Setcapabilities();
		driver = capabilities.Set_capabilities(browserName, browserVersion, platform, "rangeTest");
	}

	@Test
	public void rangeTest() throws MalformedURLException, URISyntaxException {
		Actions actions = new Actions(driver);
		driver.get("https://www.lambdatest.com/selenium-playground");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Drag & Drop Sliders")).click();
		WebElement slider = driver.findElement(By.xpath("//input[@value='15']"));
		actions.dragAndDropBy(slider, 214, 0).build().perform();// 212-216
		String num = driver.findElement(By.xpath("//output[@id='rangeSuccess']")).getText();
		System.out.println("The real rang value is -> " + num);
		Assert.assertEquals(num, "95", "the rang value dosen't shows 95");
		System.out.println("Test ID: " + ((RemoteWebDriver) driver).getSessionId());

		driver.quit();
	}
}