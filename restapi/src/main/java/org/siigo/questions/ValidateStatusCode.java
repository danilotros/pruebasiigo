package org.siigo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class ValidateStatusCode implements Question<Boolean> {
    private int statusCode;

    public ValidateStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public static ValidateStatusCode code(int statusCode){
        return new ValidateStatusCode(statusCode);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("RESPONSE REQUEST: ",
                        reponse -> reponse.statusCode(statusCode))
        );
        return true;
    }

}
