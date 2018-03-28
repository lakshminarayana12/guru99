package script;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genric.Basetest;
import page.Demopage;

public class Testcase5 extends Basetest{
	
	@Test
	public void createAccount() throws InterruptedException {
		driver.findElement(By.xpath("//div[1]/a/span[2][.='Account']")).click();
		driver.findElement(By.xpath("//a[@title='My Account']")).click();
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		driver.findElement(By.id("firstname")).sendKeys("lakshminarayana1");
		driver.findElement(By.id("lastname")).sendKeys("eluri1");
		driver.findElement(By.id("email_address")).sendKeys("eluri.narayana585@gmail.com");
		driver.findElement(By.id("password")).sendKeys("payakaraopeta2");
		driver.findElement(By.id("confirmation")).sendKeys("payakaraopeta2");
		driver.findElement(By.xpath("//span[text()='Register']")).click();
		Demopage d = new Demopage(driver);
		d.verifyRegSucc();
		driver.findElement(By.linkText("TV")).click();
		driver.findElement(By.xpath("(//a[text()='Add to Wishlist'])[1]")).click();
		
		//driver.findElement(By.xpath("(//a[text()='Add to Wishlist'])[2]")).click();
		//driver.findElement(By.xpath("(//form[@id='wishlist-view-form']/div[1]/div[1]/button/span[1]/span[1])[1]")).click();
		//(//span[.='Share Wishlist'])[2]
		driver.findElement(By.xpath("(//span[.='Share Wishlist'])[2]")).click();
		driver.findElement(By.id("email_address")).sendKeys("eluri.narayana580@gmail.com");
		driver.findElement(By.id("message")).sendKeys("Eluri automation");
		driver.findElement(By.xpath("//button[@title='Share Wishlist']")).click();
		String ExpectedResult="Your Wishlist has been shared.";
		String Actualresult=driver.findElement(By.xpath("//span[.='Your Wishlist has been shared.']")).getText();	
			System.out.println(Actualresult);
			
				
		try {
			Assert.assertEquals(Actualresult, ExpectedResult);
		}
		catch(Exception e) {
			e.getMessage();
		}
	}

}
