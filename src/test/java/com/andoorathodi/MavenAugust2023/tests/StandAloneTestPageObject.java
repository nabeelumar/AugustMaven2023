package com.andoorathodi.MavenAugust2023.tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.andoorathodi.MavenAugust2023.TestComponents.BaseTest;
import com.andoorathodi.pageObjects.CartPage;
import com.andoorathodi.pageObjects.ConfirmationPage;
import com.andoorathodi.pageObjects.LandingPage;
import com.andoorathodi.pageObjects.OrdersPage;
import com.andoorathodi.pageObjects.ProdcutCatalogue;
import com.andoorathodi.pageObjects.checkOutPage;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestPageObject extends BaseTest {

	@Test(dataProvider = "getData", groups = { "dataTest" })
	public void standAloneTest(HashMap<String, String> input) throws IOException {

		ProdcutCatalogue pc = lp.LoginApplication(input.get("username"), input.get("password"));

		List<WebElement> products = pc.getProductList();
		pc.addProductToCart("ADIDAS ORIGINAL");
		CartPage cp = pc.goToCart();

		Boolean prsent = cp.verifyProductDisplay("ADIDAS ORIGINAL");

		Assert.assertTrue(prsent);
		System.out.println("ASSERT ISSSSSSS " + prsent);
		checkOutPage chp = cp.goToCheckOut();
		chp.selectCountry("india");
		ConfirmationPage cop = chp.submitOrder();

		String text = cop.verifyConfirmationMessage();

		Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");

	}

	@DataProvider
	public Object[][] getData() throws IOException {

		List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")
				+ "/src/test/java/com/andoorathodi/MavenAugust2023/data/PurchaseOrder.json");

		return new Object[][] { { data.get(0) }, { data.get(1) } };

		// return new Object[][] {{"nabeelans@gmail.com", "Abcd@123"},
		// {"sathish123@gmail.com", "Abcd@123"}};
	}

	@Test(dependsOnMethods = { "standAloneTest()" })
	public void verifyOrderPresent() {
		ProdcutCatalogue pc = lp.LoginApplication("nabeelans@gmail.com", "Abcd@123");

		OrdersPage orderPAge = pc.goToOrders();
		Boolean orderPresent = orderPAge.getOrderList("ADIDAS ORIGINAL");
		Assert.assertTrue(orderPresent);
	}

}
