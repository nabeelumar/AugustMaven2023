package testPAgeObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestProductCatalogue  extends ReusableClass{
	
	WebDriver driver;
	
	public TestProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	

	
	By productsBy = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastContainer =By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList() {
		
		waitForElement(productsBy);
		return products;
	}
	
	
	public WebElement getProduct(String productName) {
		
		WebElement  prod=	products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addProduct(String productName) {
		
		WebElement product = getProduct(productName);
		product.findElement(addToCart).click();
		waitForElement(toastContainer);
		
	}
	
	
	
	
	
	

}
