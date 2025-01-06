package org.siigo.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteRequest implements Interaction {

    private final String request;
    private final String typeContent;

    public DeleteRequest(String request, String typeContent) {
        this.request = request;
        this.typeContent = typeContent;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Delete
                        .from(request)
                        .with(requestSpecification -> requestSpecification
                                .accept(typeContent)
                                .relaxedHTTPSValidation())
        );


        SerenityRest.lastResponse().body().prettyPrint();
    }

    public static DeleteRequest params(String request, String typeContent) {
        return Tasks.instrumented(DeleteRequest.class, request, typeContent);
    }
}
