package co.com.tcs.certification.reqres.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/get_user.feature",
        glue = "co.com.tcs.certification.reqres.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@Scenario2"
)
public class GetUser {
}
