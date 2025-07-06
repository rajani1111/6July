package package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

public class NewJavaExecutorClass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();

			driver.get("https://www.google.com");
			
		
Thread.sleep(1000);

	
		((JavascriptExecutor)driver).executeScript("window.open('https://www.bing.com','_blank');");
		
		Thread.sleep(1000);
		
		
((JavascriptExecutor)driver).executeScript("window.open('https://www.yahoo.com','_blank');");
		
Thread.sleep(1000);


Set<String> alltabs= driver.getWindowHandles();

List<String> tabslist= new ArrayList<>(alltabs);

driver.switchTo().window(tabslist.get(1));
System.out.println("Closing 2nd tab: " + driver.getTitle());
driver.close();

driver.switchTo().window(tabslist.get(0));
System.out.println("Back to 1st tab: " + driver.getTitle());

// Step 7: Quit browser
Thread.sleep(2000);
driver.quit();
	}

}
