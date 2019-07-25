package ukwebsite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class zoopla {
	public static WebDriver driver;

	@BeforeTest
	public void setup() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\nikil kaarthi\\Downloads\\chrome_exe\\74\\chromedriver.exe");
		//Thread.sleep(2000);
		driver=new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(100,TimeUnit.SECONDS);
		
		Thread.sleep(3000);
		
	}
	@Test(priority=0)
	public void home_price() throws InterruptedException
	{
		driver.get("https://www.zoopla.co.uk");
		driver.findElement(By.xpath("//input[@id='search-input-location']")).sendKeys("London");
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		List<WebElement> link=driver.findElements(By.tagName("a"));
		List<WebElement> links=driver.findElements(By.xpath("//*[@class='listing-results-price text-price']"));
		//driver.findElement(By.className("listing-results-price text-price"));
		//List<WebElement> links=driver.findElements(By.xpath("//*[@href='/for-sale/details/52167082?featured=1&amp;utm_content=featured_listing' and @class='listing-results-price text-price'"));
	   Thread.sleep(3000);
		for(int i=0;i<links.size();i++)
		{
			System.out.println("Links name are"+links.get(i).getText());
			
		}
		String text=links.get(5).getText();
		System.out.println("5th element is"+text);
		links.get(5).click();
		//driver.findElement(By.xpath("html/body/div/div/div/div/div/div/[@class='ui-agent__name']")).click();
		
		//driver.findElement(By.xpath("//a[@class='ui-agent__details']")).click();
		    
	}
	
	@Test(priority=1)
	public void click_on_element() throws InterruptedException
	{
		Thread.sleep(1000);
		String t2=driver.findElement(By.xpath("html/body/main/div/div/div/div/div/div/a/div/h4[@class='ui-agent__name']")).getText();
		driver.findElement(By.xpath("html/body/main/div/div/div/div/div/div/a/div/h4[@class='ui-agent__name']")).click();
		//String t2=driver.findElement(By.xpath("html/body/main/div/div/div/div/div/div/a/div/h4[@class='ui-agent__name']")).getText();
		 String t1= driver.findElement(By.xpath("html/body/div/div/div/div/h1/b")).getText();
         System.out.println("The Agent name is"+t1);
		  Assert.assertEquals(t1,t2);
	  
		
		
	}
	  @AfterTest
	   public void window_close()
	   {
		 driver.quit();
	   }

	

}
