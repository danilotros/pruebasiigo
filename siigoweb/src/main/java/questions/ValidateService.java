package questions;

import io.restassured.RestAssured;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateService implements Question<Boolean> {
    public static ValidateService loadPage(){
        return new ValidateService();
    }
    @Override
    public Boolean answeredBy(Actor actor) {
        int statusCode = RestAssured.given()
                .baseUri("https://monitoring-receiver-qacol.siigolatam.com")
                .when()
                .get("/faro/collect")
                .getStatusCode();

        return statusCode==202;
    }
}
