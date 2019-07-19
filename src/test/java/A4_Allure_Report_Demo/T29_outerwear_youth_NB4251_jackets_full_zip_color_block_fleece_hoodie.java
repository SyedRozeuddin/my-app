package A4_Allure_Report_Demo;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class T29_outerwear_youth_NB4251_jackets_full_zip_color_block_fleece_hoodie {

	
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
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("jdubois@a4.com");
		
//		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("Password01");
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		//click on login button 
//		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test(dependsOnMethods = {"login"})
	public void select_sport() throws InterruptedException {
	
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='DECORATE']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@alt='Outerwear']")).click();
	}

	@Test(dependsOnMethods = {"select_sport"})
	public void select_gender_garment() {
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-garment-id='1'][@data-gender-id='3']")).click();

	}
	@Test(dependsOnMethods = {"select_gender_garment"})
	public void select_style_decoration() throws InterruptedException {
	
		driver.findElement(By.xpath("//img[@src='https://s3.amazonaws.com/a4-assets/styles/thumbnails/000/000/185/original/NB.PNG?1534571082']")).click();
		driver.findElement(By.xpath("//div[@data-color-id='119']")).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath(" //input[@id='saveUni']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-placement='F10']")).click();
		driver.findElement(By.xpath("//a[@id='next_step']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logo')]")).click();
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='style_method']")));
		sel.selectByIndex(1);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@id='preview_decoration_item']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@data-object='223']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='complete_decoration_btn']")).click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='add_cart_bt_new']")).click();
		driver.findElement(By.xpath("//button[@id='add_cart_redirect_bt_not_save']")).click();
	}

	@Test(dependsOnMethods = {"select_style_decoration"})
	public void select_quantity() {
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='quantity_XL']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_XL']")).sendKeys("5");
		driver.findElement(By.xpath("//div[@id='pricing_table_container']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String unitprice1=driver.findElement(By.xpath("//table[@id='decoration_prices']//tr[3]//td[5]")).getText();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//String unitprice2=driver.findElement(By.xpath("//table[@id='decoration_prices']//tr[4]//td[5]")).getText();
		System.out.println("Unit Price  is " + unitprice1);
		//System.out.println("Unit Price  is " + unitprice2);
		driver.findElement(By.xpath("//input[@id='add_to_cart']")).click();

	}

	@Test(dependsOnMethods = {"select_quantity"})
	public void cart() {
		
		String subtotal = driver.findElement(By.xpath("//y[@class='cart-total-price'][1]")).getText();
		String artproof = driver.findElement(By.xpath("//y[@class='cart-total-price'][4]")).getText();
		System.out.println("the subtotal price in cart is " + subtotal);
		System.out.println("the art proof price is " + artproof);
		driver.findElement(By.xpath("//a[@class='btn customer-btn-green']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String final_estimated_price =driver.findElement(By.xpath("//y[@class='cart-estimate-price'][1]")).getText();
		System.out.println("the final estimated price in checkout is" + final_estimated_price);	
		driver.findElement(By.xpath("//input[@id='po_number']")).sendKeys("#po2332");
		driver.findElement(By.xpath("//input[@value='Place Order']")).click();
		driver.findElement(By.xpath(" //a[@class='btn customer-btn-primary-large']")).click();
		driver.close();
	}

	/*
	 * @Test(dependsOnMethods = {"cart"}) public void orderacknowledgement() {
	 * 
	 * driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	 * ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
	 * driver.switchTo().window(list.get(1)); String orderack_art_proof =
	 * driver.findElement(By.xpath("//span[1]//strong[1]")).getText(); String
	 * orderack_subtotal =
	 * driver.findElement(By.xpath("//span[2]//strong[1]")).getText();
	 * System.out.println("the art proof price at the order acknowledgement is " +
	 * orderack_art_proof);
	 * System.out.println("the subtotal price at the order acknowledgement is " +
	 * orderack_subtotal); driver.switchTo().window(list.get(0)); driver.close();
	 * driver.switchTo().window(list.get(1)); driver.close();
	 * 
	 * }
	 */

}

