package org.siigo.stepdefinitions;

import com.google.gson.Gson;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.siigo.models.User;
import org.siigo.questions.*;
import org.siigo.task.get.Call;



import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class UserCrudSteoDefinition {


    @Given("^I create a user with the name (.*) and the job (.*)$")
    public void iCreateAUserWithTheNameAndTheJob(String name, String job) {
        theActorInTheSpotlight().attemptsTo(
                org.siigo.task.post.Call.service().apiPost(
                  new Gson().toJson(new User(name,job)),"/api/users",String.valueOf(JSON)

                )
        );

    }

    @When("the response status code is {int}")
    public void theResponseStatusCodeIs(int statuscode) {
        theActorInTheSpotlight().should(seeThat(ValidateStatusCode.code(statuscode)));
    }

    @Then("^the response should contain the user's name (.*)$")
    public void theResponseShouldContainTheUserSName(String name) {
        theActorInTheSpotlight().should(seeThat(ValidateName.name(name)));
    }

    @And("^the response should contain the user's job (.*)$")
    public void theResponseShouldContainTheUserSJob(String job) {
        theActorInTheSpotlight().should(seeThat(ValidateJob.job(job)));
    }

    @Given("I get the user that create")
    public void iGetTheUserThatCreate() {

        theActorInTheSpotlight().attemptsTo(
                Call.service().agiget(
                        "/api/users/"+2,
                        String.valueOf(JSON))
        );
    }

    @Then("the response should contain the user's data")
    public void theResponseShouldContainTheUserSData() {
        theActorInTheSpotlight().should(seeThat(ValidateFirstName.name("Janet")));
    }



    @Given("^I update the user whit the name (.*) and the job (.*)$")
    public void iUpdateTheUserWhitTheNameAndTheJob(String name, String job) {
        theActorInTheSpotlight().attemptsTo(
                org.siigo.task.put.Call.service().agiPut(
                        new Gson().toJson(new User(name,job)),"/api/users/2",String.valueOf(JSON)

                )
        );
    }

    @Given("I delete a user")
    public void iDeleteAUser() {
        theActorInTheSpotlight().attemptsTo(org.siigo.task.delete.Call.service().apiDelete("/api/users/2",String.valueOf(JSON)));
    }

    @Then("the response body should be empty")
    public void theResponseBodyShouldBeEmpty() {
        theActorInTheSpotlight().should(seeThat(ValidateEmpty.body()));
    }
}
