package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import ui.SiigoPage;


public class Login implements Task {
    private String username;
    private String password;

    public Login(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public static Login with(String username,String password){
        return Tasks.instrumented(Login.class,username,password);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SiigoPage.INPUT_USERNAME),
                Enter.keyValues(username).into(SiigoPage.INPUT_USERNAME),
                Click.on(SiigoPage.INPUT_PASSWORD),
                Enter.keyValues(password).into(SiigoPage.INPUT_PASSWORD),
                Click.on(SiigoPage.BTN_LOGIN)
        );
    }
}
