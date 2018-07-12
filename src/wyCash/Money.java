package wyCash;

/**
 * Created by pierre on 2018-07-12.
 */
public class Money {

    // visibility has to change from private to protected
    // so the subclass can still see it.
    protected int amount;
    protected String currency;

    public Money times(int multiplier){
        return new Money(amount * multiplier, currency);
    }

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
