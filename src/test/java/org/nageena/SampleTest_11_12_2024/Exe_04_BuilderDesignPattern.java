package org.nageena.SampleTest_11_12_2024;

public class Exe_04_BuilderDesignPattern {
    public Exe_04_BuilderDesignPattern step1(){
        System.out.println("Executing Step 1");
        return this; //returning own class
    }
    public  Exe_04_BuilderDesignPattern step2(){
        System.out.println("Executing Step 2");
        return this;
    }
    public  Exe_04_BuilderDesignPattern step3(){
        System.out.println("Executing Step 3");
        return this;

    }

    public static void main(String[] args) {
        Exe_04_BuilderDesignPattern obj1 = new Exe_04_BuilderDesignPattern();
        obj1.step1().step2().step3();

    }
}
