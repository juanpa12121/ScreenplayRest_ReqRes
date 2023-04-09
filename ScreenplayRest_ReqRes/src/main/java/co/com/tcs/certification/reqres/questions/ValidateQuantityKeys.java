package co.com.tcs.certification.reqres.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateQuantityKeys implements Question<Integer> {

    private int quantityKeys;

    public ValidateQuantityKeys(int quantityKeys) {
        this.quantityKeys = quantityKeys;
    }

    @Override
    public Integer answeredBy(Actor actor) {
        System.out.println(SerenityRest.lastResponse().getBody().jsonPath().getMap("").size());
        return SerenityRest.lastResponse().getBody().jsonPath().getMap("").size();
    }


    public static ValidateQuantityKeys getKeys(int quantityKeys) {
        return new ValidateQuantityKeys(quantityKeys);
    }
}
