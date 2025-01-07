package stepdefinitions;


import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnlineCast;
import questions.ValidateService;
import questions.ValidateText;
import questions.ValidateValueText;
import tasks.Empty;
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



    @When("^the user enters a name (.*)$")
    public void theUserEntersAName(String name) {
        theActorInTheSpotlight().attemptsTo(
                Empty.inputName(name)
        );
    }



    @Then("^an error (.*) is shown$")
    public void anErrorIsShown(String error) {
        theActorInTheSpotlight().should(seeThat(ValidateValueText.errorLabel(error)));
    }


    @Then("the Create Client form loads")
    public void theCreateClientFormLoads() {
        theActorInTheSpotlight().should(seeThat(ValidateService.loadPage()));
        
    }

    @And("^the form contains (.*), (.*), (.*)$")
    public void theFormContains(String name, String lastname, String identification) {
        theActorInTheSpotlight().should(seeThat(ValidateValueText.nameLabel(name)));
        theActorInTheSpotlight().should(seeThat(ValidateValueText.lastNameLabel(lastname)));
        theActorInTheSpotlight().should(seeThat(ValidateValueText.identificationLabel(identification)));
    }
}
