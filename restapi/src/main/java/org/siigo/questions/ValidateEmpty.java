package org.siigo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class ValidateEmpty implements Question<Boolean> {



    public static ValidateEmpty body(){
        return new ValidateEmpty();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("RESPONSE REQUEST: ",
                        reponse -> reponse.body(equalTo("")))
        );
        return true;
    }

}
