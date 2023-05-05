package training;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;		
import org.testng.annotations.Test;	
import org.testng.annotations.BeforeTest;	
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;	
import io.github.bonigarcia.wdm.WebDriverManager;




public class FirstSeleniumJavaTest {

	private WebDriver driver;	
	
	public void waitForPageLoaded() {
		ExpectedCondition<Boolean> expectation = new
				ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};
		try {
			Thread.sleep(1000);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
	
	@Test				
	public void testEasy() {

		driver.get("https://testautomationu.applitools.com/"); 
		//waitForPageLoaded();
		driver.manage().window().maximize();

		String title = driver.getTitle();
		System.out.println("title is - TAU "+title);
		AssertJUnit.assertTrue(title.equals("Test Automation University | Applitools"));
	}	

	@Test				
	public void testTwo() {	

		driver.get("https://www.google.co.uk/"); 
		//waitForPageLoaded();
		driver.manage().window().maximize();

		String title1 = driver.getTitle();
		System.out.println("title is - Google "+title1);
		AssertJUnit.assertTrue(title1.equals("Google"));

	}	
	
	@BeforeSuite
	 public static void setUp() {
	    WebDriverManager.chromedriver().avoidResolutionCache().setup();
	 }
	

	@BeforeTest
	public void beforeTest() {	
	    driver = new ChromeDriver();  
	}		
	@AfterTest
	public void afterTest() {
		System.out.println("after test ");
		driver.quit();			
	}	
}
