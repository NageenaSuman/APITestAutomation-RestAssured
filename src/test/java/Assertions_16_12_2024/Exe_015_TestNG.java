package Assertions_16_12_2024;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Exe_015_TestNG {


        @Test
        public void test_hardAssertExample() { // this will not execute next line if assert fails
            System.out.println("Start of the program");
            Boolean is_neeru_male = false;
            Assert.assertTrue(is_neeru_male);
            System.out.println("End of the program");
            Assert.assertEquals("Pramod","Pramod");

        }

        @Test
        public void test_softAssertExample() { //this will execute next line even if assert fails but show failure
            SoftAssert sa = new SoftAssert();
            sa.assertFalse(false);
            System.out.println("This line will be executed.");
            sa.assertFalse(true);
            System.out.println("Next line executed.");
            sa.assertAll(); // This will report all collected errors.


        }


    }

