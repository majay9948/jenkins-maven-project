package p1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	WebDriver drivers;
	
	@BeforeTest
	public void setup() {
		
		String browserName ="chrome";
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			drivers = new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			drivers = new FirefoxDriver();
		}
		else if(browserName.equals("safari")) {
			drivers = new SafariDriver();
		}
		else {
			System.out.println("browser not found" +browserName);
		}
		
		drivers.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		drivers.manage().deleteAllCookies();
		drivers.manage().window().maximize();
	}
	
	@Test
	public void testing() {
		System.out.println("base-testing");
	}
	
	@AfterTest
	public void tearDown() {
		drivers.quit();
	}

}
