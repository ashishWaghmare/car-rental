package in.co.waghmare.core.domain;

import java.math.BigInteger;

/**
 * Created by ashishw on 7/2/16.
 */
public class Money {
    int majorValue;
    int minorValue;
    String currency;

    public Money(String currency, int major, int minor) {
        this.currency = currency;
        this.majorValue = major;
        this.minorValue = major;
    }
}
