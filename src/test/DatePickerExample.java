package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		/*
		 * WebElement popup = driver.findElement(By.
		 * xpath("//*[local-name()='svg' and @class =' c-pointer c-neutral-900']"));
		 * popup.click();
		 * 
		 * 
		 * WebElement departTo
		 * =driver.findElement(By.xpath("//div[contains(@class,'homeCalender')]/button")
		 * );
		 * 
		 * departTo.click();
		 */
		WebElement dobtxt = driver.findElement(By.cssSelector("input#dob"));
		dobtxt.click();
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@data-handler='selectMonth']")));
		
		WebElement month = driver.findElement(By.xpath("//select[@data-handler='selectMonth']"));
		
		Select ddMon = new Select(month);
		ddMon.selectByVisibleText("Oct");
		
		WebElement year = driver.findElement(By.xpath("//select[@data-handler='selectYear']"));
		Select ddYear = new Select(year);
		ddYear.selectByVisibleText("1986");
		
		WebElement date = driver.findElement(By.xpath("//a[@data-date='2']"));
		date.click();
		
		
	}

}
