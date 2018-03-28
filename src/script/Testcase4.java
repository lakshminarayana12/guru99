package script;


import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import genric.Basetest;
import page.Demopage;

public class Testcase4 extends Basetest{
	@Test(priority=4)
	public void compareTwoproducts() {
		Demopage d = new Demopage(driver);
		d.mobileclick();
		
		String mainMobile1= driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
		 String mainMobile2=driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
		
		driver.findElement(By.xpath("(//a[@class='link-compare'])[1]")).click();
		
		
		driver.findElement(By.xpath("(//a[@class='link-compare'])[2]")).click();
	driver.findElement(By.xpath("//span/span[1][.='Compare']")).click();
	Set <String> whs = driver.getWindowHandles();
	for(String wh:whs) {
		driver.switchTo().window(wh);
	     }
	String childbrowsertitle=driver.getTitle();
	System.out.println("Childbrowser title is "+childbrowsertitle);
	
	d.isCompareMsgDisplayed();
	String popupmobile1=driver.findElement(By.xpath("//h2/a[@title='Sony Xperia']")).getText();
	String popupmobile2=driver.findElement(By.xpath("//h2/a[@title='IPhone']")).getText();
	try {
	Assert.assertEquals(mainMobile1, popupmobile1);	
	}
	catch(Exception e) {
		e.getMessage();
	}
	
	try {
		Assert.assertEquals(mainMobile2, popupmobile2);
		
	}
	catch(Exception e) {
		e.getMessage();
	}
}
}