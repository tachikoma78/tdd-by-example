package Test;

import org.junit.Test;
import wyCash.Dollar;
import wyCash.Money;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Created by pierre on 2018-07-11.
 */
public class MultiplicationTest {

    // We need :
    // 1) add amounts in 2 currencies and convert the result given exchange rates
    // 2) multiply price (amount) per share by number of shares (number) and receive an amount

    //TODO list for TDD testing
    // $5 * 2 = $10  multiplication
    // $5 + 10 CHF = $10 if CHF:USD is 2:1 exhange rate
    // Dollar side-effects
    // Equals()
    // Make “amount” private
    // Money rounding
    // HashCode()
    // Comparing with nulls
    // Comparing with other objects
    // Francs != Dollar

    /* @Test
    public void test_Dollar_Multiplication_Should_Have_NoSideEffect() {
       Dollar five = new Dollar(5);
       assertEquals(new Dollar(10), five.times(2));
       assertEquals(new Dollar(15), five.times(3));
    }

    @Test
    public void test_Franc_Multiplication() {
        Franc five = new Franc(5);
        assertEquals(new Franc(10), five.times(2));
        assertEquals(new Franc(15), five.times(3));
    }
    */
    @Test
    public void testCurrency(){
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    public void testDollarMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3));
    }

    @Test
    public void testFrancMultiplication(){
        Money five = Money.franc(5);
        assertEquals(Money.franc(10), five.times(2));
        assertEquals(Money.franc(15), five.times(3));
    }


    @Test
    public void testEquality(){
        // triangulation test that 5 dollars is not equal to 6 and that 5 is equal to 5.
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertTrue(Money.franc(5).equals(Money.franc(5)));
        assertFalse(Money.franc(5).equals(Money.franc(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5))); // Dollars are not Francs
    }



}