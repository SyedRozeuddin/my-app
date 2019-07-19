package A4_Allure_Report_Demo;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Share_T14_basketball_youth_NB3142_shirts_cooling_performance_crew {
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

	}
	@Test(dependsOnMethods = {"login"})
	public void select_sport() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='DECORATE']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElement(By.xpath("//a[contains(text(),'Start New')]")).click();
		driver.findElement(By.xpath("//img[@alt='Basketball']")).click();
	}

	@Test(dependsOnMethods = {"select_sport"})
	public void select_gender_garment() {
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-garment-id='8'][@data-gender-id='3']")).click();

	}
	@Test(dependsOnMethods = {"select_gender_garment"})
	public void select_style_decoration() throws InterruptedException {
		
		driver.findElement(By.xpath("//img[@alt='N3142']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PUR')]")).click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.findElement(By.xpath(" //input[@id='saveUni']")).click();
		driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@data-placement='F02']")).click();
		driver.findElement(By.xpath("//a[@id='next_step']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logo')]")).click();
		Select sel = new Select(driver.findElement(By.xpath("//select[@id='style_method']")));
		sel.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@id='preview_decoration_item']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@data-object='223']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='complete_decoration_btn']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[contains(text(),'Add a Decoration')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@href='#back']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@data-placement='B02']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='next_step']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Player Name')]")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Select sel2 = new Select(driver.findElement(By.xpath("//select[@id='style_method']")));
		sel2.selectByIndex(1);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='complete_decoration_btn']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//a[@id='add_share_new']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	}
	@Test(dependsOnMethods = {"select_style_decoration"})
	public void share() {
		
		
		driver.findElement(By.xpath("//input[@id='from']")).sendKeys("agha@livewirelabs.co");
		driver.findElement(By.xpath("//input[@id='cust_email']")).sendKeys("shahryar@livewirelabs.co");
		driver.findElement(By.xpath("//textarea[@id='content']")).sendKeys("shahryar@livewirelabs.co");
		driver.findElement(By.xpath("//div[@class='col-md-12']//input[@name='commit']")).click();
		driver.close();
		
		
	}








}
