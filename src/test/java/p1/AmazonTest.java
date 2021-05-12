package p1;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest {

	
	@Test(priority = 1)
	public void amazonTitleTest() {
		drivers.get("https://www.amazon.in/");

		Assert.assertTrue(drivers.getTitle().contains("Online Shopping"));
	}
	
	@Test(priority = 2)
	public void amazonLogoTest() {
		Assert.assertTrue(drivers.findElement(By.id("nav-logo")).isDisplayed());
	}
	
	@Test
	public void searchBarExistTest() {
		Assert.assertTrue(drivers.findElement(By.id("twotabsearchtextbox")).isDisplayed());
	}
}