package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Open;
import ui.SiigoPage;

public class OpenPage implements Task {
    private SiigoPage siigoPage;
    public static OpenPage lginPage(){
        return Tasks.instrumented(OpenPage.class);
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Open.browserOn(siigoPage)
        );
    }
}
