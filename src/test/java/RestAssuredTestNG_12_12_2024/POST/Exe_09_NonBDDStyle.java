package RestAssuredTestNG_12_12_2024.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Exe_09_NonBDDStyle {

    RequestSpecification r = RestAssured.given();
    Response re;
    ValidatableResponse vr;

    @Test
    public void test_post(){
        String payload  = "{\n" +
                "    \"name\": \"Nageena Suman\",\n" +
                "    \"job\": \"QA Analyst\"\n" +
                "}";

        r.given().baseUri("https://reqres.in")
                .basePath("/api/users").contentType(ContentType.JSON).body(payload);
        re = r.when().log().all().post();
        vr = re.then().log().all().statusCode(201);



    }




}
