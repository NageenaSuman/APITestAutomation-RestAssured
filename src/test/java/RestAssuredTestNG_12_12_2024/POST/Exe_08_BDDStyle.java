package RestAssuredTestNG_12_12_2024.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class Exe_08_BDDStyle {
    @Test
    public void test_Post() {
        String payload = "{\n" +
                "    \"name\": \"MackJeans\",\n" +
                "    \"job\": \"Team Lead\"\n" +
                "}";

        RestAssured.given()
                .baseUri("https://reqres.in")
                .basePath("/api/users")
                .contentType(ContentType.JSON) //header
                .body(payload) //body
                .when().log().all().post()
                .then().log().all().statusCode(201);
    }
}
