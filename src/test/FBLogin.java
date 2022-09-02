package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		email.sendKeys("abc@gmail.com");
		
		WebElement pwd = driver.findElement(By.xpath("//input[@type='password']"));
		pwd.sendKeys("Test@1234");
		
		
		WebElement login = driver.findElement(By.xpath("//button[@type='submit']"));
		login.click();
		
		/*WebElement errorMsg = driver.findElement(By.id("msg_box"));
		
		String actualError = errorMsg.getText();
		
		String expectedMsg = "The email or password you have entered is invalid.";
		
		if(actualError.equals(expectedMsg))
		{
			System.out.println("TC Passed");
		}else {
			System.out.println("TC Failed");
		}*/
		
	}

}
