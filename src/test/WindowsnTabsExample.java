package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsnTabsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		String parentWin = driver.getWindowHandle();
		System.out.println("Parent Window before click  "+parentWin);
		WebElement tab = driver.findElement(By.id("tabButton"));
		tab.click();
		
		Set<String> allWin = driver.getWindowHandles();
		System.out.println("After the click  ");
		for (String win:allWin)
		{
			System.out.println(win);
			if(!win.equals(parentWin))
			{
				driver.switchTo().window(win);
				WebElement childHeader = driver.findElement(By.id("sampleHeading"));
				
				System.out.println("Child Window header is --"+childHeader.getText());
			}
		}
		driver.close();
		
		driver.switchTo().window(parentWin);
		
		WebElement winBtn = driver.findElement(By.id("windowButton"));
		winBtn.click();
		
		
		allWin = driver.getWindowHandles();
		System.out.println("After opening the new Window");
		
		for (String win1:allWin)
		{
			System.out.println(win1);
			if(!win1.equals(parentWin))
			{
				driver.switchTo().window(win1);
				WebElement newWinHeader = driver.findElement(By.id("sampleHeading"));
				System.out.println("New Window header is --"+newWinHeader.getText());
			}
		}
		
		driver.close();
		
		driver.switchTo().window(parentWin);
	}

}
