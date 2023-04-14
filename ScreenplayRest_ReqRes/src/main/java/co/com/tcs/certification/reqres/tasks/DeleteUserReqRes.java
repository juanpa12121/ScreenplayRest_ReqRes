package co.com.tcs.certification.reqres.tasks;

import co.com.tcs.certification.reqres.models.DataUserGet;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.List;

import static co.com.tcs.certification.reqres.utils.Constants.PARAM_ID;
import static co.com.tcs.certification.reqres.utils.Constants.USERS;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserReqRes implements Task {

    private int id;

    public DeleteUserReqRes(int id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                GetUserReqRes.getUserById(id)
        );
        int statusCode = SerenityRest.lastResponse().getStatusCode();
        if(statusCode == 200){
            actor.attemptsTo(
                    Delete.from(USERS)
                            .with(requestSpecification ->
                                    requestSpecification.param(PARAM_ID, id)
                                            .log().all().relaxedHTTPSValidation()
                            )
            );
            System.out.println("Id desde feature: "+id);
            System.out.println("Codigo resultante del delete: "+ SerenityRest.lastResponse().getStatusCode());
        }else{
            throw new IllegalStateException("User not found with id: " + id);
        }

    }

    public static DeleteUserReqRes deleteUser(int id){
        return instrumented(DeleteUserReqRes.class, id);
    }
}
