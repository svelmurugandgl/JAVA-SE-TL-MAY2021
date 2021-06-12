package runnerleads;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/java/featuresleads", glue = "stepsleads", monochrome = true, publish = true)
public class RunTestLeads extends AbstractTestNGCucumberTests {

}
