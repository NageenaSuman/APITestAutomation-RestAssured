package RestAssuredTestNG_12_12_2024.ExtraFeatures;
import org.testng.annotations.Parameters;
import groovyjarjarpicocli.CommandLine;
import org.testng.annotations.Test;

public class Parameters1 {

    @org.testng.annotations.Parameters("Browser")
    @Test
    public void browser(String value){
        if (value.equalsIgnoreCase("chrome")) {
            System.out.println("Start my Testing Chrome");
        }
        if (value.equalsIgnoreCase("firefox")) {
            System.out.println("Start my Firefox");
        }
}}
