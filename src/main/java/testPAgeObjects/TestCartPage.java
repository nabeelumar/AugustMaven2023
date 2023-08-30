package testPAgeObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestCartPage extends ReusableClass{

	
	WebDriver driver;
	
	public TestCartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> items;
	
	@FindBy(css=".totalRow button")
	WebElement checkOut;
	
	 public boolean verifyProductAdded(String productAdded) {
		 
		 
		 boolean prsent=	items.stream().anyMatch(item->item.getText().equals(productAdded));
		 return prsent;
		 
	 }
	 
	 
	 public TestCheckOutPage goTocheckOut() {
		 
		 checkOut.click();
		 TestCheckOutPage checkOut =  new TestCheckOutPage(driver);
		 return checkOut;
		 
	 }
	 
	
	
}
