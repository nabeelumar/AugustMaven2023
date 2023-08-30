package com.andoorathodi.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.andoorathodi.AbstractComponents.AbstractComponents;

public class checkOutPage extends AbstractComponents{

	public checkOutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	private WebElement country;

	@FindBy(css = ".action__submit")
	private WebElement submit;

	@FindBy(css = ".ta-item:nth-child(3)")
	private WebElement selectCountry;

	public void selectCountry(String countryName) {

		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();

		// wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));

		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {

		submit.click();
		ConfirmationPage cop = new ConfirmationPage(driver);
		return cop;
	}
}

