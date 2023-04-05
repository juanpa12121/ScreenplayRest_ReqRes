package co.com.tcs.certification.reqres.questions;

import co.com.tcs.certification.reqres.models.DataUserCreate;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateCreateUser implements Question<Boolean> {

    private DataUserCreate dataUserCreate;

    public ValidateCreateUser(DataUserCreate dataUserCreate) {
        this.dataUserCreate = dataUserCreate;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        DataUserCreate dataUserObjectFromApi = SerenityRest.lastResponse().jsonPath().getObject("", DataUserCreate.class);
        //DataUserCreate dataUserObjectFromApi2 = SerenityRest.lastResponse().body().as(DataUserCreate.class);
        
        //return dataUserObjectFromApi.toString().equals(actor.recall("userBody").toString());
        //return dataUserObjectFromApi.toString().equals(dataUserCreate.toString());
        return (dataUserObjectFromApi.getName().equals(dataUserCreate.getName()))&&
                (dataUserObjectFromApi.getJob().equals(dataUserCreate.getJob()));
    }

    public static ValidateCreateUser validateUserCreation(DataUserCreate dataUser){
        return new ValidateCreateUser(dataUser);
    }
}
