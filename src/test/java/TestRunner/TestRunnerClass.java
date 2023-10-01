package TestRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		             //this is the feature file path
			//features = ".//FeaturesFile/LoginFeature.feature",
		features = ".//FeaturesFile/",
			//If I want to run only 2 feature files in the feature folder
		//features = {".//FearturesFile/LoginFeature.feature",".//FeatureFile/Customers.feature"},
			//this is the StepDefinition path
		glue = "StepDefinition",
		
		//true option will be checking the compatibility of the FeatureFile and StepDefinition
		dryRun = false,
		
		//output readable
		monochrome = true,
		tags = "@regression",
		
		//to do
		plugin = {"pretty","html:target/Cucumber-Reports/reports_html.html"}
		
		)

public class TestRunnerClass {
	
	
}



