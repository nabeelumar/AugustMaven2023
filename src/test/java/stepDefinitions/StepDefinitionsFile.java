package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.andoorathodi.MavenAugust2023.TestComponents.BaseTest;
import com.andoorathodi.pageObjects.CartPage;
import com.andoorathodi.pageObjects.ConfirmationPage;
import com.andoorathodi.pageObjects.LandingPage;
import com.andoorathodi.pageObjects.ProdcutCatalogue;
import com.andoorathodi.pageObjects.checkOutPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepDefinitionsFile extends BaseTest {
	public LandingPage lp;
	public ProdcutCatalogue pc;
	public ConfirmationPage cop;

 

	 @Given("I landed on ecommerse website") 
	 public void i_landed_on_ecommerse_website() throws IOException {
	 
	 lp = launchURL();
	 
	  }
	 
	  @Given("^Logged in with username (.+) and password (.+)$") 
	  public void i_logged(String username, String paswword) throws IOException {
		  pc =
	 lp.LoginApplication(username, paswword);
	 
	  }
	  @When("I add product ADIDAS ORIGINAL to cart") 
	  public void add_to_cart() {
	  List<WebElement> products = pc.getProductList();
	  pc.addProductToCart("ADIDAS ORIGINAL"); }
	  
	  @And("checkout ADIDAS ORIGINAL and submit the order") 
	  public void checout() {
	 CartPage cp = pc.goToCart();
	 
	  Boolean prsent = cp.verifyProductDisplay("ADIDAS ORIGINAL");
	 
	  Assert.assertTrue(prsent); 
	  System.out.println("ASSERT ISSSSSSS " + prsent);
	 checkOutPage chp = cp.goToCheckOut(); 
	 chp.selectCountry("india");
	 cop = chp.submitOrder(); }
	 
  @Then("{string} message is displayed on Confirmation page") public void
	  message_displayed_converimationPage(String msg) 
	  { 
	  
	  String text = cop.verifyConfirmationMessage();
	  System.out.println("LAST MESSAGE");
	  Assert.assertEquals(text, msg);
	  driver.close();
	  } 
	
  
  @Then("{string} message is displayed")
  public void display_error_msg_on_worng_username(String erromsg) throws InterruptedException {
	  Assert.assertEquals(lp.getErrorMessage(),erromsg);
	  driver.close();
	  
  }
//Then "THANKYOU FOR THE ORDER." message is displayed on Confirmation page
}
