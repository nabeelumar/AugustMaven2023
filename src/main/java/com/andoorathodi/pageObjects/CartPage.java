package com.andoorathodi.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.andoorathodi.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

		// TODO Auto-generated constructor stub
	}

	@FindBy(css = ".cartSection h3")
	private List<WebElement> items;

	@FindBy(css = ".totalRow button")
	private WebElement checkOut;

	public Boolean verifyProductDisplay(String productName) {

		boolean prsent = items.stream().anyMatch(item -> item.getText().equals(productName));
		return prsent;
	}

	public checkOutPage goToCheckOut() {

		checkOut.click();
		checkOutPage chp = new checkOutPage(driver);
		return chp;
	}

}
