package RestAssuredTestNG_12_12_2024.PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Exe_11_NonBDDStyle {

    RequestSpecification r = RestAssured.given();
    Response re;
    ValidatableResponse vr;

    @Test
    public void test_post(){
        String booking_id = "72";
        String payload  = "{\n" +

                "    \"job\": \"QA Analyst\"\n" +
                             "}";

        r.given().baseUri("https://reqres.in")
                .basePath("/api/users/"+ booking_id).contentType(ContentType.JSON).body(payload);
        re = r.when().log().all().patch();
        vr = re.then().log().all().statusCode(200);



    }




}
