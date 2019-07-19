package A4_Allure_Report_Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Share_AnyDesign_from_Admin {

	public WebDriver driver ;
	public String url = "https://customa4.com/admin/login";

	
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
	//	driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
	//	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//this is to provide the user name
		driver.findElement(By.xpath("//input[@id='admin_user_email']")).sendKeys("admin@a4_configurator.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//input[@id='admin_user_password']")).sendKeys("A4lwl1112");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		

	}
	@Test(dependsOnMethods = {"login"})
	public void Share_from_Admin_Orders() {
		
		
		driver.findElement(By.xpath("//a[@href='/admin/orders/2244']")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='share_btn_admin']")).click();
		
		driver.findElement(By.xpath("//input[@id='from']")).sendKeys("agha@livewirelabs.co");
		driver.findElement(By.xpath("//input[@id='cust_email']")).sendKeys("shahryar@livewirelabs.co");
		driver.findElement(By.xpath("//textarea[@id='content']")).sendKeys("content");
		driver.findElement(By.xpath("//input[@name='commit']")).click();
		driver.close();
		
	}
	
	
	
}
