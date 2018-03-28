package script;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Reporting.ExtentManager;
import genric.Basetest;
import page.Demopage;

public class Mobile extends Basetest {
	
	@Test(priority=2)
	public void verifyPriceofSonyxperia() {

		ExtentReports extent = ExtentManager.getInstance();
		ExtentTest test = extent.startTest("Verifypriceofexcel price");
		Demopage d = new Demopage(driver);
		d.mobileclick();
		String sonlxperia= driver.findElement(By.className("price")).getText();
		System.out.println(sonlxperia);
		driver.findElement(By.id("product-collection-image-1")).click();
		String sonlxperia1= driver.findElement(By.className("price")).getText();
		System.out.println(sonlxperia);
		if(sonlxperia.equals(sonlxperia1)) {
			System.out.println("Price value is equql in both pages");
		}
		else {
			System.out.println("price values are not equal");
		}
		extent.endTest(test);
		extent.flush();
	}

	}
