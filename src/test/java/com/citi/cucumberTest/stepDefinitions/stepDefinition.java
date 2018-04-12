package com.citi.cucumberTest.stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class stepDefinition {
	WebDriver dr;

	@Given("^User is on (.*) welcome screen$")
	public void welcomescreen(String expectedTitle) throws InterruptedException {
		openBrowser();
		// Thread.sleep(5000);

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
		// Thread.sleep(5000);
		String title = dr
				.findElement(By
						.xpath("/html/body/app-root/cbol-core/citi-parent-layout/div/div/div/app-fixed-payment/citi-simple-layout/app-customize-loan/section/div/citi-text-header/h1"))
				.getText();
		Assert.assertTrue(expectedTitle.equals(title));

	}

	@Given("^User is navigated to (.*) screen$")
	public void verifyScreen(String expectedTitle) throws InterruptedException {
		// Thread.sleep(5000);
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
		dr.findElement(By.xpath("//*[@id=\"loanAmountInput\"]")).sendKeys("3");
	}

	@Then("^Entered amount is shown in the loan amount field$")
	public void verifyAmount() {
		String amount = dr
				.findElement(By
						.xpath("/html/body/app-root/cbol-core/citi-parent-layout/div/div/div/app-fixed-payment/citi-simple-layout/app-customize-loan/section/citi-form-container/form/div/div[1]/citi-row/div/citi-column[2]/div/citi-row[1]/div/p"))
				.getText();
		Assert.assertTrue(amount.equals("$3"));
		closeBrowser();
	}

	public void openBrowser() {
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\selenium\\chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "C:\\selenium\\geckodriver.exe");
		// System.setProperty("webdriver.phantomjs.driver",
		// "C:\\selenium\\phantomjs.exe");
		// dr = new FirefoxDriver();
		// dr = new ChromeDriver();
		// dr = new HtmlUnitDriver();
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setJavascriptEnabled(true);
		cap.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:/selenium/phantomjs.exe");
		dr = new PhantomJSDriver(cap);
		dr.get("https://dit57.online.citi.com/US/ag/loan-on-card/landing");

	}

	public void closeBrowser() {
		dr.quit();
	}

}