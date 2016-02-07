package in.co.waghmare.core.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ashishw on 7/2/16.
 */
public class Trip {
    public Vehicle getVehicle() {
        return vehicle;
    }

    public Passengers getPassengers() {
        return passengers;
    }

    public boolean isComplete() {
        return isComplete;
    }

    private final Vehicle vehicle;
    private final Passengers passengers;
    private List<Location> hops;
    private boolean isComplete = false;

    private Trip(Passengers passengers, Vehicle vehicle) {
        this.passengers = passengers;
        this.vehicle = vehicle;
    }

    public Trip startsAt(Location start) {
        hops = new ArrayList<>();
        hops.add(start);
        return this;
    }

    public Trip goes(Location location) {
        if (!isComplete) {
            this.hops.add(location);
        }
        return this;
    }

    public Trip endsAt(Location location) {
        if (!isComplete) {
            goes(location);
            isComplete = true;
        }
    }
}
