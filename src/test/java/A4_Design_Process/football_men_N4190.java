package A4_Design_Process;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class football_men_N4190 {

	public ExtentTest test;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public WebDriver driver ;
	public String url = "https://customa4.com/";

	@BeforeTest
	//this set executes first by providing details about the browser
	public void setbrowser() {
		htmlReporter = new ExtentHtmlReporter("football_men_N4190.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\A\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	
	}
	@Test()
	public void login() throws InterruptedException {

		test = extent.createTest("Login", "test for login");
		test.info("login funtionality of A4 is passed");
		test.pass("login was successful");
		//this is the to press the sign in on the home page
		driver.findElement(By.xpath("//a[contains(text(),'SIGN IN')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//this is to provide the user name
		driver.findElement(By.xpath("//input[@id='user_email']")).sendKeys("jdubois@a4.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//click on login button 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	@Test(dependsOnMethods = {"login"})
	public void select_sport() throws InterruptedException {
		test = extent.createTest("sport selection", "test for selecting sport");
		test.info("select sport funtionality of A4 is passed");
		test.pass("sport selection was successful");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='DECORATE']")).click();
	//	driver.findElement(By.xpath("//a[contains(text(),'Start New')]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@alt='Football']")).click();
	}

	@Test(dependsOnMethods = {"select_sport"})
	public void select_gender_garment() {
		test = extent.createTest("gender and garment selection", "test for gender and garment selection");
		test.info("test of garment selection funtionality of A4 is passed");
		test.pass("garment and gender selection was successful");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-garment-id='2'][@data-gender-id='1']")).click();

	}
	@Test(dependsOnMethods = {"select_gender_garment"})
	public void select_style_decoration() throws InterruptedException {
		test = extent.createTest("select style of garment and also decoration", "test for style and decoration selection");
		test.info("test of style and decoration selection funtionality of A4 is passed");
		test.pass("style plus decoration selection was successful");
		driver.findElement(By.xpath("//img[@alt='N4190']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PUR')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(" //input[@id='saveUni']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-placement='F02']")).click();
		driver.findElement(By.xpath("//a[@id='next_step']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Team Name')]")).click();
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='style_method']")));
		sel.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='complete_decoration_btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Add a Decoration')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='#back']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-placement='B02']")).click();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='next_step']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Player Name')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='style_method']")));
		sel2.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='complete_decoration_btn']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='add_cart_bt_new']")).click();
		driver.findElement(By.xpath("//button[@id='add_cart_redirect_bt_not_save']")).click();
	}

	@Test(dependsOnMethods = {"select_style_decoration"})
	public void select_quantity() {
		test = extent.createTest("quantity selection", "test for quantity selection");
		test.info("test of quantity selection funtionality of A4 is passed");
		test.pass("quantity selection was successful");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='quantity_2XL']")).clear();
		driver.findElement(By.xpath("//input[@id='quantity_2XL']")).sendKeys("5");
		driver.findElement(By.xpath("//div[@id='pricing_table_container']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String unitprice1=driver.findElement(By.xpath("//table[@id='decoration_prices']//tr[3]//td[5]")).getText();
		String unitprice2=driver.findElement(By.xpath("//table[@id='decoration_prices']//tr[4]//td[5]")).getText();
		System.out.println("Unit Price  is " + unitprice1);
		System.out.println("Unit Price  is " + unitprice2);
		driver.findElement(By.xpath("//input[@id='add_to_cart']")).click();

	}

	@Test(dependsOnMethods = {"select_quantity"})
	public void cart() {
		test = extent.createTest("cart price", "test for cart price");
		test.info("test of cart price funtionality of A4 is passed");
		test.pass("cart price was successful");
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

	}

	@Test(dependsOnMethods = {"cart"})
	public void orderacknowledgement() {
		test = extent.createTest("order acknowledgement", "test for orderacknowledgement page");
		test.info("test of order acknowledgement funtionality of A4 is passed");
		test.pass("order acknowledgement page was successful");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		ArrayList<String> list = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(list.get(1));
		String orderack_art_proof = driver.findElement(By.xpath("//span[1]//strong[1]")).getText();
		String orderack_subtotal = driver.findElement(By.xpath("//span[2]//strong[1]")).getText();
		System.out.println("the art proof price at the order acknowledgement is " + orderack_art_proof);
		System.out.println("the subtotal price at the order acknowledgement is " + orderack_subtotal);
		driver.switchTo().window(list.get(0));
		driver.close();
		driver.switchTo().window(list.get(1));
		driver.close();

	}

	@AfterTest
	public void close() {
		extent.flush();
	}



}
