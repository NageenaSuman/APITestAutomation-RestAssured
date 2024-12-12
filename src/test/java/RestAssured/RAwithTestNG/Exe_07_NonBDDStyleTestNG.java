package RestAssured.RAwithTestNG;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Exe_07_NonBDDStyleTestNG {
    // This method is used when there are more than 100 TC's by using RestAsuured Interfaces
    // No duplicate of code and instance variable is used
    RequestSpecification rs  ; // When block
    Response re;   // Given block
    ValidatableResponse vr; //Then block ---- instance variable for re-use
    @Description ("Verify the positive test cases")
    @Test
    public void test_001(){
        String id = "1";
        rs = RestAssured.given();
                rs.baseUri("https://reqres.in");
                rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }
    @Test
    public void test_002(){
        String id = "2";
        rs = RestAssured.given();
        rs.baseUri("https://reqres.in");
        rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }
    @Test
    public void test_003(){
        String id = "12";
        rs = RestAssured.given();
        rs.baseUri("https://reqres.in");
        rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }
    @Description ("Verify the negative test cases")
    @Test
    public void test_004(){
        String id = "null";
        rs = RestAssured.given();
        rs.baseUri("https://reqres.in");
        rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }
    @Test
    public void test_005(){
        String id = "-98";
        rs = RestAssured.given();
        rs.baseUri("https://reqres.in");
        rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }
    @Test
    public void test_006(){
        String id = "100000000000";
        rs = RestAssured.given();
        rs.baseUri("https://reqres.in");
        rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }
    @Test
    public void test_007(){
        String id = "pk@333%%";
        rs = RestAssured.given();
        rs.baseUri("https://reqres.in");
        rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }
    @Test
    public void test_008(){
        String id = "PKpk";
        rs = RestAssured.given();
        rs.baseUri("https://reqres.in");
        rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }
    @Test
    public void test_009(){
        String id = " ";
        rs = RestAssured.given();
        rs.baseUri("https://reqres.in");
        rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }
    @Test
    public void test_0010(){
        String id = "";
        rs = RestAssured.given();
        rs.baseUri("https://reqres.in");
        rs.basePath("/api/users/"+ id);
        re = rs.when().log().all().get();
        vr = re.then().log().all().statusCode(200);
    }




}
