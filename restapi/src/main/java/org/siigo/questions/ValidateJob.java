package org.siigo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class ValidateJob implements Question<Boolean> {
    private String job;

    public ValidateJob(String job) {
        this.job = job;
    }

    public static ValidateJob job(String job){
        return new ValidateJob(job);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse("RESPONSE REQUEST: ",
                        reponse -> reponse.body("job",equalTo(job)))
        );
        return true;
    }

}
