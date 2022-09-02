package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AlertsExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://demoqa.com/alerts");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
			
			WebElement Button1 = driver.findElement(By.id("alertButton"));
			Button1.click();
			Alert alert = driver.switchTo().alert();
			
			System.out.println(alert.getText());
			alert.accept();
			
			Actions act = new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			
			
			  WebElement Button2 = driver.findElement(By.id("timerAlertButton"));
			  Button2.click();
			  Thread.sleep(5000);
			  alert = driver.switchTo().alert(); 
			  System.out.println(alert.getText());
			  alert.accept();
			 
			
			WebElement Button3 = driver.findElement(By.id("confirmButton"));
			Button3.click();
			
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			alert.dismiss();
			
			
			/*Either use this*/
			
			WebElement Button4 = driver.findElement(By.id("promtButton"));
			Button4.click();
			
			alert = driver.switchTo().alert();
			System.out.println(alert.getText());
			
			alert.sendKeys("Hello World");
			alert.accept();
			
			

		}


}
