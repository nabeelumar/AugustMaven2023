package testPAgeObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TestCheckOutPage extends ReusableClass{
	
	WebDriver driver;
	
	public TestCheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	
	@FindBy(css=".ta-item:nth-child(3)")
	WebElement selectedCountry;
	
	
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	By results =By.cssSelector(".ta-results");
	
	
	public void selectCountry() {
		
		Actions a = new Actions(driver);
		a.sendKeys(selectCountry, "India").build().perform();
		waitForElement(results);
		selectedCountry.click();
		placeOrder.click();
		
	}
	
	public TestConfirmationPage placeOrder() {
		
		placeOrder.click();
		TestConfirmationPage confPage = new TestConfirmationPage(driver);
		return confPage;
		
	}
	 
	
	
	

	
	
}
