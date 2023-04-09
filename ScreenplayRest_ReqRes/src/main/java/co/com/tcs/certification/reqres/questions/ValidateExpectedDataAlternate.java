package co.com.tcs.certification.reqres.questions;

import co.com.tcs.certification.reqres.models.DataUserGet;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;
import org.hamcrest.Matchers;

public class ValidateExpectedDataAlternate implements Question<Boolean> {

    private DataUserGet dataUserGet;

    public ValidateExpectedDataAlternate(DataUserGet dataUserGet) {
        this.dataUserGet = dataUserGet;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                ResponseConsequence.seeThatResponse("Validation of response fields and values",
                        response -> response
                                .assertThat()
                                .and().body("data.id", Matchers.equalTo(dataUserGet.getId()))
                                .and().body("data.email", Matchers.equalTo(dataUserGet.getEmail()))
                                .and().body("data.first_name", Matchers.equalTo(dataUserGet.getFirst_name()))
                                .and().body("data.last_name", Matchers.equalTo(dataUserGet.getLast_name()))
                                .and().body("data.avatar", Matchers.equalTo(dataUserGet.getAvatar()))
                                .and().body("support.url", Matchers.equalTo(dataUserGet.getUrl()))
                                .and().body("support.text", Matchers.equalTo(dataUserGet.getText()))
                )
        );
        return true;
    }

    public static ValidateExpectedDataAlternate expected(DataUserGet dataUserGet){
        return new ValidateExpectedDataAlternate(dataUserGet);
    }
}