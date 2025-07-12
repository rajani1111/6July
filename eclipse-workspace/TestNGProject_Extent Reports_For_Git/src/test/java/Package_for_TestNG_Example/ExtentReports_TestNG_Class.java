package Package_for_TestNG_Example;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReports_TestNG_Class {

	private static WebDriver driver=null;
	static ExtentSparkReporter html;
	static ExtentReports extent;
	 ExtentTest test1;
	
	@BeforeSuite
		public static void StartReports() {
		//start reporters
				html= new ExtentSparkReporter("extent.html");
				
				 //create ExtentReports and attach reporters
				extent = new ExtentReports();
				extent.attachReporter(html);
				
				//configuration to change look and feel
				html.config().setDocumentTitle("Extent Report Demo");
				html.config().setReportName("Test Report");
			    html.config().setTheme(Theme.STANDARD);
			  //  html.config().setTimeStampFormat("12 06 2025, 11:13 pm");
				
		     		    
				//add environment details
				extent.setSystemInfo("TestExampleinfo", "testpc1");
				extent.setSystemInfo("Environment", "staging");
				extent.setSystemInfo("OS", "Macbook");
				extent.setSystemInfo("browser", "chrome");
				extent.setSystemInfo("user", "Rajani");	
	}
	
	@BeforeTest
	public static void SetupBrowser() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Users/laprepos-122/Drivers/chromedriver");
		driver = new ChromeDriver();
	
driver.manage().window().maximize();

//test1.log(Status.INFO,"Starting test case");


driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(5000);
	
	}
	
	
	@Test
	public void verifyLoginPage() {
	//creates a toggle for the given test, adds all log events under it
	test1= extent.createTest("OrangehrmLoginTest one","This is test to validate a  orangehrm login functionality");
	test1.pass("Navigated to orangehrm site");
	Assert.assertTrue(true); //test passed
	}
	
	@Test
	public void VerifyTitle() {
		test1= extent.createTest("Verify Title","This is test to validate a  title of the page");
		String actualTitle = driver.getTitle();
		System.out.println("Title is: "+ actualTitle);
		String expectedTitle = "Login - MyApp";
		
		try {
		    Assert.assertEquals(actualTitle, expectedTitle);
		    test1.pass("Page title verified successfully");
		} catch (AssertionError e) {
		    test1.fail("Page title mismatch: " + e.getMessage());
		    throw e; // Important to re-throw to mark the test as failed in TestNG
		}
		Assert.assertTrue(false); //test failed
	}
	
	
	@Test
	public void VerifyLogo() {
		test1= extent.createTest("This is test to validate logo on the page");
WebElement logo= driver.findElement(By.xpath("//img[@alt='company-branding']"));
if(logo.isDisplayed())
		{
	System.out.println("logo is displaying");
		}
else
{
	System.out.println("logo is not displaying");
}
test1.skip("Logo is not visible properly");

throw new SkipException("skipping this test case with exception"); //test skipped

//Assert.assertTrue(true); //test passed
	}
	
	
	@Test
	public void VerifyUsernamefield()
	{
		test1= extent.createTest("This is test to validate username the page");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
usernameField.sendKeys("Admin");
test1.pass("Entered text in username field");
Assert.assertTrue(true); //test passed
	}
	
	@Test
	public void VerifyPasswordfield() {
		test1= extent.createTest("This is test to validate password field on the page");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));

		//WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Password']")));
		passwordField.sendKeys("admin123");
//driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
test1.fail("Entered text in password field");
Assert.assertTrue(false); //test failed
	}
	
	@Test
	public void VerifyLoginbutton() {
		test1= extent.createTest("This is test to verify login button on the page");
driver.findElement(By.xpath("//button[@type='submit']")).click();
test1.pass("Click on login button");
Assert.assertTrue(true); //test passed

	}

	
	@AfterMethod
	
	public void TestResult(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test1.log(Status.FAIL, MarkupHelper.createLabel(result.getName() +" FAIL " ,ExtentColor.RED));
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
			
		{
			test1.log(Status.PASS, MarkupHelper.createLabel(result.getName() +" PASS " ,ExtentColor.GREEN));
		}
		else
		{
			if(result.getStatus()==ITestResult.SKIP)
			{
				test1.log(Status.SKIP, MarkupHelper.createLabel(result.getName() +" SKIP " ,ExtentColor.YELLOW));
			}
		}
	}
	
@AfterTest
public void TearDown() {
driver.close();
driver.quit();

test1.pass("Closed the browser");

test1.log(Status.INFO,"Test completed");
}

@AfterSuite
public void reportflush() {
extent.flush();
		
	}

}

