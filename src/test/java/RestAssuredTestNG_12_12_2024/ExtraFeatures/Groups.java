package RestAssuredTestNG_12_12_2024.ExtraFeatures;

import org.testng.annotations.Test;

public class Groups {

    @Test(groups = {"Smoke", "QA", "PROD"})

    public void test_sanity(){
        System.out.println("Sanity Testing");
    }
    @Test(groups = {"Smoke", "QA"})
    public void test_QA(){
        System.out.println("QA");
    }
    @Test(groups = {"Smoke", "PROD"})
    public void test_PROD(){
        System.out.println("PROD");
    }
}
