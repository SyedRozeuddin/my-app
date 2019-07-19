package Backend;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Orders {
	
	public WebDriver driver ;
	public String url = "http://prod-a4-elb-171359601.us-west-2.elb.amazonaws.com/admin/login";
	 
	 
	 @BeforeTest
	 public void setbrowser() {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\A\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		 driver=new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get(url);
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		 
	 
	 }
	
		@Test
		public void Login(){
			
			//enter valid email
			driver.findElement(By.xpath("//input[@id='admin_user_email']")).sendKeys("admin@a4_configurator.com");
			
			//enter valid pass
			driver.findElement(By.xpath("//input[@id='admin_user_password']")).sendKeys("A4lwl1112");
			
			driver.findElement(By.xpath("//input[@name='commit']")).click();

		}
		
		@Test(dependsOnMethods = {"Login"})
		public void Order(){
			
			
			
			driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();

		}
		
		@Test(dependsOnMethods = {"Order"})
		public void Order_acknowledgment() {
			
			 //click on Order_acknowledgment button
			driver.findElement(By.xpath("//a[contains(@href,'/customer/orders/MTI5NQ')]")).click();
			
			 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			//for tab switching
			ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list.get(1));
			
			//text assertion
			String text = driver.findElement(By.xpath("//span[contains(text(),'Order Confirmation: LW001295VN')]")).getText();
			Assert.assertEquals("Order Confirmation: LW001295VN", text);
			
			
			//driver.close();
			driver.switchTo().window(list.get(1));
			driver.close();
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.switchTo().window(list.get(0));
					
		}
			
		@Test(dependsOnMethods = {"Order_acknowledgment"})
		public void Decoration_Preview() {
			
			 //click on decoration button
			driver.findElement(By.xpath("//a[contains(@href,'/admin/orders/1296/art_proof')][text()='Decoration Preview']")).click();
			
			 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			//for tab switching
			ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list.get(1));
			
			
			//text assertion
			String text = driver.findElement(By.xpath(" //h2[contains(text(),'DECORATION PREVIEW')]")).getText();
			Assert.assertEquals("DECORATION PREVIEW", text);
			
			//driver.close();
			driver.switchTo().window(list.get(1));
			driver.close();
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.switchTo().window(list.get(0));
					
		}
		
		@Test(dependsOnMethods = {"Decoration_Preview"})
		public void Work_Order() {
			
			 //click on decoration button
			driver.findElement(By.xpath("//a[contains(@href,'/admin/orders/1296/print_order')]")).click();
			
			 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			//for tab switching
			ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list.get(1));
			
			
			//text assertion
			String text = driver.findElement(By.xpath("//strong[contains(text(),'Terms')]")).getText();
			Assert.assertEquals("Terms", text);
			
			//driver.close();
			driver.switchTo().window(list.get(1));
			driver.close();
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.switchTo().window(list.get(0));
					
		}
		
		@Test(dependsOnMethods = {"Work_Order"})
		public void Notes() {
			
			 //click on decoration button
			driver.findElement(By.xpath("//a[contains(@href,'/admin/orders/1296/order_notes')]")).click();
			
			 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			
			//text assertion
			String text = driver.findElement(By.xpath("//h2[@id='page_title']")).getText();
			Assert.assertEquals("Order Notes", text);
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
					
		}
		
		@Test(dependsOnMethods = {"Notes"})
		public void View_Order() {
			
			 //click on decoration button
			driver.findElement(By.xpath("//a[contains(@href,'/admin/orders/1300')][text()='View']")).click();
			
			 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			
			//text assertion
			String text = driver.findElement(By.xpath("//h2[@id='page_title']")).getText();
			Assert.assertEquals("Order #1300", text);
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
		//	driver.findElement(By.xpath("//a[contains(text(),'Orders')]")).click();
		
					
		}
		
		@Test(dependsOnMethods = {"View_Order"})
		public void Share_Order() {
			
			 //click on decoration button
			driver.findElement(By.xpath("//a[@id='share_btn_admin']")).click();
			
			 driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			 
			 //add data in popup
			 driver.findElement(By.xpath("//input[@id='from']")).sendKeys("agha@livewielabs.co");
			 
			 driver.findElement(By.xpath("//input[@id='cust_email']")).sendKeys("agha@livewielabs.co");
			 
			 driver.findElement(By.xpath("//textarea[@id='content']")).sendKeys("order 1300");
			
			//Checkboxes
			 driver.findElement(By.xpath("//input[@name='ack_check']")).click();
			 driver.findElement(By.xpath("//input[@name='check_preview']")).click();
			 driver.findElement(By.xpath("//input[@name='check_work']")).click();
			 driver.findElement(By.xpath("//input[@name='check_roster_338']")).click();
			 
			 
			 driver.findElement(By.xpath("//input[@name='commit']")).click();
			 
			 
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
		
					
		}
	

}
