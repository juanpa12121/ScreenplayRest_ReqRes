package co.com.tcs.certification.reqres.stepdefinitions;

import co.com.tcs.certification.reqres.models.DataUserCreate;
import co.com.tcs.certification.reqres.questions.ValidateCreateUser;
import co.com.tcs.certification.reqres.tasks.CreateUserReqRes;
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

import java.util.List;

import static co.com.tcs.certification.reqres.utils.Constants.ACTOR_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CreateUserStepDefinitions {
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR_NAME);
    }


    @When("^The user creates an user$")
    public void theUserCreatesAnUser(List<DataUserCreate> dataUserList) {
        OnStage.theActorInTheSpotlight().attemptsTo(CreateUserReqRes.createUser(dataUserList.get(0)));
    }


    @Then("^The user should see that the user has been created successfully$")
    public void theUserShouldSeeThatTheUserHasBeenCreatedSuccessfully(List<DataUserCreate> dataUserCreateList) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCreateUser.validateUserCreation(dataUserCreateList.get(0)), Matchers.equalTo(true)));
    }
}
