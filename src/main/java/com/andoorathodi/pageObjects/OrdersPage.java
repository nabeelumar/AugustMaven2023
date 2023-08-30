package com.andoorathodi.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage {

	public WebDriver driver;

	public OrdersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> orderList;

	public Boolean getOrderList(String orName) {

		Boolean orderPresent = orderList.stream().anyMatch(order -> order.getText().equalsIgnoreCase(orName));
		return orderPresent;
	}

}
