package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(
            features="src/test/resources/featureFile/saucelabDemo",
            glue={"stepDef"},
            tags = "@test",
           plugin = {"json:target/cucumber.json"})
    public class RunnerTest {}

