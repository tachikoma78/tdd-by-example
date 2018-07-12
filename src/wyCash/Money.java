package wyCash;

/**
 * Created by pierre on 2018-07-12.
 */
public abstract class Money {

    // visibility has to change from private to protected
    // so the subclass can still see it.
    protected int amount;
    protected String currency;

    public String currency() {
        return currency;
    }

    public abstract Money times(int multiplier);

    Money(int amount, String currency){
        this.amount = amount;
        this.currency = currency;
    }

    // "value object" pattern: MUST return new object every time
    public static Dollar dollar(int amount){
        return new Dollar(amount, "USD"); 
    }

    public static Franc franc(int amount){
        return new Franc(amount, "CHF");
    }

    @Override
    public boolean equals(Object object) {
        Money money = (Money) object;
        // Francs != Dollar
        return amount == money.amount && getClass().equals(money.getClass());
    }

}
