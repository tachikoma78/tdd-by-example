package wyCash;

/**
 * Based on Ken Beck's "TDD by example"
 */
public interface Expression {

    Money reduce(Bank bank, String to);
    Expression plus(Expression addend);
    Expression times(int multiplier);

}
