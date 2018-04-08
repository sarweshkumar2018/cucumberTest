package com.citi.cucumberTest.runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin={"pretty","html:target/site/cucumber-pretty", "json:target/cucumber.json"},
				 features = "classpath:FPC",
				 glue = "com.citi.cucumberTest.stepDefinitions")
public class CucumberJunitRunner {

}

