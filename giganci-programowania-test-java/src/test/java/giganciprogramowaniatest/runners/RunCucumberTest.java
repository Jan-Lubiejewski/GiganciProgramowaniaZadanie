package giganciprogramowaniatest.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// Sets up cucumber and cucumber options
@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"giganciprogramowaniatest/steps", "giganciprogramowaniatest/utilities"},
        plugin = {"pretty", "html:target/cucumber-report.html"}
)
public class RunCucumberTest {
}
