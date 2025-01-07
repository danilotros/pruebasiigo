package stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.ValidateText;
import questions.ValidateValueText;
import tasks.Login;
import tasks.OpenPage;
import tasks.Show;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;


public class CreateClientsStepdefinition {
    @Before
    public void initialConfiguration(){
        setTheStage(new OnlineCast());
    }

    @Given("the user is on the login page")
    public void theUserIsOnTheLoginPage() {
        theActorCalled("Daniel").wasAbleTo(OpenPage.lginPage());
    }

    @When("^the user login with username (.*) and password (.*)$")
    public void theUserLoginWithUsernameAndPassword(String username, String password) {
        theActorInTheSpotlight().attemptsTo(
                Login.with(username,password)
        );
    }

    @Then("the user is redirected to the dashboard")
    public void theUserIsRedirectedToTheDashboard() {
        theActorInTheSpotlight().should(seeThat(ValidateText.dashboard()));
    }

    @When("the user select client option")
    public void theUserSelectClientOption() {
        theActorInTheSpotlight().attemptsTo(
                Show.clienteForm()
        );
    }

    @Then("^the (.*) form is displayed$")
    public void theFormIsDisplayed(String title) {
        theActorInTheSpotlight().should(seeThat(ValidateValueText.clientForm(title)));
    }



    @When("the user enters a name {string}")
    public void theUserEntersAName(String arg0) {
    }

    @Then("the name is accepted")
    public void theNameIsAccepted() {
    }

    @When("the user leaves the name field empty")
    public void theUserLeavesTheNameFieldEmpty() {
    }

    @Then("an error {string} is shown")
    public void anErrorIsShown(String arg0) {
    }


    @Then("the Create Client form loads")
    public void theCreateClientFormLoads() {
        
    }

    @And("the form contains {string}, {string}, {string}")
    public void theFormContains(String arg0, String arg1, String arg2) {
    }
}
