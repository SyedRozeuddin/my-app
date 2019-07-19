package A4_Allure_Report_Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Search_order_by_providing_order_by_providing_PO_NO {
	
	public WebDriver driver ;
	public String url = "https://customa4.com/";
	@BeforeTest
	//this set executes first by providing details about the browser
	public void setbrowser() {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\A\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}


	@Test()
	public void login() throws InterruptedException {

	
		//this is the to press the sign in on the home page
		driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//this is to provide the user name
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("kanwar@livewirelabs.co");
		
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Password01");
		Thread.sleep(2000);
		//click on login button 
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test(dependsOnMethods = {"login"})
	public void select_sport() throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath("//a[contains(text(),'ORDERS')]")).click();
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@id='order_search_po_number'][@placeholder='PO#']")).sendKeys("PO#:PO1324");
		
		Actions action = new Actions(driver); action.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(8000);
		driver.close();
	}
	
	
	

}
