package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src/test/java/cucumber",
		glue={"stepDefinitions"},
		monochrome=true,tags="@NegativeScenario", plugin= {"html:target/cucumber.html"}
		
		)
public class TestRunnerTestNG extends AbstractTestNGCucumberTests{

}
