package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		WebElement target = driver.findElement(By.xpath("//a[text()='Start the Exercise']"));
		
		
		/*arguments[0] .scrollintoview() - Execuete the javascript 
		 * function by creating object of javascript executor
		 */
		
		/*JavascriptExecutor obj = (JavascriptExecutor)driver; 
		obj.executeScript("arguments[0].scrollIntoView();", target);
		
		
		obj.executeScript("window.scrollTo(0, document.body.scrollHeight);");
		
		obj.executeScript("window.scrollTo(0, -document.body.scrollHeight);");*/
		
		
		/*------Using Actions Class------*/
		Actions act = new Actions(driver);
		
		/*Either use this*/
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		
		/*or use this*/
		act.keyDown(Keys.CONTROL).sendKeys(Keys.END).keyUp(Keys.CONTROL).build().perform();
		act.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).keyUp(Keys.CONTROL).build().perform();
	}

	

}
