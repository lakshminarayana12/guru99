package script;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reporting.ExtentManager;
import genric.Basetest;
import page.Demopage;

public class Testcase3 extends Basetest {
	@Test (priority=3)
	public void verifyUsercannotAddmoreproductthantheproductavailable() throws InterruptedException {
		
		ExtentReports extent = ExtentManager.getInstance();
		ExtentTest test = extent.startTest("Addmoreproducts price");
		Demopage d = new Demopage(driver);
		
		d.mobileclick();
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		
		driver.findElement(By.xpath("//*[@id='shopping-cart-table']/tbody/tr/td[4]/ul/li/a")).click();
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("1000");
		driver.findElement(By.xpath("//span[.='Update Cart']")).click();
		d.isErrormessagedisplayed();
		driver.findElement(By.xpath("//span/span[1][.='Empty Cart']")).click();
		d.verifyEmptyShoppingCart();
		extent.endTest(test);
		extent.flush();
	}

}
