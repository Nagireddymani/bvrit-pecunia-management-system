package com.capg.pbms.testrunner;

import org.testng.annotations.AfterClass;

import com.vimalselvam.cucumber.listener.Reporter;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/CreditingFeature.feature",
		plugin = {
				"pretty",
				"html:Reports/cucumber-html-report", 
				"json:Reports/cucumber-html-report/jsonreport.json",
				"rerun:target/cucumber-reports/rerun.txt",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: ",
				"testng:target/testng-cucumber-reports/cuketestng.xml"
		},
		glue="com.capg.pbms.stepdefination"
		)
public class TestRunner extends AbstractTestNGCucumberTests {

	@AfterClass
	public static void Extendsreport() {
//		  Reporter.loadXMLConfig("/src/test/resources/Extent-config.xml");
//		  Reporter.setSystemInfo("user", System.getProperty("user.name"));
//		  Reporter.setSystemInfo("os", "Windows");
//		  Reporter.setTestRunnerOutput("Sample test runner output message");
	}
}
