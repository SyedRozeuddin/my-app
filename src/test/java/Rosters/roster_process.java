package Rosters;


import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class roster_process {
	
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
			
			//add Roster
			driver.findElement(By.xpath("//a[@class='a4-btn a4-btn-red']")).click();
						
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		
		@Test(dependsOnMethods = {"Rosters"})
		public void Add_Rosters()  {
			
			 //adding player one
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Tester Testing");
			
			driver.findElement(By.xpath("//input[@id='team_team_players__name']")).sendKeys("Tester1");
			
			driver.findElement(By.xpath("//input[@id='team_team_players__number']")).sendKeys("10");
			
			Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='team_team_players__size']")));
			sel2.selectByIndex(4);
			
			driver.findElement(By.xpath("//span[contains(text(),'Add Player')]")).click();
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			//adding player two
			driver.findElement(By.xpath("//tr[2]//td[1]//input[1]")).sendKeys("Tester2");
			
			driver.findElement(By.xpath("//tr[2]//td[2]//input[1]")).sendKeys("7");
			
			Select sele1 = new Select(driver.findElement(By.xpath("//tr[2]//td[3]//select[1]")));
			sele1.selectByIndex(3);
			
			driver.findElement(By.xpath("//div[@id='rosterAddModal']//input[@name='commit']")).click();
			
			
			//moving to design locker
			driver.findElement(By.xpath("//li[7]//a[1]")).click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);			
						
			
		}
		
		
		@Test(dependsOnMethods = {"Add_Rosters"})
		public void AddToCart() {
			
			driver.findElement(By.xpath("//a[contains(@href,'/customer/orders/new?uniform_id=3481')][text()='Add to Cart']")).click();
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//button[@id='printPageButton']")).click();
		
			
		}
		
		@Test(dependsOnMethods = {"AddToCart"})
		public void Select_Roster() {
			
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//div[@class='modal-dialog modal-lg']//div[@class='modal-body']"));
			
			
			WebElement linkByText = driver.findElement(By.linkText("TEST 2"));
			linkByText.click();
			
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
		
			
		}
		
		@Test(dependsOnMethods = {"Select_Roster"})
		public void Add_quantity() {
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
			driver.findElement(By.xpath("//input[@id='team_quantity_S']")).clear();
			driver.findElement(By.xpath("//input[@id='team_quantity_S']")).sendKeys("2");
			
			driver.findElement(By.xpath("//input[@id='team_quantity_M']")).clear();
			driver.findElement(By.xpath("//input[@id='team_quantity_M']")).sendKeys("2");
			
			driver.findElement(By.xpath("//input[@id='team_quantity_L']")).clear();
			driver.findElement(By.xpath("//input[@id='team_quantity_L']")).sendKeys("2");
			
			driver.findElement(By.xpath("//input[@id='team_quantity_XL']")).clear();
			driver.findElement(By.xpath("//input[@id='team_quantity_XL']")).sendKeys("2");
			
			
			
			driver.findElement(By.xpath("//input[@id='add_to_cart']")).click();
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
			//checkout
			driver.findElement(By.xpath("//a[@class='btn customer-btn-green']")).click();
		
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		}
		
		
		@Test(dependsOnMethods = {"Add_quantity"})
		public void Place_Order()   {
			

			
			driver.findElement(By.xpath("//input[@id='request_shipping_date']")).sendKeys("10202019");
			
			driver.findElement(By.xpath("//input[@id='po_number']")).sendKeys("Automation");
			
			driver.findElement(By.xpath("//textarea[@id='order_note']")).sendKeys("Nothing!");
			
			
			driver.findElement(By.xpath("//div[@class='row col-md-12 form99']//input[@name='commit']")).click();
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
		
			
			
		}
		
		@Test(dependsOnMethods = {"Place_Order"})
		public void Order_Acknowledgment() {
			
			
			
			driver.findElement(By.xpath("//a[@class='btn customer-btn-primary-large']")).click();

			ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
			driver.switchTo().window(list.get(1));
			
			
			//text assertion
			String text = driver.findElement(By.xpath("//strong[contains(text(),'Sub Total:')]")).getText();
			Assert.assertEquals("Sub Total:", text);
			
			String textt = driver.findElement(By.xpath("//p[contains(text(),'Price:')]")).getText();
			Assert.assertEquals("Price:", textt);
			
			if(text.equals(textt)) {
				
				
				System.out.println("The two strings are the same.");
			}
			else {
				
				System.out.println("The two strings are not same.");
			}
			
			
			
			//driver.close();
			driver.switchTo().window(list.get(1));
			driver.close();
			
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			driver.switchTo().window(list.get(0));
			
			
			
			
		
			
			
		}
		

	
	
	

}
