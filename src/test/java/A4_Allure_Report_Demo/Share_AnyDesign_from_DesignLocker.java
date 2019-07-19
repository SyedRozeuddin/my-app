package A4_Allure_Report_Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Share_AnyDesign_from_DesignLocker {

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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//click on login button 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[contains(text(),'DESIGNS')]")).click();
		
		driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		

	}
	@Test(dependsOnMethods = {"login"})
	public void Share_from_DesignLocker() {
		
		
		driver.findElement(By.xpath("//a[@data-foo='4024']")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='from']")).sendKeys("agha@livewirelabs.co");
		driver.findElement(By.xpath("//input[@id='cust_email']")).sendKeys("shahryar@livewirelabs.co");
	//	driver.findElement(By.xpath("//input[@id='share_design_btn']")).sendKeys("subject");
		driver.findElement(By.xpath("//textarea[@id='content']")).sendKeys("content");
		driver.findElement(By.xpath("//div[@class='col-md-12']//input[@name='commit']")).click();
		driver.close();
		
	}
	
	
	
}
