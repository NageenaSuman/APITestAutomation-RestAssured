package RestAssured.RAwithTestNG;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Exe_06_WithBDDStyleTestNG {
    // This method can be used till the test cases are 100
    @Test
    public void test_PositiveTC() {
    //Positive_TestCase
    String pin = "632001";
    RestAssured.given()
            .baseUri("https://api.zippopotam.us/")
            .basePath("IN/" + pin)
            .when().log().all()
            .get()
            .then().log().all().statusCode(200);
    }
    @Test
    public void test_NegativeTC() {
        //Negative_TestCase
        String pin1 = "-1";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("IN/" + pin1)
                .when().log().all()
                .get()
                .then().log().all().statusCode(404); // 200 - this will throw error so use reverse assertion
        // by changing status code to the exact return status code to make it pass
    }
        // to generate allure - reports run this command in console
        // allure serve allure-results
}
