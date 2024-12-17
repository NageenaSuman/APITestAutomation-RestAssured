package Assertions_16_12_2024;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import org.hamcrest.Matchers; //default Assertion in Rest Assured
import org.testng.annotations.Test;

public class Exe_014_RestAssured {

    RequestSpecification r = RestAssured.given();
    Response re;
    ValidatableResponse vr;

    @Test
    public void test_post_RA_hamcrest(){
        String payload  = "{\n" +
                "    \"firstname\" : \"Nageena\",\n" +
                "    \"lastname\" : \"PK\",\n" +
                "    \"totalprice\" : 181,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2026-01-01\",\n" +
                "        \"checkout\" : \"2026-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Dinner\"\n" +
                "}";

        r.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking").contentType(ContentType.JSON).body(payload);
        re = r.when().log().all().post();
        vr = re.then().log().all().statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers; ---> Using JSON Path finder

        vr.body("booking.firstname", Matchers.equalTo("Nageena")); //where booking. is from URL
        vr.body("booking.lastname",Matchers.equalTo("PK"));
        vr.body("booking.bookingdates.checkin",Matchers.notNullValue());
        vr.body("booking.depositpaid",Matchers.equalTo(false));

}}
