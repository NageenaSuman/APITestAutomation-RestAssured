package org.nageena.SampleTest_11_12_2024;

import io.restassured.*;

public class Exe_02_GherkinSyntax {
    public static void main(String[] args) {


        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == Nageena


        // Full URL -https://reqres.in/api/users
        // base URI - https://reqres.in
        // base Path - /api/users


        RestAssured
                .given()
                    .baseUri("https://reqres.in")
                    .basePath("/api/users/1")
                .when()
                    .get()
                .then()
                .log().all().statusCode(200);

        }
}
