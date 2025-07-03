package starter;

import net.serenitybdd.cucumber.CucumberWithSerenity;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "classpath:features/reto",
        glue     = "starter.stepdefinitions"
)
public class RetoTestSuite { }


