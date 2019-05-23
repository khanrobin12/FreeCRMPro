package com.pro.qa.test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.pro.qa.base.TestBase;
import com.pro.qa.pages.HomePage;
import com.pro.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	
	LoginPageTest(){
		super();
	}

	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginpage=new LoginPage();
		}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String titel=loginpage.validateLoginPageTitle();
		Assert.assertEquals(titel, "CRMPRO- CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void crmLogoTest() {
		boolean logo=loginpage.validateFreeCrmImg();
		Assert.assertTrue(logo);
		}
	
	@Test(priority=3)
	public void loginTest() {
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
