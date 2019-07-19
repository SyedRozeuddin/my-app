package A4_Allure_Report_Demo;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class T71_Baseball_Tshirt {
	
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
		
//		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Password01");
		
		driver.findElement(By.xpath("//form[@id='authForm']//input[@name='commit']")).click();
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		

		
		
	}
	
	@Test(dependsOnMethods = {"Login"})
	public void Start() throws InterruptedException{
	

		driver.findElement(By.xpath("//a[contains(text(),'DECORATE')]")).click();
//		driver.findElement(By.xpath("//a[contains(text(),'Start New')]")).click();
		
		Thread.sleep(2000);
		
	}
	
	@Test(dependsOnMethods = {"Start"})
	public void SelectYourSport() throws InterruptedException {
		

				
		
//      	driver.findElement(By.xpath("//div[@class='check-list']//div[2]//div[1]//label[1]//span[2]//span[1]//img[1]")).click();
		driver.findElement(By.xpath("//div[@class='row']//div[1]//div[1]//label[1]//span[2]//span[1]//img[1]")).click();
		Thread.sleep(4000);
	
	
	}
	
	@Test(dependsOnMethods = {"SelectYourSport"})
	public void SelectYourGender() throws InterruptedException  {
		

		
		
	driver.findElement(By.xpath("//div[@class='row']//div[1]//ul[1]//li[5]//a[1]")).click();
	Thread.sleep(2000);
	
	
	}
	
	
	
	
	
	@Test(dependsOnMethods = {"SelectYourGender"})
	public void SelectShirtType() throws InterruptedException  {
		

		driver.findElement(By.xpath("//div[6]//div[1]//a[1]//img[1]")).click();
		Thread.sleep(2000);
	
	
	}
	
	@Test(dependsOnMethods = {"SelectShirtType"})
	public void SelectShirtColor() throws InterruptedException  {
		

		driver.findElement(By.xpath("//div[10]//button[1]")).click();
		
		Thread.sleep(2000);
		

		
		driver.findElement(By.xpath("//input[@id='saveUni']")).click();
		Thread.sleep(2000);
		
	}
	
	
	@Test(dependsOnMethods = {"SelectShirtColor"})
	public void Decoration() throws InterruptedException  {
		

		
		driver.findElement(By.xpath("//body[@id='uniform_builder']/main[@id='main']/div[@id='wizard_decorations_step']/div[@class='custom-container']/div[@class='row']/div[@class='sidebar col-lg-4 col-md-4 col-sm-12 display-sidebar']/div[@id='decorations_sidebar_container']/div[@class='container-content']/div[@id='placements_step']/div[@id='accordion']/div[@class='panel panel-default']/div[@id='front']/div[@class='panel-body']/div[@class='tile-view']/div[@class='row']/div[4]/div[1]/a[1]/*[1] ")).click();
//		driver.findElement(By.xpath("//a[@data-placement='F01']")).click();
		
		driver.findElement(By.xpath("//a[@id='next_step']")).click();
		Thread.sleep(2000);
	
		
		
	}
	
	
	
	
	
	@Test(dependsOnMethods = {"Decoration"})
	public void Decoration_two() throws InterruptedException  {
		

		driver.findElement(By.xpath("//a[contains(text(),'Graphic')]")).click();
		
		
		
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='style_method']")));
		sel2.selectByIndex(1);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@id='preview_decoration_item']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//body[@id='uniform_builder']//div[@class='row']//div[@class='row']//div[1]//div[1]//img[1]")).click();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath("//a[@id='complete_decoration_btn']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@id='add_cart_bt_new']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[@id='add_cart_redirect_bt_not_save']")).click();
		Thread.sleep(2000);
		
		
		
		
		
		driver.findElement(By.xpath("//input[@id='quantity_S']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_S']")).sendKeys("20");
		
		
		driver.findElement(By.xpath("//input[@id='quantity_M']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_M']")).sendKeys("15");
		
		driver.findElement(By.xpath("//input[@id='quantity_L']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_L']")).sendKeys("10");
		
		
		
		driver.findElement(By.xpath("//input[@id='add_to_cart']")).click();
		Thread.sleep(2000);
		
		
		
		
		
	
	}
	
	
	@Test(dependsOnMethods = {"Decoration_two"})
	public void CheckOut() throws InterruptedException  {
		

		driver.findElement(By.xpath("//a[@class='btn customer-btn-green']")).click();
		Thread.sleep(3000);
	
		
		
	}
	
	
	@Test(dependsOnMethods = {"CheckOut"})
	public void PlaceOrder() throws InterruptedException  {
		

		
		driver.findElement(By.xpath("//input[@id='request_shipping_date']")).sendKeys("06072019");
		
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
	 * System.out.println("the art proof price at the order acknowledgement is " +
	 * orderack_art_proof);
	 * 
	 * System.out.println("the subtotal price at the order acknowledgement is " +
	 * orderack_subtotal);
	 * 
	 * driver.switchTo().window(list.get(0)); driver.close();
	 * driver.switchTo().window(list.get(1)); driver.close();
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	

	
	
}
	
	
	
	
	
	


