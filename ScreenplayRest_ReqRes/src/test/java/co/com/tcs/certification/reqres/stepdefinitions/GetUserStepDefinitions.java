package co.com.tcs.certification.reqres.stepdefinitions;

import co.com.tcs.certification.reqres.questions.ValidateStatus;
import co.com.tcs.certification.reqres.tasks.GetUserReqRes;
import co.com.tcs.certification.reqres.utils.Constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;
import static co.com.tcs.certification.reqres.utils.Constants.ACTOR_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class GetUserStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR_NAME);
    }

    @Given("^The user is in API$")
    public void theUserIsInAPI() {
        theActorInTheSpotlight().whoCan(CallAnApi.at(Constants.BASE_ENDPOINT_REQRES));
    }


    @When("^The user enter the id (\\d+)$")
    public void theUserEnterTheId(int id) {
        theActorInTheSpotlight().attemptsTo(GetUserReqRes.getUserById(id));
    }

    @Then("^The user validates the status code (\\d+)$")
    public void theUserValidatesTheStatusCode(int statusCode) {
        theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(ValidateStatus.code(),
                        Matchers.equalTo(statusCode)));
    }
}