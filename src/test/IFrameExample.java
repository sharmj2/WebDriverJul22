package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/frames");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		driver.switchTo().frame("frame1");
		
		WebElement header = driver.findElement(By.id("sampleHeading"));
		System.out.println("First Iframe ----"+header.getText());
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		
		WebElement header2 = driver.findElement(By.id("sampleHeading"));
		System.out.println("Second Iframe ----"+header2.getText());
		
		driver.switchTo().defaultContent();
		
	}

}
