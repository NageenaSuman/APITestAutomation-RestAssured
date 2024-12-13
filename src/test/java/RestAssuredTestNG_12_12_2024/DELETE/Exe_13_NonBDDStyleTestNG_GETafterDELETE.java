package RestAssuredTestNG_12_12_2024.DELETE;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Exe_13_NonBDDStyleTestNG_GETafterDELETE {
    // This method is used when there are more than 100 TC's by using RestAsuured Interfaces
    // No duplicate of code and instance variable is used
    RequestSpecification rs  ; // When block
    Response re;   // Given block
    ValidatableResponse vr; //Then block ---- instance variable for re-use
    @Description ("Verify the positive test cases")
    @Test
    public void test_001(){
        String id = "72";
        rs = RestAssured.given();
                rs.baseUri("https://reqres.in");
                rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(404);
    }





}
