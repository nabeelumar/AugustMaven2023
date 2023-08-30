package testPAgeObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestLandingPage {

	WebDriver driver;

	
public TestLandingPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(css="#userEmail")
WebElement Email;


@FindBy(css="#userPassword")
WebElement Password;


@FindBy(css="#login")
WebElement Submit;


public void goTo() {
	
	driver.get("https://rahulshettyacademy.com/client");
}

public TestProductCatalogue loginApplication(String username, String password) {
	
	Email.sendKeys(username);
	Password.sendKeys(password);
	Submit.click();
	TestProductCatalogue prodCat = new TestProductCatalogue(driver);
	return prodCat;
	
	
}
}
