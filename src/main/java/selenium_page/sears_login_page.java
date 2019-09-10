package selenium_page;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import sears_util.sears_utility_methods;

public class sears_login_page extends sears_utility_methods {
	
	WebDriver driver;
	
	//WebDriverWait wait = new WebDriverWait(driver, 10);
	public Properties propFileInvoke() throws IOException {
		File file = new File("src//main//resources//selenium_resource_util//config.properties");
		FileInputStream fis = new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}
	
	public void invokeBrowser() throws IOException {
		if(propFileInvoke().get("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", propFileInvoke().getProperty("driver_path"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}
	
	public void searsNavigation() throws IOException {
		String URL = propFileInvoke().getProperty("url");
		System.out.println(URL);
		driver.get(URL);
	}
	
	public void sears_login() throws IOException, InterruptedException {
		Thread.sleep(3000);
		System.out.println("Navigating to login");
		driver.findElement(By.id("yourAccount")).click();
		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='modalIframe']/iframe[1]")));
		Thread.sleep(2000);
		driver.findElement(By.id("email")).sendKeys(propFileInvoke().getProperty("username"));
		driver.findElement(By.id("password")).sendKeys(propFileInvoke().getProperty("password"));
		driver.findElement(By.xpath("//*[@id='universalSignInBtns']/button[1]/span")).click();
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		
	}
	
	public void manageMyAccount() throws InterruptedException {
		Actions action = new Actions(driver);
		driver.findElement(By.id("yourAccount")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("myXProfile")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='overview']")));
		Thread.sleep(10000);
	}
	
	public void navigatingToOverviewPage() {
		System.out.println(driver.getTitle());
	}
	
	public void navigatingToOrderPage() {
		driver.findElement(By.xpath("//a[@ng-click=\"trackClickAction(true, 'Profile > MD > OC > List View')\"]")).click();
		System.out.println(driver.getTitle());
	}
	
	public void browserTearDown() {
		driver.quit();
	}
	
/*	@FindBy(id="yourAccount")
	WebElement moveToLogin;
	
	@FindBy(xpath="//*[@id='subnavDD_myProfile']/li[1]/button")
	WebElement memberLogin;
	
	@FindBy(id="email")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//*[@id='universalSignInBtns']/button[1]/span")
	WebElement signIn;

	public sears_login_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}*/

}
