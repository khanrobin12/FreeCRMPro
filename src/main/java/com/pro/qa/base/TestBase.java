package com.pro.qa.base;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.pro.qa.util.TestUtil;

public class TestBase {
	 
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		
		 prop = new Properties();
			try {
				FileInputStream ip = new FileInputStream("C:\\Users\\AliNoor\\eclipse-workspace\\InterviewPrep\\src\\main\\java\\com\\pro\\qa\\config\\config.properties");
				prop.load(ip);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
			
	}
	
	public static void initialization(){
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\AliNoor\\eclipse-workspace\\InterviewPrep\\driver\\chromedriver.exe");
			driver=new ChromeDriver();
			}
		else if(browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", "");
				
			}
		else if(browserName.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "");
				driver=new InternetExplorerDriver();
			}
		else {
				System.out.println("please open safari driver");
			}
	
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LODE_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLECIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
	}

}
