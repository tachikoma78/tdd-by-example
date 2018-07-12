package Test;

import org.junit.Test;
import wyCash.Franc;
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
    public void testEquality(){
        // triangulation test that 5 dollars is not equal to 6 and that 5 is equal to 5.
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6)));
        assertFalse(Money.franc(5).equals(Money.dollar(5))); // Dollars are not Francs
    }


}