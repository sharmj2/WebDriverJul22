package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement loginLink = driver.findElement(By.linkText("Log in"));
		loginLink.click();
		
		WebElement email = driver.findElement(By.name("user_login"));
		email.sendKeys("abc@gmail.com");
		
		WebElement pwd = driver.findElement(By.id("password"));
		pwd.sendKeys("Test@1234");
		
		WebElement rememberMe = driver.findElement(By.className("rememberMe"));
		rememberMe.click();
		
		WebElement login = driver.findElement(By.name("btn_login"));
		login.click();
		
		WebElement errorMsg = driver.findElement(By.id("msg_box"));
		
		String actualError = errorMsg.getText();
		
		String expectedMsg = "The email or password you have entered is invalid.";
		
		if(actualError.equals(expectedMsg))
		{
			System.out.println("TC Passed");
		}else {
			System.out.println("TC Failed");
		}
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		
		for(WebElement link:links)
		{
			System.out.println(link.getAttribute("href"));
		}
		
		//driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.close();
	}

}
