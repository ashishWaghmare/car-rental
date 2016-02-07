package in.co.waghmare.core.domain;

import java.math.BigInteger;

/**
 * Created by ashishw on 7/2/16.
 */
public class Money {
    private int majorValue;
    private String currency;

    public Money(String currency, int major) {
        this.currency = currency;
        this.majorValue = major;
    }

    public int getMajorValue() {
        return majorValue;
    }

    public String getCurrency() {
        return currency;
    }
}
