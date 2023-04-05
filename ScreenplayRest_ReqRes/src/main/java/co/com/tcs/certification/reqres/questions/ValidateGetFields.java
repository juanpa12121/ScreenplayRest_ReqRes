package co.com.tcs.certification.reqres.questions;

import co.com.tcs.certification.reqres.models.DataUserGet;
import cucumber.api.java.eo.Se;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateGetFields implements Question<Boolean> {

    private DataUserGet dataUser;

    public ValidateGetFields(DataUserGet dataUser) {
        this.dataUser = dataUser;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        DataUserGet dataUserGetList = SerenityRest.lastResponse().jsonPath().getObject("data",DataUserGet.class);
        return dataUserGetList.getEmail().equals(dataUser.getEmail());
    }

    public static ValidateGetFields validateResponseFields(DataUserGet dataUser){
        return new ValidateGetFields(dataUser);
    }
}
