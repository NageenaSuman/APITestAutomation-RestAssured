package RestAssuredTestNG_12_12_2024.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Exe_12NonBDDStyle {

    RequestSpecification r = RestAssured.given();
    Response re;
    ValidatableResponse vr;

    @Test
    public void test_post(){
        String booking_id = "72";

        r.given().baseUri("https://reqres.in")
                .basePath("/api/users/"+ booking_id);
        re = r.when().log().all().delete();
        vr = re.then().log().all().statusCode(204);



    }




}
