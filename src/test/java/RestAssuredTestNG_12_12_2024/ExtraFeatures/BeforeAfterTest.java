package RestAssuredTestNG_12_12_2024.ExtraFeatures;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.xml.transform.Source;

public class BeforeAfterTest {

    @BeforeClass
    public void test_before(){
        System.out.println("Get Token");
    }
    @BeforeClass
    public void test_before1(){
        System.out.println("Get Booking ID");
    }
    @Test
    public void test_main(){
        System.out.println("Main test to run");
    }
    @AfterTest
    public void test_after(){
        System.out.println("After Test to be executed");
    }
}
