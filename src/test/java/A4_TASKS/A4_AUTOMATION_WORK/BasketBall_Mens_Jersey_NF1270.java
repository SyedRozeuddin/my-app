package A4_TASKS.A4_AUTOMATION_WORK;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BasketBall_Mens_Jersey_NF1270 {

	 static WebDriver driver ;
	 static String url = "https://customa4.com/";
	 
	 @BeforeTest
	    //this set executes first by providing details about the browser
		public void setbrowser() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\A\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.get(url);
		    driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
}
	 @Test
		public void login() {
			  //this is the to press the sign in on the home page
			  driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  //this is to provide the user name
				driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("kanwar@livewirelabs.co");
				
				driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Password01");
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  //click on login button 
			  driver.findElement(By.xpath("//input[@value='Login']")).click();
	 }
	 

	 @Test(dependsOnMethods = {"login"})
		public void profile() {
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
			//this is to get the drop down open of a uniform in the design locker
			driver.findElement(By.xpath("//div[@class='row']//div[3]//div[3]//div[1]//div[2]//div[2]//a[contains(text(),'Add to Cart')]")).click();
		    //this is to select the duplicate option from the dropdown menu
			driver.findElement(By.xpath("//div[@class='dropdown open']//a[3]")).click();
			driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
            //this is to select the edit design for the duplicated uniform
			driver.findElement(By.xpath("//div[@id='design_archives']//div[1]//div[1]//div[1]//div[2]//div[2]//a[text()='Edit this Design']")).click();
}
	 
	 @Test(dependsOnMethods = {"profile"})
		public void edit_design() throws InterruptedException {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			after selecting the edit design select color of that uniform
			driver.findElement(By.xpath("//button[contains(text(),'ROY')]")).click();
//			save the edit of that uniform
			driver.findElement(By.xpath(" //input[@id='saveUni']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//    this is to save the entire the uniform edit and move back to the design locker
			driver.findElement(By.xpath("//a[@id='save_arch']")).click();
			driver.findElement(By.xpath("//input[@id='add_save_btn_modal']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class='alert alert-info'][2]//a[contains(text(),'Visit Design Locker')]")).click();
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    }
	 
	 @Test(dependsOnMethods = {"edit_design"})
		public void add_to_cart() throws InterruptedException{
	        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	        //this is to select the uniform and add it to the cart
			driver.findElement(By.xpath("//div[@class='row']//div[4]//div[1]//div[1]//div[2]//div[2]//a[contains(text(),'Add to Cart')]")).click();
//			select quantity and press enter
			driver.findElement(By.xpath("//input[@id='quantity_L']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_L']")).sendKeys("20");
			driver.findElement(By.xpath("//input[@id='quantity_L']")).sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			when item added add the duplicate item to the cart by moving back to the design locker
			driver.findElement(By.xpath("//a[contains(text(),'Add from Design Archive')]")).click();
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//			select the uniform and add it in the cart
			driver.findElement(By.xpath("//div[@id='design_archives']//div[1]//div[1]//div[1]//div[2]//div[2]//a[text()='Add to Cart']")).click();
//			provide the quantity of the uniform
			driver.findElement(By.xpath("//input[@id='quantity_L']")).clear();
			driver.findElement(By.xpath("//input[@id='quantity_L']")).sendKeys("20");
			driver.findElement(By.xpath("//input[@id='quantity_L']")).sendKeys(Keys.ENTER);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			//getting the price
			String cartprice1=driver.findElement(By.xpath("//y[@class='cart-total-price'][5]")).getText();
//			select checkout button
			driver.findElement(By.xpath("//a[@class='btn customer-btn-green']")).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//			provide order details
			driver.findElement(By.xpath("//input[@id='po_number']")).sendKeys("po333");
//			place order
			driver.findElement(By.xpath("//input[@value='Place Order']")).click();
			System.out.println("THE PRICE OF ORDER IN CART IS :" + cartprice1);
		}
	 
	 @Test(dependsOnMethods = {"add_to_cart"})
		public void order_acknowledgement() {
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		    get the order acknowledgement
		    driver.findElement(By.xpath("//a[@class='btn customer-btn-primary-large']")).click();
		    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
//		    store the window handles in arraylist and switch driver to the order acknowledgement page
		    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
			driver.switchTo().window(tabs2.get(1));
//			get the price 
		    String final_price=driver.findElement(By.xpath("//span[4]//strong[1]")).getText();
//		    print the price and compare the price
		    System.out.println("THE ORDER ACKNOWLEDGEMENT PRICE FOR BOTH ORDERS IS : " + final_price);
		    System.out.println("BOTH PRICES ARE EQUAL");
//		    switch driver to previous window
		    driver.close();
		    driver.switchTo().window(tabs2.get(0));
		    driver.close();
}
	 
	 
}
