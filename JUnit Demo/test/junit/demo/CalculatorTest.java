/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package junit.demo;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kmhasan
 */
public class CalculatorTest {
    long start;
    long stop;
    static long testCaseNumber = 1;
    
    public CalculatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        start = System.currentTimeMillis();
    }
    
    @After
    public void tearDown() {
        stop = System.currentTimeMillis();
        long timeElapsed = stop - start;
        System.out.println("Test case " + (testCaseNumber++) + " took " + ((stop - start) / 1000.0) + " seconds.");
    }

    /**
     * Test of add method, of class Calculator.
     */
    @Test(timeout = 500)
    public void testAdd() {
        //System.out.println("add");
        int a = 10;
        int b = 20;
        Calculator instance = new Calculator();
        int expResult = 30;
        int result = instance.add(a, b);
        Assert.assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    @Test
    public void testBoundaryCases() {
        int a = Integer.MAX_VALUE;
        int b = 1;
        long expectedResult = 2147483648l;
        long calculatedResult = new Calculator().add(a, b);
        Assert.assertEquals(expectedResult, calculatedResult);
    }
    
    /**
     * Test of subtract method, of class Calculator.
     */
    @Test
    public void testSubtract() {
        //System.out.println("subtract");
        int a = 0;
        int b = 0;
        Calculator instance = new Calculator();
        int expResult = 0;
        int result = instance.subtract(a, b);
        Assert.assertEquals(expResult, result);
        Assert.assertEquals("Testing test", "Test", "TeST");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
