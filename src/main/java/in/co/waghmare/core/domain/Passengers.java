package in.co.waghmare.core.domain;

/**
 * Created by ashishw on 7/2/16.
 */
public class Passengers {
    final int size;

    private Passengers(int noOfPassengers) {
        size = noOfPassengers;
    }

    public static Passengers size(int size) {
        return new Passengers(size);
    }
}
