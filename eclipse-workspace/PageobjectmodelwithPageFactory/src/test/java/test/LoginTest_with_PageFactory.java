package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPagewithPageFactory;

public class LoginTest_with_PageFactory {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//ChromeOptions options = new ChromeOptions();
	//	options.addArguments("user-data-dir=/Users/YourUsername/Library/Application Support/Google/Chrome");
		//WebDriver driver = new ChromeDriver(options);

		System.setProperty("webdriver.chrome.driver", "/Users/laprepos-122/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
	
driver.manage().window().maximize();

driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

Thread.sleep(5000);
LoginPagewithPageFactory l1= new LoginPagewithPageFactory(driver);
l1.enterUsername("Admin");
l1.enterpasswordmethod("admin123");
l1.click();

System.out.println("Login successfully with Page object model- with PageFactory");
driver.close();
}
}
