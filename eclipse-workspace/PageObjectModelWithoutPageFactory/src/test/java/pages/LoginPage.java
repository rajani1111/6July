package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;


public class LoginPage {

	
	static WebDriver driver;

	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//method to pass username
	public static void Username(String user)
	{
		String[] givenwords= {"standard_user","locked_out_user","problem_user","performance_glitch_user","error_user","visual_user"};
		
		int count=0;
		
		for( String word : givenwords)
			{
			WebElement username= driver.findElement(By.id("user-name"));
			username.clear();
			username.sendKeys(user);
			
			String actualword =username.getAttribute("value");
			
			if(actualword.equals(givenwords))
			{
				System.out.println("Username field is accepting words between given string");
			}
			else {
				System.out.println("Invalid username field..please enter valid string");
				
				
			}
			count++;
			
			System.out.println("User"+count+ ":"+ actualword);
			
			}
		System.out.println("Total count is: "+ count);
		
	}
	

	//method to pass password
	public static void Password(String pass)
	{
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys(pass);
	}
	
	public static void Click()
	{
		WebElement clickbutton= driver.findElement(By.id("login-button"));
		clickbutton.click();
		
	}

		
		public boolean isErrorMessageVisible() {
		    try {
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		        WebElement errormsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
		            By.xpath("//button[@class='error-button']")));
		 
		        return errormsg.isDisplayed(); // Error found
		        
		    } catch ( TimeoutException e) {
		        // No error found within 5 seconds
		        System.out.println("Error msg is not visible");
		        return false;
		    }
		}	
}

