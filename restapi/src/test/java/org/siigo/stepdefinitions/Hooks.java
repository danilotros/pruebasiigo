package org.siigo.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;



import static org.siigo.utils.Routes.BASE_URL;

public class Hooks {
    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled("daniel").whoCan(CallAnApi.at(BASE_URL.toString()));
    }
}
