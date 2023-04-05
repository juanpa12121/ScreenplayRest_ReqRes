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
        DataUserGet dataUserObject = SerenityRest.lastResponse().jsonPath().getObject("data", DataUserGet.class);
        return (dataUserObject.getId() == dataUser.getId())&&
                dataUserObject.getEmail().equals(dataUser.getEmail())&&
                (dataUserObject.getFirst_name().equals(dataUser.getFirst_name()))&&
                (dataUserObject.getLast_name().equals(dataUser.getLast_name()))&&
                (dataUserObject.getAvatar()).equals(dataUser.getAvatar());
    }

    public static ValidateGetFields validateResponseFields(DataUserGet dataUser){
        return new ValidateGetFields(dataUser);
    }
}
