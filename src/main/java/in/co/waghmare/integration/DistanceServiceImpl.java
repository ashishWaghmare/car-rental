package in.co.waghmare.integration;

import in.co.waghmare.core.domain.Location;
import in.co.waghmare.core.domain.Trip;
import in.co.waghmare.core.services.DistanceService;

import java.util.List;

/**
 * Created by ashishw on 7/2/16.
 */
public class DistanceServiceImpl implements DistanceService {
    @Override
    public double distance(Trip trip) {
        List<Location> hops = trip.getHops();
        double finalDistance = 0;
        for (int i = 0; i < hops.size() - 2; i++) {
            finalDistance = finalDistance + distance(hops.get(i), hops.get(i + 1));
        }
        return finalDistance;
    }

    @Override
    public double distance(Location source, Location destination) {
        //order it
        if (source.compareTo(destination) < -1) {
            Location temp = source;
            source = destination;
            destination = temp;
        }
        double value = 0;
        if (source == Location.pune && destination == Location.bangalore) {
            value = 1000.0;
        }
        if (source == Location.pune && destination == Location.mumbai) {
            value = 200.0;
        }
        if (source == Location.mumbai && destination == Location.delhi) {
            value = 1000.0;
        }
        if (source == Location.mumbai && destination == Location.chennai) {
            value = 1234.5;
        }

        //TODO - throw illegal argument if zero
        return value;
    }
}
