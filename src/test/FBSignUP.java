package test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FBSignUP {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		WebElement signup = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signup.click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
		WebElement mobileNo = driver.findElement(By.xpath("//input[@name='reg_email__']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='password_step_input']"));
		
		firstName.sendKeys("Krisha");
		lastName.sendKeys("Sharma");
		mobileNo.sendKeys("1234567890");
		password.sendKeys("Test@1234");
		
		WebElement date = driver.findElement(By.xpath("//select[@name='birthday_day']"));
		Select dateDay = new Select(date);
		dateDay.selectByValue("15");
		
		WebElement month = driver.findElement(By.xpath("//select[@name='birthday_month']"));
		
		Select monDay = new Select(month);
		monDay.selectByValue("10");
		
		/*List<WebElement> options = monDay.getOptions(); 
		for (WebElement option:options)
		{
			System.out.println(option.getText());
		}*/
		
		List<WebElement> allOptions = driver.findElements(By.xpath("//select[@name='birthday_month']/option"));
		for (WebElement option:allOptions)
		{
			System.out.println(option.getText());
		}
		//System.out.println("Selected value is "+monDay.getFirstSelectedOption().getText());
		
		//Thread.sleep(1000);
		WebElement selectedMon = driver.findElement(By.xpath("//select[@name='birthday_month']/option[@selected='1']"));
		System.out.println("Selected value is "+selectedMon.getText());
		
		WebElement year = driver.findElement(By.xpath("//select[@name='birthday_year']"));
		Select yearDay = new Select(year);
		yearDay.selectByValue("2000");
		
//		WebElement selectRadio = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
//		selectRadio.click();
		
		WebElement createAcct = driver.findElement(By.xpath("//button[@name='websubmit']"));
		//createAcct.click();
		
		/*WebElement male = driver.findElement(By.xpath("//input[@type='radio' and @value='2']"));
		WebElement female = driver.findElement(By.xpath("//input[@type='radio' and @value='1']"));
		WebElement others = driver.findElement(By.xpath("//input[@type='radio' and @value='-1']"));
		
		String gender = "Male";
		
		if(gender.equals("Female"))
		{
			female.click();
		}else if(gender.equals("Male"))
		{
			male.click();
		}else {
			others.click();
		}*/
		String gender = "Female";
		/*List<WebElement> genders = driver.findElements(By.xpath("//input[@type='radio']"));
		
		for(WebElement option:genders)
		{
			if(option.getText().equals(gender))
			{
				option.click();
			}
		}*/
		
		//WebElement genderRadioBtn = driver.findElement(By.xpath("//label[text()='"+gender+"']/following-sibling::input"));
		
		
		String xpath = "//label[text()='Placeholder']/following-sibling::input";
		
		String newXpath = xpath.replace("Placeholder",gender);
		
		WebElement genderRadioBtn = driver.findElement(By.xpath(newXpath));
		genderRadioBtn.click();
		//Thread.sleep(1000);
		
		//WebElement signup = driver.findElement(By.cssSelector(""));
		//driver.close();

	}

}
