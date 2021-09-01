package com.rvy.cucumber.bdd;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * To run cucumber test
 */
@RunWith(Cucumber.class)
//@CucumberOptions(features = "classpath:features", plugin = {"pretty",
//															"html:target/cucumber-htmlreport",
//                                                            "json:target/cucumber-report.json"})
//@CucumberOptions(
//		features = "src/test/resources/features",
//		glue= {"stepDefinitions"},
//		plugin = { "pretty", "html:target/cucumber-reports" },
//		monochrome = true
//	)
@CucumberOptions(
		features = "src/test/resources/features",
		glue= "com.rvy.cucumber.bdd.stepdefs",
		plugin = { "pretty", "json:target/Cucumber.json" },
		monochrome = true
	)
public class CucumberTest {

}
