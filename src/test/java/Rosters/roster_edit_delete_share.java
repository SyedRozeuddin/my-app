package Rosters;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class roster_edit_delete_share {
	
	public WebDriver driver ;
	public String url = "https://customa4.com/";
	 
	 
	 @BeforeTest
	 public void setbrowser() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\A\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(url);
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 
	 
	 }
	 
	 
		@Test
		public void Login() {
			
			 
			driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
			
			
			driver.findElement(By.xpath(" //input[@id='user_email']")).sendKeys("jdubois@a4.com");
			
			driver.findElement(By.xpath("//form[@id='authForm']//input[@name='commit']")).click();

			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			

			
			
		}
		
		@Test(dependsOnMethods = {"Login"})
		public void Rosters()  {
			
			 
			driver.findElement(By.xpath("//a[contains(text(),'ROSTERS')]")).click();
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			
		}
		
		@Test(dependsOnMethods = {"Rosters"})
		public void Edit_Roster()  {
			
			 
			driver.findElement(By.xpath("//tbody//tr[1]//th[5]"));
			driver.findElement(By.xpath("//a[@id='edit-roster-modal-link-new']")).click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//div[@id='rosterEditModal']//input[@id='name']")).clear();
			
			driver.findElement(By.xpath("//div[@id='rosterEditModal']//input[@id='name']")).sendKeys("Edit_1");
			
			driver.findElement(By.xpath("//div[@id='rosterEditModal']//input[@name='commit']")).click();
			
		}
		
		
//		@Test(dependsOnMethods = {"Edit_Roster"})
//		public void Move_Roster()  {
//			
//			 
//			driver.findElement(By.xpath("//tbody//tr[1]//th[5]"));
//			driver.findElement(By.xpath("//a[@class='move_click']")).click();
//			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
//			
//			driver.findElement(By.xpath("//button[@id='move_to_folder']")).click();
//			
//			
//			
//		}
//		@Test(dependsOnMethods = {"Move_Roster"})
//		public void Select_folder_Roster()  {
//			
//			 
//			Select selectfolder = new Select(driver.findElement(By.xpath("//select[@id='roster_folders']")));
//			selectfolder.selectByIndex(1);
//		
//			
//			
//		}
		
		
		
		
		
		@Test(dependsOnMethods = {"Edit_Roster"})
		public void Share_Roster()  {
			

			driver.findElement(By.xpath("//div[@class='row']//tbody//tr[1]"));
			driver.findElement(By.xpath("//tbody//tr[1]//th[5]"));
			driver.findElement(By.xpath("//a[@class='share_click']")).click();
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//div[@id='rosterShareModel']//input[@id='from']")).sendKeys("agha@livewirelabs.co");
			driver.findElement(By.xpath("//div[@id='rosterShareModel']//input[@id='cust_email']")).sendKeys("shahriyar@livewirelabs.co");
			driver.findElement(By.xpath("//div[@id='rosterShareModel']//textarea[@id='content']")).sendKeys("hello");
			driver.findElement(By.xpath("//div[@id='rosterShareModel']//input[@name='commit']")).click();
		}
		
		
	
	
	
	
	

}
