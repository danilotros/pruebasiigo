package org.siigo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class ValidateName implements Question<Boolean> {
    private String name;

    public ValidateName(String name) {
        this.name = name;
    }

    public static ValidateName name(String name){
        return new ValidateName(name);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("RESPONSE REQUEST: ",
                reponse -> reponse.body("name",equalTo(name)))
        );
        return true;
    }

}
