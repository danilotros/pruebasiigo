package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.Enter;

import static ui.SiigoPage.INPUT_NAME;

public class Empty implements Task {
    private String name;

    public Empty(String name) {
        this.name = name;
    }
    public static Empty inputName(String name){
        return Tasks.instrumented(Empty.class,name);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.keyValues(name).into(INPUT_NAME),
                Clear.field(INPUT_NAME)
        );
    }
}
