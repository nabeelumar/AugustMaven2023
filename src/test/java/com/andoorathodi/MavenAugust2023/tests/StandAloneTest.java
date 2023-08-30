package com.andoorathodi.MavenAugust2023.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
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

public class StandAloneTest {

	
	@Test
	public void standAloneTest() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/client");
		
		
		driver.findElement(By.cssSelector("#userEmail")).sendKeys("nabeelans@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Abcd@123");
		driver.findElement(By.cssSelector("#login")).click();

		WebDriverWait wd = new WebDriverWait(driver, Duration.ofSeconds(5));
		wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3\"")));
		List<WebElement>  products =driver.findElements(By.cssSelector(".mb-3"));
		WebElement  product =products.stream().filter(prod->prod.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		
		
		
		product.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
	
		
		wd.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("#toast-container"))));
		//wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
		
		List<WebElement> items =driver.findElements(By.cssSelector(".cartSection h3"));
	boolean prsent=	items.stream().anyMatch(item->item.getText().equals("ADIDAS ORIGINAL"));
	
	Assert.assertTrue(prsent);
	driver.findElement(By.cssSelector(".totalRow button")).click();
	
	Actions a = new Actions(driver);
	a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build().perform();
	
	wd.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
	
	driver.findElement(By.cssSelector(".ta-item:nth-child(3)")).click();
	driver.findElement(By.cssSelector(".action__submit")).click();
	
	String text  =driver.findElement(By.cssSelector(".hero-primary")).getText();
	System.out.println(System.getProperty("user.dir")+"/reports/index.html"    );
	
	Assert.assertEquals(text, "THANKYOU FOR THE ORDER.");
	
	
	}
	


}
