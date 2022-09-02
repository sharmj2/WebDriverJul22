package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='customers']//tr"));
		
		System.out.println("the size of table is "+rows.size());
		
		List<WebElement> columns = driver.findElements(By.xpath("//table[@id='customers']//tr[1]/th"));

		System.out.println("the number of colums are "+columns.size());
		
		WebElement data = driver.findElement(By.xpath("//table[@id='customers']//tr[4]/td[1]"));

		System.out.println("Data is "+data.getText());
		
		
		/*Using ForEach loop*/
		for(WebElement row:rows)
		{
			//System.out.println(row);
			List<WebElement> cells = row.findElements(By.tagName("td"));
			
			for(WebElement cell:cells)
			{
				System.out.print(cell.getText()+" ");
			}
			System.out.println();
		}
		/*Using For loop*/
		for (int row =1;row<=rows.size();row++)
		{
			for(int col=1;col<=columns.size();col++)
			{
				WebElement cell = driver.findElement(By.xpath("//table[@id='customers']//tr["+row+"]/*["+col+"]"));
				System.out.print(cell.getText() +"  ");
			}
			
			System.out.println();
		}
		
		
		
		/*Get the Country name from company name is given*/
		
		String company = "Island Trading";
		
		String xpath = "//td[text()='"+company+"']/following-sibling::td[2]";
		WebElement countryname = driver.findElement(By.xpath(xpath));
		System.out.println("The Country name for given company is  "+countryname.getText());
		
		driver.close();
	}

}
