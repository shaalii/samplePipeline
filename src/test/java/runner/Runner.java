package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
glue="stepdefinations",
features="src/test/java/feature",
plugin={"html:target/cucumber-html-report", "json:target/cucumber.json",

"pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json",
"junit:target/cucumber-results.xml"},

dryRun = false,
monochrome = true
)
public class Runner {

}

