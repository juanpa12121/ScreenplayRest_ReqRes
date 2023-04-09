package co.com.tcs.certification.reqres.questions;

import co.com.tcs.certification.reqres.models.DataUserGet;
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
        DataUserGet dataUserObjectFromApi = SerenityRest.lastResponse().jsonPath().getObject("data", DataUserGet.class);
        return (dataUserObjectFromApi.getId() == dataUser.getId())&&
                dataUserObjectFromApi.getEmail().equals(dataUser.getEmail())&&
                (dataUserObjectFromApi.getFirst_name().equals(dataUser.getFirst_name()))&&
                (dataUserObjectFromApi.getLast_name().equals(dataUser.getLast_name()))&&
                (dataUserObjectFromApi.getAvatar()).equals(dataUser.getAvatar());
    }

    public static ValidateGetFields validateResponseFields(DataUserGet dataUser){
        return new ValidateGetFields(dataUser);
    }
}
