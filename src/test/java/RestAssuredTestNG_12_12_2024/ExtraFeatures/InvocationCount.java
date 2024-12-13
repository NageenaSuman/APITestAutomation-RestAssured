package RestAssuredTestNG_12_12_2024.ExtraFeatures;

import org.testng.annotations.Test;

public class InvocationCount {

    @Test(invocationCount = 3, priority = 2)
    public void test_p2(){
        System.out.println("P2");
    }
    @Test(priority = 1)
    public void test_p0(){
        System.out.println("P0");
    }


}
