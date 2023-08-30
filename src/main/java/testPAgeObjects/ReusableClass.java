package testPAgeObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableClass {

	WebDriver driver;

	public ReusableClass(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[routerlink*='cart']")
	WebElement cart;

	public void waitForElement(By FindBy) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}

	public TestCartPage clickCart() {
		cart.click();
		TestCartPage cartPage = new TestCartPage(driver);
		return cartPage;

	}
}
