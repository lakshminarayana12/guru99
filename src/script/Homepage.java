package script;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Reporting.ExtentManager;
import genric.Basetest;
import genric.Lib;
import page.Demopage;


public class Homepage extends Basetest{
	ExtentReports extent = ExtentManager.getInstance();
	ExtentTest test = extent.startTest("Verifydemotitle");
	
	@Test(priority=1)
		public void verifyDemopageTitle() throws InterruptedException {
		
		
		
		test.log(LogStatus.INFO, "Getting excel value");
		
		String excelvalue=Lib.getCellvalue("/Users/lnel0001/Documents/Automationpratice/practice/data/input.xlsx", "Demopage", 1, 0);
		System.out.println(excelvalue);
		test.log(LogStatus.INFO, "excel value success");
		Demopage d= new Demopage(driver);
		
		d.verifyTitle(driver, excelvalue, 10);
		Thread.sleep(1000L);
		d.mobileclick();
		String mobilepageexcelvalue= Lib.getCellvalue("/Users/lnel0001/Documents/Automationpratice/practice/data/input.xlsx", "Mobile", 1, 0);
		System.out.println(mobilepageexcelvalue);
		d.verifyTitle(driver, mobilepageexcelvalue, 10);
		Select t = new Select(driver.findElement(By.xpath("//select[@title='Sort By']")));
		t.selectByValue("http://live.guru99.com/index.php/mobile.html?dir=asc&order=name");
		
		List<WebElement> list = driver.findElements(By.className("product-name"));
		int count=list.size();
		System.out.println(count);
		ArrayList<String> productnames= new ArrayList<String>();
		for(int i=0; i<count;i++) {
			String s1= list.get(i).getText();
			System.out.println(s1);
			productnames.add(s1);
			
			
		}
		boolean result = chkalphabetical_order(productnames);
System.out.println(result);


	}

	
	boolean chkalphabetical_order(ArrayList<String> productnames)	{
		
		 String previous = ""; // empty string

		    for (final String current: productnames) {
		        if (current.compareTo(previous) < 0)
		            return false;
		        previous = current;
		    }

		    return true;

		    }
		
		
@AfterMethod
public void lieee(ITestResult result)
{
	
try
{
	switch(result.getStatus())
	{
	case ITestResult.SUCCESS:
		String data=test.addScreenCapture("screen.png");

		test.log(LogStatus.PASS, data, "product names is matching");
		break;
	
	case ITestResult.FAILURE:
		
		test.log(LogStatus.FAIL, "product name is not matching");
		test.addScreenCapture("screen.png");
		
		break;
		
		
	
}
	extent.endTest(test);
	extent.flush();
}
catch(Exception e)
{
	e.getMessage();
}

}

		
		
	}
	


