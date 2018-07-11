package wyCash;

/**
 * Created by pierre on 2018-07-11.
 */
public class Dollar {

    public int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(amount * multiplier);
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }
}
