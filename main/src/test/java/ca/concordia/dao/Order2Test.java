package ca.concordia.dao;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class contains test details of Order class
 */
public class Order2Test {
    Order2 d_Order2;

    /**
     * This is the method to be run before test method. It initializes the Order class object
     */

    @Before
    public void before() {
        d_Order2 = new Order2("deploy", "canada", 2);
    }

    /**
     * This test method uses assert statement to test expected OrderCommand with actual OrderCommand
     */

    @Test
    public void getOrder() {
        assertEquals(2, d_Order2.getArmyCount());

    }
}