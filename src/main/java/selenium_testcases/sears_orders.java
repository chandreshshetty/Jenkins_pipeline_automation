package selenium_testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium_page.sears_login_page;

public class sears_orders {
	
	WebDriver driver;

	sears_login_page searsLogin = new sears_login_page();

	@BeforeMethod
	public void browserInvoke() throws IOException, Exception {
		searsLogin.invokeBrowser();
		System.out.println("navigating to sears website");
		searsLogin.searsNavigation();
		System.out.println("Login to sears");
		searsLogin.sears_login();
		System.out.println("Navigating to manage my account");
		searsLogin.manageMyAccount();
	}
	
	@Test
	public void sears_orders_overview_page() {
		searsLogin.navigatingToOverviewPage();
	}
	
	@Test
	public void sears_orders_page() {
		searsLogin.navigatingToOrderPage();
	}
	
	@AfterMethod
	public void tearDown() {
		searsLogin.browserTearDown();
		System.out.println("Driver instances closed successfully");
	}
}
