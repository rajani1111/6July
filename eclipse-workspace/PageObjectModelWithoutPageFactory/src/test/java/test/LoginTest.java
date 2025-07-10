package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

public class LoginTest {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/laprepos-122/Drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
	
driver.manage().window().maximize();

driver.get("https://www.saucedemo.com/");
String actualTitle=driver.getTitle();

if(actualTitle.equals("Swag Labs"))
		{
	System.out.println("Title is matched correctly");
		}
else
{
	System.out.println("Title is not matching");	
}

LoginPage login= new LoginPage(driver);
login.Username("standard_user");
login.Password("secret_sauce");
login.Click();
login.isErrorMessageVisible();
if (login.isErrorMessageVisible())
		{
	    System.out.println(" Invalid credentials - Error message is displayed.");
	} else {
	    System.out.println(" Login successful - No error message is displaying.");
	}
}
}
