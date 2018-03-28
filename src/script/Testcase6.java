package script;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import genric.Basetest;

public class Testcase6 extends Basetest{
	
	@Test
	public void verifyuserisabletopurchaseproduct() throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/a/span[2][.='Account']")).click();
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.id("email")).sendKeys("eluri.narayana585@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("payakaraopeta2");
		driver.findElement(By.xpath("//div/div[2]/button/span[1]/span[1]")).click();
		System.out.println("login successful");
		
		 for (String handle : driver.getWindowHandles()) {
		    	driver.switchTo().window(handle);
		    	}
		 
		driver.findElement(By.linkText("My Wishlist")).click();
		for (String handle : driver.getWindowHandles()) {
	    	driver.switchTo().window(handle);
	    	}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@title='Add to Cart']")).click();
		driver.findElement(By.xpath("//ul[@class='checkout-types top']/li/button/span[1]/span[1][.='Proceed to Checkout']")).click();
		driver.findElement(By.id("billing:street1")).clear();
		driver.findElement(By.id("billing:street1")).sendKeys("Synchronoss technologies");
		driver.findElement(By.id("billing:city")).clear();
		driver.findElement(By.id("billing:city")).sendKeys("bangalore");
		
		driver.findElement(By.id("billing:postcode")).clear();
		driver.findElement(By.id("billing:postcode")).sendKeys("560075");
		 new Select(driver.findElement(By.id("billing:country_id"))).selectByVisibleText("India");
		driver.findElement(By.id("billing:telephone")).clear();
		driver.findElement(By.id("billing:telephone")).sendKeys("78270000000");
		driver.findElement(By.id("billing:use_for_shipping_yes")).click();
		//driver.findElement(By.xpath("//div[@id='billing-buttons-container']/button[@title='Continue']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button/span[1]/span[1][.='Continue'])[1]")).click();
		Thread.sleep(3000);
		//clicking on credit radio button
		for(String handle:driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[@class='button'])[2]")).click();
		//driver.findElement(By.id("//*[@id='shipping-method-buttons-container']/button")).click();
		driver.findElement(By.id("p_method_ccsave")).click();
		driver.findElement(By.id("ccsave_cc_owner")).clear();
		driver.findElement(By.id("ccsave_cc_owner")).sendKeys("Eluri");
		new Select(driver.findElement(By.id("ccsave_cc_type"))).selectByIndex(2);
		driver.findElement(By.id("ccsave_cc_number")).sendKeys("1111222233");
		new Select(driver.findElement(By.id("ccsave_expiration"))).selectByIndex(5);
		new Select(driver.findElement(By.id("ccsave_expiration_yr"))).selectByValue("2019");
		driver.findElement(By.id("ccsave_cc_cid")).sendKeys("560");
		
		driver.findElement(By.id("//button/span[1]/span[1][.='Continue'])[4]")).click();
		
		
	
		
	}

}
