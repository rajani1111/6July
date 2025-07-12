package package_for_basic_democlass;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsBasicDemo {

	private static WebDriver driver=null;
	
	@BeforeTest
	public static void startReport() {
		
		//start reporters
		ExtentSparkReporter html= new ExtentSparkReporter("extent.html");
		
        //create ExtentReports and attach reporters
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
	
		//configuration to change look and feel
				html.config().setDocumentTitle("Extent Report Demo");
				html.config().setReportName("Test Report");
			    html.config().setTheme(Theme.STANDARD);
			    html.config().setTimeStampFormat("12 06 2025, 11:13 pm");
			    
			    
		//add environment details
		extent.setSystemInfo("TestExampleinfo", "testpc1");
		extent.setSystemInfo("Environment", "staging");
		extent.setSystemInfo("OS", "Macbook");
		extent.setSystemInfo("browser", "chrome");
		extent.setSystemInfo("user", "Rajani");
	
		
	//creates a toggle for the given test, adds all log events under it
		ExtentTest test1= extent.createTest("OrangehrmLoginTest one","This is test to validate a  orangehrm login functionality");
	
		System.setProperty("webdriver.chrome.driver", "/Users/laprepos-122/Drivers/chromedriver");
		driver = new ChromeDriver();
	
driver.manage().window().maximize();

test1.log(Status.INFO,"Starting test case");


driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
test1.pass("Navigated to orangehrm site");

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Username']")));
usernameField.sendKeys("Admin");

//driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
test1.pass("Entered text in username field");

driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
test1.pass("Entered text in password field");

driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
test1.pass("Click on login button");

driver.close();
driver.quit();

test1.pass("Closed the browser");

test1.info("Test completed");

extent.flush();

	}

}
