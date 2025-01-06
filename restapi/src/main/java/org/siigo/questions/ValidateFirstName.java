package org.siigo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class ValidateFirstName implements Question<Boolean> {
    private String name;

    public ValidateFirstName(String name) {
        this.name = name;
    }

    public static ValidateFirstName name(String name){
        return new ValidateFirstName(name);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("RESPONSE REQUEST: ",
                reponse -> reponse.body("data.first_name",equalTo(name)))
        );
        return true;
    }

}
