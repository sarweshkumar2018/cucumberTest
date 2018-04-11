package com.citi.cucumberTest.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {
	//WebDriver dr;
	HtmlUnitDriver dr;
	
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
		// closeBrowser();
	}

	@Given("^User is navigated to (.*) screen$")
	public void verifyScreen(String expectedTitle) throws InterruptedException {
		//Thread.sleep(5000);
		System.out.println(dr
				.findElement(By
						.xpath("/html/body/app-root/cbol-core/citi-parent-layout/div/div/div/app-fixed-payment/citi-simple-layout/app-customize-loan/section/div/citi-text-header/h1"))
				.getText());
		String title = dr
				.findElement(By 
						.xpath("/html/body/app-root/cbol-core/citi-parent-layout/div/div/div/app-fixed-payment/citi-simple-layout/app-customize-loan/section/div/citi-text-header/h1"))
				.getText();
		Assert.assertTrue(expectedTitle.equals(title));
	}

	@When("^User enters loan amount$")
	public void enterAmount() {
		dr.findElement(By.xpath("//*[@id=\"loanAmountInput\"]")).clear();
		dr.findElement(By.xpath("//*[@id=\"loanAmountInput\"]")).sendKeys("2000");
	}

	@Then("^Entered amount is shown in the loan amount field$")
	public void verifyAmount() {
        String amount = dr
				.findElement(By
						.xpath("/html/body/app-root/cbol-core/citi-parent-layout/div/div/div/app-fixed-payment/citi-simple-layout/app-customize-loan/section/citi-form-container/form/div/div[1]/citi-row/div/citi-column[2]/div/citi-row[1]/div/p"))
				.getText();
		Assert.assertTrue(amount.equals("$2,000"));
		//closeBrowser();
	}

	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\selenium\\geckodriver.exe");
		//dr = new FirefoxDriver();
		//dr = new ChromeDriver();
		dr = new HtmlUnitDriver(BrowserVersion.CHROME);
		dr.get("https://dit57.online.citi.com/US/ag/loan-on-card/landing");
		
	}

	public void closeBrowser() {
		dr.quit();
	}

}