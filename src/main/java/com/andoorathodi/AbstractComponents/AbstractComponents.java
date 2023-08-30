package com.andoorathodi.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.andoorathodi.pageObjects.CartPage;
import com.andoorathodi.pageObjects.OrdersPage;

public class AbstractComponents {
	public WebDriver driver;

	public AbstractComponents(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;

	@FindBy(css = "[routerlink*='myorders']")
	WebElement orders;

	public void WaitElmentToAppear(By FindBy) {

		WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(5));
		wd.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}

	public CartPage goToCart() {

		cart.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}

	public OrdersPage goToOrders() {

		orders.click();
		OrdersPage orderPage = new OrdersPage(driver);
		return orderPage;
	}
}
