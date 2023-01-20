package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(
		features={"src/test/java/features"},
		glue={"stepDefinition"},
//		tags = "@Session",
		plugin = {"pretty",
				"json:target/cucumber-reports/cucumber.json",
				"html:target/cucumber-reports/cucumberreport.html"},
		dryRun = false,
		monochrome = true,
		publish = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

//	TODO: Bu kısmı paralel koşum için eklemiştim :)
//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}

}
