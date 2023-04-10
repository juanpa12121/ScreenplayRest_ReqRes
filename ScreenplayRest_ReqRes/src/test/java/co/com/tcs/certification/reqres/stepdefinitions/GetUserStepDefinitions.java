package co.com.tcs.certification.reqres.stepdefinitions;

import co.com.tcs.certification.reqres.exceptions.AssertionsServices;

import co.com.tcs.certification.reqres.models.DataUserGet;
import co.com.tcs.certification.reqres.questions.*;
import co.com.tcs.certification.reqres.tasks.GetUserReqRes;
import co.com.tcs.certification.reqres.utils.Constants;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;

import static co.com.tcs.certification.reqres.exceptions.AssertionsServices.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.Matchers;

import java.util.List;

import static co.com.tcs.certification.reqres.utils.Constants.ACTOR_NAME;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
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

    //@Scenario1
    @When("^The user enters the id (\\d+)$")
    public void theUserEntersTheId(int id) {
        theActorInTheSpotlight().attemptsTo(GetUserReqRes.getUserById(id));
    }

    @Then("^The user validates the status code (\\d+)$")
    public void theUserValidatesTheStatusCode(int statusCode) {
        theActorInTheSpotlight()
                .should(seeThat(ValidateStatus.code(),
                                Matchers.equalTo(statusCode))
                        .orComplainWith(AssertionsServices.class, THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED)
                );
    }

    //@Scenario2
    @Then("^The user validates the quantity of keys (\\d+)$")
    public void theUserValidatesTheQuantityOfKeys(int quantityKeys) {
        theActorInTheSpotlight()
                .should(seeThat(ValidateQuantityKeys.getKeys(quantityKeys),
                                Matchers.equalTo(quantityKeys))
                                .orComplainWith(AssertionsServices.class, QUANTITY_FIELDS_SERVICE_IS_NOT_EXPECTED)
        );
    }

    //@Scenario3
    @Then("^The user validates the json schema \"([^\"]*)\"$")
    public void theUserValidatesTheJsonSchema(String schemaResponse) {
        theActorInTheSpotlight()
                .should(seeThat(ValidateJsonSchema.expected(schemaResponse))
                                .orComplainWith(AssertionsServices.class, SCHEMA_SERVICE_IS_NOT_EXPECTED)
                );
    }

    //@Scenario4
    @Then("^The user validates the response fields api$")
    public void theUserValidatesTheResponseFieldsApi() {
        theActorInTheSpotlight()
                .should(seeThat(ValidateResponseFields.validateResponseFields())
                                .orComplainWith(AssertionsServices.class, RESPONSE_FIELDS_ARE_NOT_EXPECTED)
                );
    }

    @When("^The user consults by id (.*)$")
    public void theUserConsultsById(int id) {
        theActorInTheSpotlight().attemptsTo(GetUserReqRes.getUserById(id));
    }

    //@Scenario5
    @Then("^The user validates the response fields and expected data$")
    public void theUserValidatesTheResponseFieldsAndExpectedData(List<DataUserGet> dataList) {
        theActorInTheSpotlight()
                .should(seeThat(ValidateExpectedDataAlternate.expected(dataList.get(0)),
                                Matchers.equalTo(true))
                                .orComplainWith(AssertionsServices.class, RESPOSE_DATA_ARE_NOT_EXPECTED)
                );
    }

    //@Scenario6
    @Then("^The user validates the response fields$")
    public void theUserValidatesTheResponseFields(List<DataUserGet> dataList) {
        OnStage.theActorInTheSpotlight()
                .should(seeThat(ValidateExpectedData.validateExpectedData(dataList.get(0)),
                                Matchers.equalTo(true))
                                .orComplainWith(AssertionsServices.class, RESPOSE_DATA_ARE_NOT_EXPECTED)
                );
    }
}