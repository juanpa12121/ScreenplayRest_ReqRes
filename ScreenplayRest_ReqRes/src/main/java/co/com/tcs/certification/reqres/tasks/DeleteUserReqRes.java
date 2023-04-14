package co.com.tcs.certification.reqres.tasks;

import co.com.tcs.certification.reqres.models.DataUserGet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static co.com.tcs.certification.reqres.utils.Constants.PARAM_ID;
import static co.com.tcs.certification.reqres.utils.Constants.USERS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserReqRes implements Task {

    private DataUserGet dataUserGet;

    public DeleteUserReqRes(DataUserGet dataUserGet) {
        this.dataUserGet = dataUserGet;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Delete.from(USERS)
                        .with(requestSpecification ->
                                requestSpecification.param(PARAM_ID, dataUserGet.getId())
                                        .log().all().relaxedHTTPSValidation()
                        )
        );
        System.out.println("Id desde feature: "+dataUserGet.getId());
        System.out.println("Codigo resultante del delete: "+ SerenityRest.lastResponse().getStatusCode());
    }

    public static DeleteUserReqRes deleteUser(DataUserGet data){
        return instrumented(DeleteUserReqRes.class, data);
    }
}
