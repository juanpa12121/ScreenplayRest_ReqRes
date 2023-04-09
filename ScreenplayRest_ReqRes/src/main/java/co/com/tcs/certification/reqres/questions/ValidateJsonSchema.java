package co.com.tcs.certification.reqres.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.rest.questions.ResponseConsequence;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ValidateJsonSchema implements Question<Boolean> {

    private String structure;

    public ValidateJsonSchema(String schemaResponse) {
        this.structure = schemaResponse;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                ResponseConsequence.seeThatResponse("Validation JSON Schema service response", response -> response
                        .body(matchesJsonSchemaInClasspath("schemas/"+structure+".json")))
        );
        return true;
    }

    public static ValidateJsonSchema expected(String schemaResponse) {
        return new ValidateJsonSchema(schemaResponse);
    }
}
