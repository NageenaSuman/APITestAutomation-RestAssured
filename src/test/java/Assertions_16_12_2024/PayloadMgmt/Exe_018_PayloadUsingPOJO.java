package Assertions_16_12_2024.PayloadMgmt;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static org.assertj.core.api.Assertions.assertThat;

public class Exe_018_PayloadUsingPOJO {

    RequestSpecification r = RestAssured.given();
    Response re;
    ValidatableResponse vr;

    //to extract values
    Integer bookingId ; //wrapper class
    String first_name,last_name, booking_date;

    @Test
    public void test_post_RA_Map_GSON(){
////        String payload  = "{\n" +
////                "    \"firstname\" : \"Nageena\",\n" +
////                "    \"lastname\" : \"PK\",\n" +
////                "    \"totalprice\" : 181,\n" +
////                "    \"depositpaid\" : false,\n" +
////                "    \"bookingdates\" : {\n" +
////                "        \"checkin\" : \"2026-01-01\",\n" +
////                "        \"checkout\" : \"2026-01-01\"\n" +
////                "    },\n" +
////                "    \"additionalneeds\" : \"Dinner\"\n" +
////                "}";
//        //HashMap --- > divide the path into parent and child
//        // hash map for parent
//        Map jsonbody = new LinkedHashMap();
//        jsonbody.put("firstname", "Nageena");
//        jsonbody.put("lastname", "PK");
//        jsonbody.put("totalprice", 34);
//        jsonbody.put("depositpaid",false);
//        // hash map for child
//        Map jsonbody1 = new LinkedHashMap();
//        jsonbody1.put("checkin", "2019-01-10");
//        jsonbody1.put("checkout", "2019-05-10");
//
//        // putting all together in parent --> just a map finally need to be converted to JSON
//        jsonbody.put("bookingdates", jsonbody1);
//        jsonbody.put("additionalneeds", "Dinner");
//
//
//        System.out.println(jsonbody);

        // Map -> JSON ? ( GSON_17_12_2024, Jackson API) --> will be done by GSON_17_12_2024
        // {firstname=Jim, lastname=brown, totalprice=123, depositpaid=true, bookingdates={checkin=2018-01-01, checkout=2019-01-01}, additionalneeds=Breakfast}
        //{"firstname" : "Jim", lastname=brown, totalprice=123, depositpaid=true, bookingdates={checkin=2018-01-01, checkout=2019-01-01}, additionalneeds=Breakfast}

        // from pojo classes
        // https://www.jsonschema2pojo.org/ can use to convert the json to pojo classes
        POJO_booking pjb = new POJO_booking();


        pjb.setFirstname("Nageena");
        pjb.setLastname("PK");
        pjb.setDepositpaid(false);
        pjb.setTotalprice(977);

        POJO_bookingdate pjb1 = new POJO_bookingdate();

        pjb1.setCheckin("2024-12-12");
        pjb1.setCheckout("2024-12-14");

        pjb.setBookingdates(pjb1);
        pjb.setAdditionalneeds("Dinner");

        System.out.println(pjb);


        r.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking").contentType(ContentType.JSON).body(pjb);
        re = r.when().log().all().post();
        vr = re.then();

        // Rest Assured -> import org.hamcrest.Matchers; ---> Using JSON Path finder

        vr.body("booking.firstname", Matchers.equalTo("Nageena")); //where booking. is from URL
        vr.body("booking.lastname",Matchers.equalTo("PK"));
        vr.body("booking.bookingdates.checkin",Matchers.notNullValue());
        vr.body("booking.depositpaid",Matchers.equalTo(false));

        // Test NG Assertions_16_12_2024

        // Now extracting data from response
        bookingId = vr.extract().path("booking.id"); //not getting created so ignore
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
        // assertThat(bookingId).isNotNull();
        assertThat(first_name).isEqualTo("Nageena");
        assertThat(last_name).isEqualTo("PK");
        assertThat(booking_date).isNotNull();



    }
}


