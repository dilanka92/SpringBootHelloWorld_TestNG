package com.dilanka.test.annotations;

import com.dilanka.controllers.Calculator;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestCalculator {

    private Calculator calculator;

    @BeforeClass
    public void beforeClass() {
        //Ideal place to perform some setup which is shared among all tests.
        //E.g. Initializing DB connection, setting environment properties
        System.out.println("@BeforeClass: I run only once, before first test start.");
        calculator = new Calculator();
    }

    @AfterClass
    public void afterClass() {
        //Ideal place to perform some cleanup of setup which is shared among all tests.
        System.out.println("@AfterClass: I run only once, after all tests have been done.\n");
        calculator = null;
    }

    @BeforeMethod
    public void beforeEachTestMethod(Method method) {//Parameter are optional
        //May perform some initialization/setup before each test.
        //E.g. Initializing User whose properties may be altered by actual @Test
        System.out.println("\n@BeforeMethod: I run before each test method. Test to be executed is : " + method.getName());
    }

    @AfterMethod
    public void afterEachTestMethod(Method method) {//Parameter are optional
        //May perform cleanup of initialization/setup after each test.
        System.out.println("@AfterMethod: I run after each test method. Test just executed is : " + method.getName() + "\n");
    }

    @Test
    public void testAdd() {
        System.out.println("@Test add");
        Assert.assertEquals(calculator.add(2, 3), 5.0);
    }

    @Test
    public void testSubtract() {
        System.out.println("@Test subtract");
        Assert.assertTrue(calculator.subtract(5, 3) > 1, "Subtract test failed");
    }

    @Test
    public void testMultiply() {
        System.out.println("@Test multiply");
        Assert.assertEquals(calculator.multiply(5, 3), 15.0);
    }

}