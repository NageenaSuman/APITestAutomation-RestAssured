package RestAssuredTestNG_12_12_2024.ExtraFeatures;

import org.testng.annotations.Test;

public class DependsOnMethod {

    @Test
    public void test_p2(){
        System.out.println("P2");
    }
    @Test //to exclude
    public void test_p1(){
        System.out.println("P1");
    }
    @Test(dependsOnMethods = "test_p2")
    public void test_p3(){
        System.out.println("P3");
    }

}
