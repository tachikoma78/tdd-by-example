package Test;

import org.junit.Test;
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

    @Test // we do 2 times in row to check no spill effect
    public void testDollarMultiplication(){
        Money five = Money.dollar(5);
        assertEquals(Money.dollar(10), five.times(2));
        assertEquals(Money.dollar(15), five.times(3)); // should be 15 and not 30 ((2 * 5) * 3)
    }


    @Test
    public void testEquality(){
        // triangulation test that 5 dollars is not equal to 6 and that 5 is equal to 5.
        assertTrue(Money.dollar(5).equals(Money.dollar(5)));
        assertFalse(Money.dollar(5).equals(Money.dollar(6))); // 5 is not 6
        assertFalse(Money.franc(5).equals(Money.dollar(5))); // Dollar is not Franc
    }

    @Test
    public void testSimpleAddition(){
        Money sum = Money.dollar(5).plus(Money.dollar(5));
        assertEquals(Money.dollar(10), sum);
    }


}