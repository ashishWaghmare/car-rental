package in.co.waghmare.core.domain;

/**
 * Created by ashishw on 7/2/16.
 */
public class Rate {

    public Rate(int value) {
        this.value = value;
    }

    int value; // Rupees per kilometer;

    public static Rate rupeesPerKilometer(int value) {
        return new Rate(value);
    }

    public int getValue() {
        return value;
    }

    public Rate add(int i) {
        value = this.value + i;
        return this;
    }
}
