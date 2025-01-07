package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static ui.SiigoPage.BTN_CREATE;
import static ui.SiigoPage.LINK_CLIENT;

public class Show implements Task {
    public static Show clienteForm(){
        return Tasks.instrumented(Show.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BTN_CREATE),
                Click.on(LINK_CLIENT)
        );
    }
}
