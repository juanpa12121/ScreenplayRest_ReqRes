package co.com.tcs.certification.reqres.tasks;

import co.com.tcs.certification.reqres.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static co.com.tcs.certification.reqres.utils.Constants.PARAM_ID;
import static co.com.tcs.certification.reqres.utils.Constants.USERS;

public class GetUserReqRes implements Task {

    private int id;

    public GetUserReqRes(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(USERS)
                        .with(requestSpecification ->
                                requestSpecification.param(PARAM_ID, id)
                                        .log().all().relaxedHTTPSValidation())
        );
        SerenityRest.lastResponse().prettyPrint();
    }

    public static GetUserReqRes getUserById(int id) {
        return Tasks.instrumented(GetUserReqRes.class, id);
    }
}
