package wyCash;

/**
 * Based on Ken Beck's "TDD by example"
 */
public class Money implements Expression{

    // visibility has to change from private to protected
    // so the subclass can still see it.
    protected int amount;
    protected String currency;

    public Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    // "value object" pattern: MUST return new object every time
    public static Money dollar(int amount){
        return new Money(amount, "USD");
    }

    public static Money franc(int amount){
        return new Money(amount, "CHF");
    }

    public Expression times(int multiplier){
        return new Money(amount * multiplier, currency);
    }

    /*
    public Expression plus(Money addend) {
        return new Sum(this, addend);
    }
    */

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }


    public Money reduce(Bank bank, String to){
       int rate = bank.rate(currency, to);
       return new Money(amount / rate, to);
    }

    public String currency() {
        return currency;
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        return amount == money.amount && currency().equals(money.currency());
    }

    @Override
    public String toString() {
        return amount + "" +  currency;
    }


}
