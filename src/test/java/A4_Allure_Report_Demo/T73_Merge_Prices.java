package A4_Allure_Report_Demo;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class T73_Merge_Prices {
	
	
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
		public void Login() throws InterruptedException {
			
			 
			driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
			
			
			driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("jdubois@a4.com");
			
//			driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Password01");
			
			driver.findElement(By.xpath("//form[@id='authForm']//input[@name='commit']")).click();
//			driver.findElement(By.xpath("//input[@value='Login']")).click();
			Thread.sleep(2000);
			

			
			
		}
		
		
		@Test(dependsOnMethods = {"Login"})
		public void Design()  {
			
			 
			driver.findElement(By.xpath("//a[contains(text(),'DESIGNS')]")).click();
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
						
			
		}
		
		
		@Test(dependsOnMethods = {"Design"})
		public void AddToCart() throws InterruptedException {
			
			 
			driver.findElement(By.xpath("//a[contains(@href,'/customer/orders/new?uniform_id=3548')][text()='Add to Cart']")).click();
			Thread.sleep(2000);
			
			
		}
		
		
		
		
		
		@Test(dependsOnMethods = {"AddToCart"})
		public void Select_Quantity() throws InterruptedException {
			
			 
			driver.findElement(By.xpath("//input[@id='quantity_S']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_S']")).sendKeys("5");

			driver.findElement(By.xpath("//input[@id='quantity_M']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_M']")).sendKeys("5");
			
			driver.findElement(By.xpath("//input[@id='quantity_L']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_L']")).sendKeys("10");
			
			driver.findElement(By.xpath("//input[@id='add_to_cart']")).click();
			Thread.sleep(2000);
			
			
		}
		
		
		
		@Test(dependsOnMethods = {"Select_Quantity"})
		public void Select_More_designs() throws InterruptedException {
			
			 
			
			driver.findElement(By.xpath("//a[contains(text(),'Add from Design Locker')]")).click();
			Thread.sleep(2000);
			
		}
		
		
		
		@Test(dependsOnMethods = {"Select_More_designs"})
		public void AddToCart2() throws InterruptedException {
			
			 
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(@href,'/customer/orders/new?uniform_id=3810')][text()='Add to Cart']")).click();
			Thread.sleep(2000);	
			
		}
		
		
		@Test(dependsOnMethods = {"AddToCart2"})
		public void Select_Quantity2() throws InterruptedException {
			
			 
			driver.findElement(By.xpath("//input[@id='quantity_S']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_S']")).sendKeys("5");

			driver.findElement(By.xpath("//input[@id='quantity_M']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_M']")).sendKeys("5");
			
			driver.findElement(By.xpath("//input[@id='quantity_L']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_L']")).sendKeys("10");
			
			driver.findElement(By.xpath("//input[@id='add_to_cart']")).click();
			Thread.sleep(2000);
			
			
		}
		
		
		@Test(dependsOnMethods = {"Select_Quantity2"})
		public void Select_More_designs2() throws InterruptedException {
			
			 
			
			driver.findElement(By.xpath("//a[contains(text(),'Add from Design Locker')]")).click();
			Thread.sleep(2000);
			
		}
		
		
		
		
		
		@Test(dependsOnMethods = {"Select_More_designs2"})
		public void AddToCart3() throws InterruptedException {
			
			 
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(@href,'/customer/orders/new?uniform_id=3455')][text()='Add to Cart']")).click();
			Thread.sleep(2000);	
			
		}
		
		
		
		@Test(dependsOnMethods = {"AddToCart3"})
		public void Select_Quantity3() throws InterruptedException {
			
			 
			driver.findElement(By.xpath("//input[@id='quantity_S']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_S']")).sendKeys("5");

			driver.findElement(By.xpath("//input[@id='quantity_M']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_M']")).sendKeys("5");
			
			driver.findElement(By.xpath("//input[@id='quantity_L']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_L']")).sendKeys("5");
			
			driver.findElement(By.xpath("//input[@id='add_to_cart']")).click();
			Thread.sleep(2000);
			
			
		}
		
		@Test(dependsOnMethods = {"Select_Quantity3"})
		public void Select_More_designs3() throws InterruptedException {
			
			 
			
			driver.findElement(By.xpath("//a[contains(text(),'Add from Design Locker')]")).click();
			Thread.sleep(2000);
			
		}
		
		@Test(dependsOnMethods = {"Select_More_designs3"})
		public void AddToCart4() throws InterruptedException {
			
			 
			
			driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			driver.findElement(By.xpath("//a[contains(@href,'/customer/orders/new?uniform_id=3454')][text()='Add to Cart']")).click();
			Thread.sleep(2000);	
			
		}
		
		
		
		@Test(dependsOnMethods = {"AddToCart4"})
		public void Select_Quantity4() throws InterruptedException {
			
			 
			driver.findElement(By.xpath("//input[@id='quantity_S']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_S']")).sendKeys("5");

			driver.findElement(By.xpath("//input[@id='quantity_M']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_M']")).sendKeys("5");
			
			driver.findElement(By.xpath("//input[@id='quantity_L']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_L']")).sendKeys("5");
			
			driver.findElement(By.xpath("//input[@id='add_to_cart']")).click();
			Thread.sleep(2000);
			
			
		}
		
		
		
		@Test(dependsOnMethods = {"Select_Quantity4"})
		public void CheckOut() throws InterruptedException {
			
			 

			
			driver.findElement(By.xpath("//a[@class='btn customer-btn-green']")).click();
			Thread.sleep(2000);
			
			
		}
		
		
		@Test(dependsOnMethods = {"CheckOut"})
		public void PlaceOrder() throws InterruptedException  {
			

			
			driver.findElement(By.xpath("//input[@id='request_shipping_date']")).sendKeys("06112019");
			
			driver.findElement(By.xpath("//input[@id='po_number']")).sendKeys("Automation");
			
			driver.findElement(By.xpath("//textarea[@id='order_note']")).sendKeys("Nothing!");
			
			
			driver.findElement(By.xpath("//div[@class='row col-md-12 form99']//input[@name='commit']")).click();
			
			driver.close();
			
			
		}
		
		
	/*
	 * @Test(dependsOnMethods = {"PlaceOrder"}) public void Order_Acknowledgment()
	 * throws InterruptedException {
	 * 
	 * 
	 * 
	 * driver.findElement(By.xpath("//a[@class='btn customer-btn-primary-large']")).
	 * click();
	 * 
	 * ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
	 * driver.switchTo().window(list.get(1));
	 * 
	 * String orderack_art_proof =
	 * driver.findElement(By.xpath("//p[contains(text(),'Price: $531.00')]")).
	 * getText();
	 * 
	 * String orderack_subtotal =
	 * driver.findElement(By.xpath("//span[3]//strong[1]")).getText();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * Assert.assertEquals(orderack_art_proof, orderack_subtotal);
	 * 
	 * 
	 * 
	 * //System.out.println("the art proof price at the order acknowledgement is " +
	 * orderack_art_proof);
	 * 
	 * //System.out.println("the subtotal price at the order acknowledgement is " +
	 * orderack_subtotal);
	 * 
	 * driver.switchTo().window(list.get(0)); driver.close();
	 * driver.switchTo().window(list.get(1)); driver.close();
	 * 
	 * 
	 * 
	 * }
	 */
		

			 

}
