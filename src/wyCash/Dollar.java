package wyCash;

/**
 * Created by pierre on 2018-07-11.
 */
public class Dollar extends Money{

    public Dollar(int amount, String currency){
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return Money.dollar(amount * multiplier);
    }

}
