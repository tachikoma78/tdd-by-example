package Test;

import org.junit.Test;
import wyCash.Dollar;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;


/**
 * Created by pierre on 2018-07-11.
 */
public class MultiplicationTest {

    //TODO list for TDD testing
    // $5 + 10 CHF = $10 if CHF:USD is 2:1
    // $5 * 2 = $10  multiplication
    // Make “amount” private
    // Dollar side-effects
    // Money rounding
    // Equals()
    // HashCode()

    @Test
    public void testMultiplicationDoesNotAlterDollar() {
       Dollar five = new Dollar(5);
       Dollar product = five.times(2);
       assertEquals(10, product.amount); // Multiplication
       product = five.times(3);
       assertEquals(15, product.amount); // Dollar side-effects
    }

    @Test
    public void testEquality(){
        assertTrue(new Dollar(5).equals(new Dollar(5)));
    }








}