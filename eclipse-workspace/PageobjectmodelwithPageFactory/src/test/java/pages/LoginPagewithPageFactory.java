package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.PageFactory;


public class LoginPagewithPageFactory {
	static WebDriver driver;

	public LoginPagewithPageFactory(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
			
			@FindBy(name="username")
		WebElement usernamefield;
			
		@FindBy(name="password")
		WebElement passwordfield;
		

	@FindBy(css= "button[type='submit']")
	WebElement loginbutton;
	
	
	    //enter username
			public void enterUsername(String text)
		{
						usernamefield.sendKeys(text);
		}

		//enter password
	public void enterpasswordmethod(String pass)
	{	
		passwordfield.sendKeys(pass);
	}	
	
	
			//click method
			public void click()
		{	
			loginbutton.click();
		}	
	}	
	
	
	

