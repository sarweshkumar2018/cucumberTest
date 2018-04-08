package com.citi.cucumberTest.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {
	WebDriver dr;

	@Given("^User is on (.*) welcome screen$")
	public void welcomescreen(String expectedTitle) throws InterruptedException {
		openBrowser();
		Thread.sleep(5000);
		String title = dr
				.findElement(By
						.xpath("/html/body/app-root/cbol-core/citi-parent-layout/div/div/div/app-fixed-payment/citi-simple-layout/app-landing/citi-hero/section/div/div[2]/div/div/div/div/div/div/div/citi-text-header/h1"))
				.getText();
		Assert.assertTrue(expectedTitle.equals(title));
	}

	@When("^User clicks on Get Started on welcome screen$")
	public void login() throws InterruptedException {
		dr.findElement(By.cssSelector("#getStartedBtn")).click();
	}

	@Then("^User should navigate to (.*) screen$")
	public void verifySuccessful(String expectedTitle) throws InterruptedException {
		Thread.sleep(5000);
		String title = dr
				.findElement(By
						.xpath("/html/body/app-root/cbol-core/citi-parent-layout/div/div/div/app-fixed-payment/citi-simple-layout/app-customize-loan/section/div/citi-text-header/h1"))
				.getText();
		Assert.assertTrue(expectedTitle.equals(title));
		closeBrowser();
	}

	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
		dr = new FirefoxDriver();
		dr.get("https://dit57.online.citi.com/US/ag/loan-on-card/landing");
	}

	public void closeBrowser() {
		dr.quit();
	}

}