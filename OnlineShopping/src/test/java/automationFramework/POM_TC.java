package automationFramework;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import pageObject.Home_Page;
import pageObject.Login_Page;
import pageObject.MyAccount_Page;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class POM_TC {
	private static WebDriver driver = null;

	@BeforeTest
	public void beforeTest() {
		ChromeDriverManager.getInstance().setup();
		driver = new ChromeDriver();
		String baseUrl = "http://store.demoqa.com/";
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);
		driver.manage().window().maximize();


	}
	@Test
	public void f() {
		Home_Page.link_MyAccount(driver).click();
		Login_Page.WaitForElementPresent(driver);
		Login_Page.textbox_UserName(driver).sendKeys("qatek");
		Login_Page.textbox_Password(driver).sendKeys("Automation1!");
		Login_Page.button_Login(driver).click();
		MyAccount_Page.WaitForElementPresent(driver);
		System.out.println("Login Successfully, now it is the time to log off buddy!!");
		MyAccount_Page.link_Logout(driver).click();
	}


	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
