package com.andoorathodi.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.andoorathodi.AbstractComponents.AbstractComponents;

public class ProdcutCatalogue extends AbstractComponents {

	WebDriver driver;

	public ProdcutCatalogue(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	private List<WebElement> products;

	private By productsBy = By.cssSelector(".mb-3");

	private By addToCart = By.cssSelector(".card-body button:last-of-type");
	private By toastContainer = By.cssSelector("#toast-container");

	public List<WebElement> getProductList() {

		WaitElmentToAppear(productsBy);
		return products;

	}

	public WebElement getProductByName(String productName) {

		WebElement product = getProductList().stream()
				.filter(prod -> prod.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst()
				.orElse(null);

		return product;

	}

	public void addProductToCart(String productName) {

		WebElement product = getProductByName(productName);
		product.findElement(addToCart).click();
		WaitElmentToAppear(toastContainer);
	}

}
