package Assertions_16_12_2024;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
import org.testng.asserts.SoftAssert;

public class Exe_016_AssertJ_CombinedAll {

    RequestSpecification r = RestAssured.given();
    Response re;
    ValidatableResponse vr;

    //to extract values
    Integer bookingId ; //wrapper class
    String first_name,last_name, booking_date;

    @Test
    public void test_post_RA_All(){
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
        vr = re.then();

        // Rest Assured -> import org.hamcrest.Matchers; ---> Using JSON Path finder

        vr.body("booking.firstname", Matchers.equalTo("Nageena")); //where booking. is from URL
        vr.body("booking.lastname",Matchers.equalTo("PK"));
        vr.body("booking.bookingdates.checkin",Matchers.notNullValue());
        vr.body("booking.depositpaid",Matchers.equalTo(false));

        // Test NG Assertions_16_12_2024

        // Now extracting data from response
        bookingId = vr.extract().path("bookingid"); //not getting created so ignore
        System.out.println(bookingId);
        first_name = vr.extract().path("booking.firstname");
        last_name = vr.extract().path("booking.lastname");
        booking_date = vr.extract().path("booking.bookingdates.checkin");
        //Validation
        Assert.assertEquals(first_name, "Nageena");
        Assert.assertEquals(last_name, "PK");
        System.out.println(booking_date);
        //Assert.assertNotNull(bookingId);
        SoftAssert sa = new SoftAssert();
        sa.assertNotNull(booking_date);

        // AssertJ
        assertThat(bookingId).isNotNull();
        assertThat(first_name).isEqualTo("Nageena");
        assertThat(last_name).isEqualTo("PK");
        assertThat(booking_date).isNotNull();

        

    }
}
