import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class PokeApiTest {

    @Test
    public void testPokeApi() {

        // Navigate to URL
        given()
                .baseUri("https://pokeapi.co")
                .log()
                .all().
        // Getting the endpoint
        when()
                .get("/api/v2/berry").
        // Validate the JSON Schema
        then()
                .log()
                .all()
                .statusCode(200)
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Berry.json"));
    }
}
