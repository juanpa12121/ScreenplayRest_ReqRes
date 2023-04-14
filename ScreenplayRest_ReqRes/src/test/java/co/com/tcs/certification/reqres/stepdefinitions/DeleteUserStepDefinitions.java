package co.com.tcs.certification.reqres.stepdefinitions;

import co.com.tcs.certification.reqres.models.DataUserGet;
import co.com.tcs.certification.reqres.tasks.DeleteUserReqRes;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static co.com.tcs.certification.reqres.utils.Constants.ACTOR_NAME;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteUserStepDefinitions {
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(ACTOR_NAME);
    }
    @When("^The user deletes an user with id (\\d+)$")
    public void theUserDeletesAnUserWithId(int id, List<DataUserGet> list) {
        theActorInTheSpotlight().attemptsTo(DeleteUserReqRes.deleteUser(id));
    }
}
