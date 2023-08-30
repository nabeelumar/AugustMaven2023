package com.andoorathodi.MavenAugust2023.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.andoorathodi.MavenAugust2023.TestComponents.BaseTest;
import com.andoorathodi.pageObjects.ProdcutCatalogue;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NegeativeTEst extends BaseTest {

	@Test(groups = { "ErrorHandling" }, retryAnalyzer = com.andoorathodi.MavenAugust2023.TestComponents.Retry.class)
	public void negativeScenario() throws InterruptedException {

		lp.LoginApplication("shibil@gmail.com", "Abcd@123");

		Assert.assertEquals(lp.getErrorMessage(), "Incorrect email or password.");

	}

}