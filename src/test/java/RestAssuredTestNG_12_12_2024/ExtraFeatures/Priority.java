package RestAssuredTestNG_12_12_2024.ExtraFeatures;

import org.testng.annotations.Test;

public class Priority {

    @Test(priority = 2)
    public void test_p2(){
        System.out.println("P2");
    }
    @Test(priority = 1)
    public void test_p1(){
        System.out.println("P1");
    }
    @Test(priority = 3)
    public void test_p3(){
        System.out.println("P3");
    }

}
