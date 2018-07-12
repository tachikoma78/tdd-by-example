package wyCash;

/**
 * Created by pierre on 2018-07-11.
 */
public class Franc extends Money{

    public Franc(int amount, String currency){
        super(amount, currency);
    }

    public Money times(int multiplier) {
        return Money.franc(amount * multiplier);
    }


}
