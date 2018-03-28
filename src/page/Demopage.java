package page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Demopage {
	
	@FindBy(xpath="//a[.='Mobile']")
	private WebElement mobilelink;
	
	@FindBy(xpath="//span[.='The maximum quantity allowed for purchase is 500.']")
	private WebElement errMsg;
	
	@FindBy(xpath="//p[1][.='You have no items in your shopping cart.']")
	private WebElement emptyShoppingcart;
	
	@FindBy(xpath="//*[@id='top']/body/div[1]/div[1]/h1")
	private WebElement compareproducts;
	
	@FindBy(xpath="//span[text()='Thank you for registering with Main Website Store.']")
	private WebElement register;
	
	public void verifyRegSucc() {
		try {
		Assert.assertTrue(register.isDisplayed());
		}
		
		catch(Exception e) {
			e.getMessage();
		}
	}
	
	public Demopage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
	
	public void isCompareMsgDisplayed() {
		Assert.assertTrue(compareproducts.isDisplayed());
	}
	
	public void verifyEmptyShoppingCart() {
		Assert.assertTrue(emptyShoppingcart.isDisplayed());
	}
	
	/*public void verifyTitle(WebDriver driver,String eTitle){
		String aTitle=driver.getTitle();
		System.out.println(aTitle);
		Assert.assertEquals(aTitle, eTitle);
	}*/
	
	public void isErrormessagedisplayed() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertTrue(errMsg.isDisplayed());
	}
	
	public void verifyTitle(WebDriver driver, String expectedtitle, long timeout) {
		String actualtitle= driver.getTitle();
		System.out.println(actualtitle);
		SoftAssert s = new SoftAssert();
		//s.assertTrue(actualtitle.equals(expectedtitle));
		s.assertEquals(actualtitle, expectedtitle, "Title is matching");
		//s.assertAll();
		
		}
	
	public void mobileclick() {
		mobilelink.click();
		
	}

	

}
