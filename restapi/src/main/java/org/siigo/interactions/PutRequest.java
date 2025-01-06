package org.siigo.interactions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutRequest implements Interaction {

    private String bodyRequest;
    private final String requestUri;
    private final String typeContent;

    public PutRequest( String bodyRequest, String requestUri, String typeContent) {
        this.bodyRequest = bodyRequest;
        this.requestUri = requestUri;
        this.typeContent = typeContent;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Put.to(requestUri)
                        .with(request -> request
                                .contentType(typeContent)
                                .body(bodyRequest)
                                .relaxedHTTPSValidation())
        );

        SerenityRest.lastResponse().body().prettyPrint();
    }

    public static PutRequest params(String bodyRequest, String requestUri, String typeContent) {
        return Tasks.instrumented(PutRequest.class, bodyRequest, requestUri, typeContent);
    }
}
