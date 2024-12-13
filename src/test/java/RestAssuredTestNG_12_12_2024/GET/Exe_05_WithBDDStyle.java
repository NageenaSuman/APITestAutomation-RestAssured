package RestAssuredTestNG_12_12_2024.GET;

import io.restassured.RestAssured;

public class Exe_05_WithBDDStyle {

    public static void main(String[] args) {
        //Positive_TestCase
        String pin = "632001";
        RestAssured.given()
                .baseUri("https://api.zippopotam.us/")
                .basePath("IN/" + pin)
                .when().log().all()
                .get()
                .then().log().all().statusCode(200);

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

}
