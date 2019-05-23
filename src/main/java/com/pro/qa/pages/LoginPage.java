package com.pro.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.pro.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	

	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//button[contains(text,'sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'imp-responsive')]")
	WebElement crmLogo;

	public LoginPage(){
		
		PageFactory.initElements(driver, this);
		
		}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateFreeCrmImg() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pw) {
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbtn.click();
		return new HomePage();
		
	
	
		
		
	}	


}
