package A4_Design_Process;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class baseball_male_N4241 {

	//public ExtentTest test;
	//public ExtentHtmlReporter htmlReporter;
	//public ExtentReports extent;
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
		Thread.sleep(2000);
		//click on login button 
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Test(dependsOnMethods = {"login"})
	public void select_sport() throws InterruptedException {
		Thread.sleep(2000);
//		this is to press the decorate button on the home page
		driver.findElement(By.xpath("//a[text()='DECORATE']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		this is to select the sport
		driver.findElement(By.xpath("//img[@alt='Baseball']")).click();
	}

	@Test(dependsOnMethods = {"select_sport"})
	public void select_gender_garment() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		this is to select the gender and the garment
		driver.findElement(By.xpath("//a[@data-gender-id='1'][@data-garment-id='1']")).click();

	}

	@Test(dependsOnMethods = {"select_gender_garment"})
	public void select_style_decoration() throws InterruptedException {
//		this is to create test report on this particular test
		//		test = extent.createTest("select style of garment and also decoration", "test for style and decoration selection");
		//		test.info("test of style and decoration selection funtionality of A4 is passed");
		//		test.pass("style plus decoration selection was successful");
//		this is to select the style
		driver.findElement(By.xpath("//img[@alt='Capture']")).click();
//		this is to select the color
		driver.findElement(By.xpath("//button[contains(text(),'NVY')]")).click();
//		save the color
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		driver.findElement(By.xpath(" //input[@id='saveUni']")).click();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
//		this is to select the placement
		driver.findElement(By.xpath("//a[@data-placement='F06']")).click();
		driver.findElement(By.xpath("//a[@id='next_step']")).click();
//		this is to select the decoration
		driver.findElement(By.xpath("//a[contains(text(),'Logo')]")).click();
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='style_method']")));
		sel.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@id='preview_decoration_item']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@data-object='88']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='complete_decoration_btn']")).click();
		Thread.sleep(3000);
//		this is to add another decoration
		driver.findElement(By.xpath("//a[contains(text(),'Add a Decoration')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='#back']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-placement='B02']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='next_step']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Player Name')]")).click();
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='style_method']")));
		sel2.selectByIndex(1);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@id='complete_decoration_btn']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//		this is to add the item in the cart
		driver.findElement(By.xpath("//a[@id='add_cart_bt_new']")).click();
		driver.findElement(By.xpath("//button[@id='add_cart_redirect_bt_not_save']")).click();
	}

	@Test(dependsOnMethods = {"select_style_decoration"})
	public void select_quantity() {
//		this is to create test report on this particular test
		//		test = extent.createTest("quantity selection", "test for quantity selection");
		//		test.info("test of quantity selection funtionality of A4 is passed");
		//		test.pass("quantity selection was successful");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		this is to select the quantity of the item
		driver.findElement(By.xpath("//input[@id='quantity_XL']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_XL']")).sendKeys("5");
		driver.findElement(By.xpath("//div[@id='pricing_table_container']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		this is to get the unit price dynamically of the item related to their placement and decoration
		String unitprice1=driver.findElement(By.xpath("//table[@id='decoration_prices']//tr[3]//td[5]")).getText();
		String unitprice2=driver.findElement(By.xpath("//table[@id='decoration_prices']//tr[4]//td[5]")).getText();
		System.out.println("Unit Price  is " + unitprice1);
		System.out.println("Unit Price is " + unitprice2);
		driver.findElement(By.xpath("//input[@id='add_to_cart']")).click();

	}

	@Test(dependsOnMethods = {"select_quantity"})
	public void cart() {
//		this is to create test report on this particular test
		//		test = extent.createTest("cart price", "test for cart price");
		//		test.info("test of cart price funtionality of A4 is passed");
		//		test.pass("cart price was successful");
//		this is to get the subtotal price of item in the cart 
		String subtotal = driver.findElement(By.xpath("//y[@class='cart-total-price'][1]")).getText();
//		this is to get the art proof
		String artproof = driver.findElement(By.xpath("//y[@class='cart-total-price'][4]")).getText();
		System.out.println("the subtotal price in cart is " + subtotal);
		System.out.println("the art proof price is " + artproof);
//		this is to select he checkout option
		driver.findElement(By.xpath("//a[@class='btn customer-btn-green']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		this is to get the total price dynamically
		String final_estimated_price =driver.findElement(By.xpath("//y[@class='cart-estimate-price'][1]")).getText();
		System.out.println("the final estimated price in checkout is" + final_estimated_price);	
//		this is to provide the po number
		driver.findElement(By.xpath("//input[@id='po_number']")).sendKeys("#po2332");
//		this is to provide placeorder
		driver.findElement(By.xpath("//input[@value='Place Order']")).click();
//		this is to select the placeorder button
		driver.findElement(By.xpath(" //a[@class='btn customer-btn-primary-large']")).click();

	}

	@Test(dependsOnMethods = {"cart"})
	public void orderacknowledgement() {
//		this is to create test report on this particular test
		//		test = extent.createTest("order acknowledgement", "test for orderacknowledgement page");
		//		test.info("test of order acknowledgement funtionality of A4 is passed");
		//		test.pass("order acknowledgement page was successful");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
//		this is to get the ids of different windows being opened in the arraylist
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
//		this is to get the final art proof price from order acknowledgement
		String orderack_art_proof = driver.findElement(By.xpath("//span[1]//strong[1]")).getText();
//		this is to get the final total price of item in order acknowledgement
		String orderack_subtotal = driver.findElement(By.xpath("//span[2]//strong[1]")).getText();
		System.out.println("the art proof price at the order acknowledgement is " + orderack_art_proof);
		System.out.println("the subtotal price at the order acknowledgement is " + orderack_subtotal);
		driver.switchTo().window(list.get(0));
		driver.close();
		driver.switchTo().window(list.get(1));
		driver.close();

	}

//    @AfterTest
//	public void close() {
//		this is finalize the report
//		extent.flush();
//	}


}
