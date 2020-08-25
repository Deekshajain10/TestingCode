package interview;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Questiontwo {

	public static void main(String[] args) throws Exception {
		//Launching a new Browser
		System.setProperty("webdriver.chrome.driver", "D:\\driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//Opening the URL
		driver.get("http://jt-dev.azurewebsites.net/#/SignUp");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		//validating the dropdown
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/section[1]/div[1]/div[2]/section[1]/div[1]/div[1]/span[1]")).click();
		List<WebElement> dd_menu= driver.findElements(By.xpath("//ul[@role='listbox']/li/div/a/div"));
		for(int i = 0; i < dd_menu.size(); i++)
		{
			WebElement element=  dd_menu.get(i);
			String innerhtml= element.getAttribute("innerHTML");
			if(innerhtml.contentEquals("Dutch"))
			{
				element.click();
				break;
			}
			/*Validation for dropdown value 'English'
			 * if(innerhtml.contentEquals("English"))
			{
				element.click();
				break;
			}*/
			
		}	
		//filling the name
	    driver.findElement(By.id("name")).sendKeys("Deeksha Jain");
	    //Filling the Organization name
	    driver.findElement(By.id("orgName")).sendKeys("Deeksha Jain");
	    //input email address
	    driver.findElement(By.name("email")).sendKeys("deekshajain10@gmail.com");
	    //Validating the Checkbox
	    driver.findElement(By.xpath("//label[@class='ui-checkbox']/span")).click();
	    // Click on Sign Up button
	    driver.findElement(By.xpath("//div[@class='form-group custom-form-group']/button")).click();
	    Thread.sleep(7000);
	    driver.close();

	}
	
}
