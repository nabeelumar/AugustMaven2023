package com.andoorathodi.MavenAugust2023.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.andoorathodi.pageObjects.LandingPage;

import io.github.bonigarcia.wdm.WebDriverManager;
import testPAgeObjects.TestCartPage;
import testPAgeObjects.TestCheckOutPage;
import testPAgeObjects.TestConfirmationPage;
import testPAgeObjects.TestLandingPage;
import testPAgeObjects.TestProductCatalogue;

public class TestPageObjectTest {

	@Test
	public void standAloneTest() {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();

		TestLandingPage landingPage = new TestLandingPage(driver);
		landingPage.goTo();
		TestProductCatalogue prodCat = landingPage.loginApplication("nabeelans@gmail.com", "Abcd@123");

		List<WebElement> productList = prodCat.getProductList();

		prodCat.addProduct("IPHONE 13 PRO");

		TestCartPage cartPage = prodCat.clickCart();

		Boolean present = cartPage.verifyProductAdded("IPHONE 13 PRO");
		Assert.assertTrue(present);

		TestCheckOutPage checkOut = cartPage.goTocheckOut();
		checkOut.selectCountry();
		TestConfirmationPage confPage = checkOut.placeOrder();
		String msg = confPage.validateMsg();

		Assert.assertEquals(msg, "THANKYOU FOR THE ORDER.");

		driver.close();

	}

}
