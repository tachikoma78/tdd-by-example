package Test;

import javafx.util.Pair;
import org.junit.Test;
import wyCash.Bank;
import wyCash.Expression;
import wyCash.Money;
import wyCash.Sum;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertFalse;


/**
 * Based on Ken Beck's "TDD by example"
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

   //  working with addition

    @Test
    public void testReturnsSum(){
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augend);
        assertEquals(five, sum.addend);
    }


    @Test
    public void testSimpleAddition(){
        //Once the operation (like adding up the value of a portfolio) is complete,
        // the resulting Expression can be reduced back a single currency
        // given exchange rates
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    public void testReduceSum(){
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    public void testReduceMoney(){
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testIdentityRate(){
        assertEquals(1, new Bank().rate("USD", "USD"));
    }

    @Test
    public void testMixedCurrencyAddition(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(fiveBucks.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    public void testReduceMoneyDifferentCurrencies(){
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2),"USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    public void testSumPlusMoney(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).plus(fiveBucks);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    public void testSumTimes(){
        Expression fiveBucks = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveBucks, tenFrancs).times(2);
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }



}