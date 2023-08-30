package com.andoorathodi.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="#userEmail")
	private WebElement email;
	
	
	@FindBy(css="#userPassword")
	private WebElement passowrd;
	
	
	@FindBy(css = "#login")
	private WebElement submit;
	
	
	@FindBy(css = "[class*='flyInOut']")
	private WebElement errorMsg;
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public ProdcutCatalogue LoginApplication(String eml, String passwrd) {
		
		email.sendKeys(eml);
		passowrd.sendKeys(passwrd);
		submit.click();
		ProdcutCatalogue pc = new ProdcutCatalogue(driver);
		return pc;
	}
	
	public String getErrorMessage() throws InterruptedException {
	
	String ErrorMsg =	errorMsg.getText();
		
	return ErrorMsg;	
	}
	
}
