package com.xiaoguangchen.testngex;


import org.testng.annotations.Test;

public class Sample {


    @Test
    public void sampleTest1() {
        System.out.println("Sample.sampleTest1");
    }

    @Test
    public void sampleTest2() {
        System.out.println("Sample.sampleTest2");
    }

    @Test
    public void sampleTest3() {
        System.out.println("Sample.sampleTest3");
    }

    @Test
    public void failureTest() {
        System.out.println("Sample.failureTest");
        //like to see the stack trace
        throw new RuntimeException("This should failure");
    }


}
