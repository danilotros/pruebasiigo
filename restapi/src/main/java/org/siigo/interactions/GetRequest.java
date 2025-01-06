package org.siigo.interactions;

import net.serenitybdd.model.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.annotations.Subject;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import net.thucydides.model.util.EnvironmentVariables;

public class GetRequest implements Interaction {



    private final String request;
    private final String typeContent;

    public GetRequest(String request, String typeContent) {
        this.request = request;
        this.typeContent = typeContent;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource(request)
                        .with(requestSpecification -> requestSpecification
                                .accept(typeContent)
                                .relaxedHTTPSValidation())
        );

        SerenityRest.lastResponse().body().prettyPrint();
    }

    public static GetRequest params( String request, String typeContent) {
        return Tasks.instrumented(GetRequest.class, request, typeContent);
    }
}
