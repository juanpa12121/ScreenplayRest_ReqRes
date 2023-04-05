package co.com.tcs.certification.reqres.tasks;

import co.com.tcs.certification.reqres.models.DataUserCreate;
import co.com.tcs.certification.reqres.utils.Constants;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.List;

import static co.com.tcs.certification.reqres.utils.Constants.USERS;

public class CreateUserReqRes implements Task {

    private DataUserCreate userBody;

    public CreateUserReqRes(DataUserCreate userBody) {
        this.userBody = userBody;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Post.to(USERS)
                        .with(requestSpecification -> requestSpecification
                                .header("Content-Type", "application/json")
                                .body(userBody).log().all().relaxedHTTPSValidation()));

        System.out.println("\nImpresion de la respuesta del post");
        SerenityRest.lastResponse().prettyPrint();
        //actor.remember("userBody", userBody );
    }

    public static CreateUserReqRes createUser(DataUserCreate userCreateData ){
        return Tasks.instrumented(CreateUserReqRes.class, userCreateData);
    }
}
