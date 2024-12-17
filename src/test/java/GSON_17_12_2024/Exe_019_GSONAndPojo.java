package GSON_17_12_2024;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class Exe_019_GSONAndPojo {
    RequestSpecification r = RestAssured.given();
    Response re;
    ValidatableResponse vr;

    @Test
    public void test_Booking(){

        // Step1 - POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth - NO

        // Step 2
        // prepare the Payload ( Object -> JSON String)
        // send the request

        //Step 3
        // Validate Response ( JSON String -> Object)
        // FirstName,
        // Status Code
        // Time Response

        // creating instance of class for payload filling
        // Class 1 - Booking
        Booking booking = new Booking();
        booking.setFirstname("Hash");
        booking.setLastname("Brown");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);
        // Class 2 - Bookingdates
        Bookingdates booking_d = new Bookingdates();
        booking_d.setCheckin("2024-09-08");
        booking_d.setCheckout("2024-09-16");
        // Making booking to include booking dates
        booking.setBookingdates(booking_d);


        // Converting obj to json
        Gson gson = new Gson();
        String payload = gson.toJson(booking);
        System.out.println(booking);

        // Payload request process
        r.given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking").contentType(ContentType.JSON).body(payload);
        re = r.when().log().all().post();
        vr = re.then().log().all().statusCode(200);



        // 1. Response extraction - Direct Method
        String fi_name = vr.extract().path("booking.firstname");
        System.out.println("Direct method - " + fi_name);

        // 2. Response extraction - JSON Path Method
        JsonPath jp = new JsonPath(re.asString());
        String fi_name1 = jp.getString("booking.firstname");
        String booking_id = jp.getString("bookingid");
        System.out.println("JSON Path - " + fi_name1);
        System.out.println("JSON Path - " + booking_id);

        // 3. Response extraction - DeSerialization Method - above two methods has limitations
        // taking json as string
        String json_string = re.asString();
        ResponseBooking rp = gson.fromJson(json_string, ResponseBooking.class); // instead pf creating
        //new instance of response class we are calling gson to convert response json into class
        System.out.println(rp.getBookingid());
        System.out.println(rp.getBooking().getFirstname());
        System.out.println(rp.getBooking().getTotalprice());


        //Assertion
        assertThat(rp.getBookingid()).isNotNull();
        assertThat(rp.getBooking().getFirstname()).isEqualTo("Hash").isNotNull().isNotEmpty();



    }









}
